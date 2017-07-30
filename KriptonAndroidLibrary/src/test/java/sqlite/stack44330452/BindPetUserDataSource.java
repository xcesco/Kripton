package sqlite.stack44330452;

import android.database.sqlite.SQLiteDatabase;
import com.abubusoft.kripton.android.Logger;
import com.abubusoft.kripton.android.sqlite.AbstractDataSource;
import com.abubusoft.kripton.android.sqlite.DataSourceOptions;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import java.lang.Override;
import java.lang.Throwable;

/**
 * <p>
 * Rapresents implementation of datasource PetUserDataSource.
 * This class expose database interface through Dao attribute.
 * </p>
 *
 * @see PetUserDataSource
 * @see BindPetUserDaoFactory
 * @see UserDao
 * @see UserDaoImpl
 * @see User
 * @see PetDao
 * @see PetDaoImpl
 * @see Pet
 */
public class BindPetUserDataSource extends AbstractDataSource implements BindPetUserDaoFactory, PetUserDataSource {
  /**
   * <p>datasource singleton</p>
   */
  private static BindPetUserDataSource instance;

  /**
   * <p>dao instance</p>
   */
  protected UserDaoImpl userDao = new UserDaoImpl(this);

  /**
   * <p>dao instance</p>
   */
  protected PetDaoImpl petDao = new PetDaoImpl(this);

  protected BindPetUserDataSource(DataSourceOptions options) {
    super("pet.db", 1, options);
  }

  @Override
  public UserDaoImpl getUserDao() {
    return userDao;
  }

  @Override
  public PetDaoImpl getPetDao() {
    return petDao;
  }

  /**
   * <p>Executes a transaction. This method <strong>is thread safe</strong> to avoid concurrent problems. Thedrawback is only one transaction at time can be executed. The database will be open in write mode.</p>
   *
   * @param transaction
   * 	transaction to execute
   */
  public void execute(Transaction transaction) {
    SQLiteDatabase connection=openWritableDatabase();
    try {
      connection.beginTransaction();
      if (transaction!=null && transaction.onExecute(this)) {
        connection.setTransactionSuccessful();
      }
    } catch(Throwable e) {
      Logger.error(e.getMessage());
      e.printStackTrace();
      if (transaction!=null) transaction.onError(e);
    } finally {
      try {
        connection.endTransaction();
      } catch (Throwable e) {
        Logger.warn("error closing transaction %s", e.getMessage());
      }
      close();
    }
  }

  /**
   * instance
   */
  public static BindPetUserDataSource instance() {
    if (instance==null) {
      instance=new BindPetUserDataSource(null);
    }
    return instance;
  }

  /**
   * Retrieve data source instance and open it.
   * @return opened dataSource instance.
   */
  public static BindPetUserDataSource open() {
    if (instance==null) {
      instance=new BindPetUserDataSource(null);
    }
    instance.openWritableDatabase();
    return instance;
  }

  /**
   * Retrieve data source instance and open it in read only mode.
   * @return opened dataSource instance.
   */
  public static BindPetUserDataSource openReadOnly() {
    if (instance==null) {
      instance=new BindPetUserDataSource(null);
    }
    instance.openReadOnlyDatabase();
    return instance;
  }

  /**
   * onCreate
   */
  @Override
  public void onCreate(SQLiteDatabase database) {
    // generate tables
    Logger.info("DDL: %s",UserTable.CREATE_TABLE_SQL);
    database.execSQL(UserTable.CREATE_TABLE_SQL);
    Logger.info("DDL: %s",PetTable.CREATE_TABLE_SQL);
    database.execSQL(PetTable.CREATE_TABLE_SQL);
    if (options.databaseLifecycleHandler != null) {
      options.databaseLifecycleHandler.onCreate(database);
    }
  }

  /**
   * onUpgrade
   */
  @Override
  public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
    if (options.databaseLifecycleHandler != null) {
      options.databaseLifecycleHandler.onUpdate(database, oldVersion, newVersion, true);
    } else {
      // drop tables
      Logger.info("DDL: %s",PetTable.DROP_TABLE_SQL);
      database.execSQL(PetTable.DROP_TABLE_SQL);
      Logger.info("DDL: %s",UserTable.DROP_TABLE_SQL);
      database.execSQL(UserTable.DROP_TABLE_SQL);

      // generate tables
      Logger.info("DDL: %s",UserTable.CREATE_TABLE_SQL);
      database.execSQL(UserTable.CREATE_TABLE_SQL);
      Logger.info("DDL: %s",PetTable.CREATE_TABLE_SQL);
      database.execSQL(PetTable.CREATE_TABLE_SQL);
    }
  }

  /**
   * onConfigure
   */
  @Override
  public void onConfigure(SQLiteDatabase database) {
    // configure database
    database.setForeignKeyConstraintsEnabled(true);
    if (options.databaseLifecycleHandler != null) {
      options.databaseLifecycleHandler.onConfigure(database);
    }
  }

  /**
   * Build instance.
   * @return dataSource instance.
   */
  public static PetUserDataSource build(DataSourceOptions options) {
    if (instance==null) {
      instance=new BindPetUserDataSource(options);
    }
    instance.openWritableDatabase();
    return instance;
  }

  /**
   * interface to define transactions
   */
  public interface Transaction extends AbstractTransaction<BindPetUserDaoFactory> {
  }

  /**
   * Simple class implements interface to define transactions
   */
  public abstract static class SimpleTransaction implements Transaction {
    @Override
    public void onError(Throwable e) {
      throw(new KriptonRuntimeException(e));
    }
  }
}
