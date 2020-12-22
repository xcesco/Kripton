package sqlite.feature.optional.model;

import com.abubusoft.kripton.android.sqlite.SQLiteTable;

/**
 * <p>
 * Entity <code>Artist</code> is associated to table <code>artist</code>
 * This class represents table associated to entity.
 * </p>
 *  @see Artist
 */
public class ArtistTable implements SQLiteTable {
  /**
   * Costant represents typeName of table artist
   */
  public static final String TABLE_NAME = "artist";

  /**
   * <p>
   * DDL to create table artist
   * </p>
   *
   * <pre>CREATE TABLE artist (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, data BLOB, title TEXT);</pre>
   */
  public static final String CREATE_TABLE_SQL = "CREATE TABLE artist (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, data BLOB, title TEXT);";

  /**
   * <p>
   * DDL to drop table artist
   * </p>
   *
   * <pre>DROP TABLE IF EXISTS artist;</pre>
   */
  public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS artist;";

  /**
   * Entity's property <code>id</code> is associated to table column <code>id</code>. This costant represents column name.
   *
   *  @see Artist#id
   */
  public static final String COLUMN_ID = "id";

  /**
   * Entity's property <code>data</code> is associated to table column <code>data</code>. This costant represents column name.
   *
   *  @see Artist#data
   */
  public static final String COLUMN_DATA = "data";

  /**
   * Entity's property <code>title</code> is associated to table column <code>title</code>. This costant represents column name.
   *
   *  @see Artist#title
   */
  public static final String COLUMN_TITLE = "title";

  /**
   * Columns array
   */
  private static final String[] COLUMNS = {COLUMN_ID, COLUMN_DATA, COLUMN_TITLE};

  /**
   * for attribute data serialization
   */
  public static byte[] serializeData(byte[] value) {
    return value;
  }

  /**
   * for attribute data parsing
   */
  public static byte[] parseData(byte[] input) {
    return input;
  }

  /**
   * Columns array
   */
  @Override
  public String[] columns() {
    return COLUMNS;
  }

  /**
   * table name
   */
  @Override
  public String name() {
    return TABLE_NAME;
  }
}
