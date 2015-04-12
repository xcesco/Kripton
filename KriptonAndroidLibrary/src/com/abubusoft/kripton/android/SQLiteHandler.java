package com.abubusoft.kripton.android;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import com.abubusoft.kripton.android.adapter.Adapter;
import com.abubusoft.kripton.android.adapter.SqliteAdapter;
import com.abubusoft.kripton.database.AbstractDatabaseHandler;
import com.abubusoft.kripton.database.ColumnType;
import com.abubusoft.kripton.database.DatabaseColumn;
import com.abubusoft.kripton.database.DatabaseTable;
import com.abubusoft.kripton.database.DeleteOptions;
import com.abubusoft.kripton.database.Filter;
import com.abubusoft.kripton.database.InsertOptions;
import com.abubusoft.kripton.database.QueryOptions;
import com.abubusoft.kripton.database.SQLStatement;
import com.abubusoft.kripton.database.UpdateOptions;

import android.content.ContentValues;

public class SQLiteHandler extends AbstractDatabaseHandler<SQLiteQuery, SQLiteInsert, SQLiteUpdate, SQLiteDelete> {

	private static final long serialVersionUID = -8926461587267041987L;

	protected ThreadLocal<ContentValues> values = new ThreadLocal<ContentValues>();

	public SQLiteHandler() {
		values.set(new ContentValues());
	}

	/* (non-Javadoc)
	 * @see com.abubusoft.kripton.database.AbstractDatabaseHandler#createDelete(com.abubusoft.kripton.database.DatabaseTable, com.abubusoft.kripton.database.DeleteOptions)
	 */
	@Override
	public SQLiteDelete createDelete(DatabaseTable table, DeleteOptions options) {		
		SQLiteDelete delete = super.createDelete(table, options);
		
		buildColumnAdapters(delete, delete.columnAdapter);
		buildWhereAdapters(delete.filter, delete.filterAdapter);

		return delete;
	}

	public void init() {
		if (mapToType == null) {
			mapToType = new HashMap<>();

			// TEXT
			{
				Class<?> classes[] = { String.class, Enum.class };

				for (int i = 0; i < classes.length; i++) {
					mapToType.put(classes[i], "TEXT");
				}
			}

			// INTEGER
			{
				Class<?> classes[] = { boolean.class, Boolean.class, int.class, Integer.class, long.class, Long.class };

				for (int i = 0; i < classes.length; i++) {
					mapToType.put(classes[i], "INTEGER");
				}
			}

			// NUMERIC

			// REAL
			{
				Class<?> classes[] = { float.class, Float.class, double.class, Double.class, BigDecimal.class };

				for (int i = 0; i < classes.length; i++) {
					mapToType.put(classes[i], "REAL");
				}
			}

			// BLOB
			{
				Class<?> classes[] = { (new byte[0]).getClass() };

				for (int i = 0; i < classes.length; i++) {
					mapToType.put(classes[i], "BLOB");
				}
			}
		}
	}

	public String createTableSQL(DatabaseTable table) {
		DatabaseColumn column;
		String separator = "";
		StringBuffer sb = new StringBuffer();

		sb.append("create table " + table.name + " (");

		for (int i = 0; i < table.columns.size(); i++) {
			column = table.columns.get(i);
			sb.append(separator + column.name);
			// type
			sb.append(" " + column.type);

			// index options
			switch (column.feature) {
			case PRIMARY_KEY:
				sb.append(" primary key autoincrement");
				break;
			case UNIQUE_KEY:
				sb.append(" unique");
				break;
			default:
				break;
			}

			// nullable
			if (column.feature != ColumnType.PRIMARY_KEY && !column.schema.getColumnInfo().nullable) {
				sb.append(" not null");
			}

			separator = ", ";
		}
		sb.append(");");

		return sb.toString();
	}

	public String dropTableSQL(DatabaseTable table) {
		StringBuffer sb = new StringBuffer();
		sb.append("drop table if exists " + table.name + " ");
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.abubusoft.kripton.database.AbstractDatabaseHandler#getInsert(com.
	 * abubusoft.kripton.database.DatabaseTable,
	 * com.abubusoft.kripton.database.InsertOptions)
	 */
	@Override
	public SQLiteInsert createInsert(DatabaseTable table, InsertOptions options) {
		SQLiteInsert insert = super.createInsert(table, options);
		buildColumnAdapters(insert, insert.columnAdapter);
		
		return insert;
	}

	private void buildColumnAdapters(SQLStatement statement, @SuppressWarnings("rawtypes") ArrayList<SqliteAdapter> columnAdapter) {
		DatabaseColumn col;

		for (int i = 0; i < statement.columns.length; i++) {
			col = statement.columns[i];
			columnAdapter.add(Adapter.lookup(col.schema.getFieldType()));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.abubusoft.kripton.database.AbstractDatabaseHandler#getQuery(com.abubusoft
	 * .kripton.database.DatabaseTable,
	 * com.abubusoft.kripton.database.QueryOptions)
	 */
	@Override
	public SQLiteQuery createQuery(DatabaseTable table, QueryOptions options) {
		SQLiteQuery query = super.createQuery(table, options);
		
		buildColumnAdapters(query, query.columnAdapter);
		buildWhereAdapters(query.filter, query.filterAdapter);

		return query;
	}

	@SuppressWarnings("rawtypes")
	private void buildWhereAdapters(Filter filter, ArrayList<SqliteAdapter> filterAdapter) {
		Field field;
		for (int i = 0; i < filter.fieldNames.length; i++) {
			field = filter.field[i];
			filterAdapter.add(Adapter.lookup(field.getType()));
		}
	}

	@Override
	protected SQLiteQuery newQuery() {
		return new SQLiteQuery();
	}

	@Override
	public String getColumnType(Class<?> fieldType) {
		if (fieldType.isEnum()) {
			return mapToType.get(Enum.class);
		}
		return mapToType.get(fieldType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.abubusoft.kripton.database.AbstractDatabaseHandler#createUpdate(com
	 * .abubusoft.kripton.database.DatabaseTable,
	 * com.abubusoft.kripton.database.UpdateOptions)
	 */
	@Override
	public SQLiteUpdate createUpdate(DatabaseTable table, UpdateOptions options) {
		SQLiteUpdate update = super.createUpdate(table, options);
		buildColumnAdapters(update, update.columnAdapter);
		
		return update;
	}

	@Override
	protected SQLiteInsert newInsert() {
		return new SQLiteInsert();
	}

	@Override
	protected SQLiteUpdate newUpdate() {
		return new SQLiteUpdate();
	}

	@Override
	protected SQLiteDelete newDelete() {
		return new SQLiteDelete();
	}

}
