package sqlite.feature.foreignkey;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.abubusoft.kripton.android.KriptonLibrary;
import com.abubusoft.kripton.android.Logger;
import com.abubusoft.kripton.android.sqlite.AbstractDataSource;
import com.abubusoft.kripton.android.sqlite.DataSourceOptions;
import com.abubusoft.kripton.android.sqlite.SQLContext;
import com.abubusoft.kripton.android.sqlite.SQLContextInSessionImpl;
import com.abubusoft.kripton.android.sqlite.SQLiteTable;
import com.abubusoft.kripton.android.sqlite.SQLiteUpdateTask;
import com.abubusoft.kripton.android.sqlite.SQLiteUpdateTaskHelper;
import com.abubusoft.kripton.android.sqlite.TransactionResult;
import com.abubusoft.kripton.common.Pair;
import com.abubusoft.kripton.exception.KriptonRuntimeException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * <p>
 * Implementation of the DummyDataSource datasource.
 * This class expose database interface through Dao attribute.
 * </p>
 *
 * @see DummyDataSource
 * @see BindDummyDaoFactory
 * @see DaoBeanA_1
 * @see DaoBeanA_1Impl
 * @see BeanA_1
 * @see DaoBeanA_2
 * @see DaoBeanA_2Impl
 * @see BeanA_2
 */
public class BindDummyDataSource extends AbstractDataSource implements BindDummyDaoFactory, DummyDataSource {
  /**
   * <p>datasource singleton</p>
   */
  static volatile BindDummyDataSource instance;

  /**
   * <p>Mutex to manage multithread access to instance</p>
   */
  private static final Object mutex = new Object();

  /**
   * Unique identifier for Dao DaoBeanA_1
   */
  public static final int DAO_BEAN_A_1_UID = 0;

  /**
   * Unique identifier for Dao DaoBeanA_2
   */
  public static final int DAO_BEAN_A_2_UID = 1;

  /**
   * List of tables compose datasource
   */
  static final SQLiteTable[] TABLES = {new BeanA_1Table(), new BeanA_2Table()};

  /**
   * <p>dao instance</p>
   */
  protected DaoBeanA_1Impl daoBeanA_1 = new DaoBeanA_1Impl(this);

  /**
   * <p>dao instance</p>
   */
  protected DaoBeanA_2Impl daoBeanA_2 = new DaoBeanA_2Impl(this);

  /**
   * Used only in transactions (that can be executed one for time
   */
  protected DataSourceSingleThread _daoFactorySingleThread = new DataSourceSingleThread();

  protected BindDummyDataSource(DataSourceOptions options) {
    super("test.db", 1, options);
  }

  @Override
  public DaoBeanA_1Impl getDaoBeanA_1() {
    return daoBeanA_1;
  }

  @Override
  public DaoBeanA_2Impl getDaoBeanA_2() {
    return daoBeanA_2;
  }

  /**
   * <p>Executes a transaction. This method <strong>is thread safe</strong> to avoid concurrent problems. The drawback is only one transaction at time can be executed. The database will be open in write mode. This method uses default error listener to intercept errors.</p>
   *
   * @param transaction
   * 	transaction to execute
   * @return <code>true</code> if transaction successful finished
   */
  public boolean execute(Transaction transaction) {
    return execute(transaction, onErrorListener);
  }

  /**
   * <p>Executes a transaction. This method <strong>is thread safe</strong> to avoid concurrent problems. The drawback is only one transaction at time can be executed. The database will be open in write mode.</p>
   *
   * @param transaction
   * 	transaction to execute
   * @param onErrorListener
   * 	error listener
   * @return <code>true</code> if transaction successful finished
   */
  public boolean execute(Transaction transaction,
      AbstractDataSource.OnErrorListener onErrorListener) {
    // open database in thread safe mode
    Pair<Boolean, SupportSQLiteDatabase> _status=openDatabaseThreadSafeMode(true);
    boolean success=false;
    SupportSQLiteDatabase connection=_status.value1;
    DataSourceSingleThread currentDaoFactory=_daoFactorySingleThread.bindToThread();
    currentDaoFactory.onSessionOpened();
    try {
      connection.beginTransaction();
      if (transaction!=null && TransactionResult.COMMIT == transaction.onExecute(currentDaoFactory)) {
        connection.setTransactionSuccessful();
        success=true;
      }
    } catch(Throwable e) {
      Logger.error(e.getMessage());
      e.printStackTrace();
      if (onErrorListener!=null) onErrorListener.onError(e);
    } finally {
      try {
        connection.endTransaction();
      } catch (Throwable e) {
        Logger.warn("error closing transaction %s", e.getMessage());
      }
      // close database in thread safe mode
      closeThreadSafeMode(_status);
      if (success) { currentDaoFactory.onSessionClosed(); } else { currentDaoFactory.onSessionClear(); }
    }
    return success;
  }

  /**
   * <p>Executes a transaction in async mode. This method <strong>is thread safe</strong> to avoid concurrent problems. The drawback is only one transaction at time can be executed. The database will be open in write mode. This method uses default error listener to intercept errors.</p>
   *
   * @param transaction
   * 	transaction to execute
   * @param onErrorListener
   * 	listener for errors
   * @return <code>true</code> when transaction successful finished
   */
  public Future<Boolean> executeAsync(final Transaction transaction,
      final AbstractDataSource.OnErrorListener onErrorListener) {
    return KriptonLibrary.getExecutorService().submit(new Callable<Boolean>() {
      @Override
      public Boolean call() throws Exception {
        return execute(transaction, onErrorListener);
      }
    });
  }

  /**
   * <p>Executes a transaction in async mode. This method <strong>is thread safe</strong> to avoid concurrent problems. The drawback is only one transaction at time can be executed. The database will be open in write mode. This method uses default error listener to intercept errors.</p>
   *
   * @param transaction
   * 	transaction to execute
   * @return <code>true</code> when transaction successful finished
   */
  public Future<Boolean> executeAsync(final Transaction transaction) {
    return KriptonLibrary.getExecutorService().submit(new Callable<Boolean>() {
      @Override
      public Boolean call() throws Exception {
        return execute(transaction, onErrorListener);
      }
    });
  }

  /**
   * <p>Executes a batch command in async mode. This method <strong>is thread safe</strong> to avoid concurrent problems. The drawback is only one transaction at time can be executed. The database will be open in write mode. This method uses default error listener to intercept errors.</p>
   *
   * @param commands
   * 	commands to execute
   * @param writeMode
   * 	rue if you need to writeable connection
   * @return <code>true</code> when transaction successful finished
   */
  public <T> Future<T> executeBatchAsync(final Batch<T> commands, final boolean writeMode) {
    return KriptonLibrary.getExecutorService().submit(new Callable<T>() {
      @Override
      public T call() throws Exception {
        return executeBatch(commands, writeMode);
      }
    });
  }

  /**
   * <p>Executes a batch command in async mode. This method <strong>is thread safe</strong> to avoid concurrent problems. The drawback is only one transaction at time can be executed. The database will be open in write mode. This method uses default error listener to intercept errors.</p>
   *
   * @param commands
   * 	commands to execute
   * @return <code>true</code> when transaction successful finished
   */
  public <T> Future<T> executeBatchAsync(final Batch<T> commands) {
    return KriptonLibrary.getExecutorService().submit(new Callable<T>() {
      @Override
      public T call() throws Exception {
        return executeBatch(commands, false);
      }
    });
  }

  /**
   * <p>Executes a batch opening a read only connection. This method <strong>is thread safe</strong> to avoid concurrent problems.</p>
   *
   * @param commands
   * 	batch to execute
   */
  public <T> T executeBatch(Batch<T> commands) {
    return executeBatch(commands, false);
  }

  /**
   * <p>Executes a batch. This method <strong>is thread safe</strong> to avoid concurrent problems. The drawback is only one transaction at time can be executed. if <code>writeMode</code> is set to false, multiple batch operations is allowed.</p>
   *
   * @param commands
   * 	batch to execute
   * @param writeMode
   * 	true to open connection in write mode, false to open connection in read only mode
   */
  public <T> T executeBatch(Batch<T> commands, boolean writeMode) {
    // open database in thread safe mode
    Pair<Boolean, SupportSQLiteDatabase> _status=openDatabaseThreadSafeMode(writeMode);
    DataSourceSingleThread currentDaoFactory=new DataSourceSingleThread();
    currentDaoFactory.onSessionOpened();
    try {
      if (commands!=null) {
        return commands.onExecute(currentDaoFactory);
      }
    } catch(Throwable e) {
      Logger.error(e.getMessage());
      e.printStackTrace();
      throw(e);
    } finally {
      // close database in thread safe mode
      closeThreadSafeMode(_status);
      currentDaoFactory.onSessionClosed();
    }
    return null;
  }

  /**
   * <p>Retrieve instance.</p>
   */
  public static BindDummyDataSource getInstance() {
    BindDummyDataSource result=instance;
    if (result==null) {
      synchronized(mutex) {
        result=instance;
        if (result==null) {
          DataSourceOptions options=DataSourceOptions.builder()
          	.inMemory(false)
          	.log(true)
          	.neverClose(false)
          	.build();
          instance=result=new BindDummyDataSource(options);
          try {
            instance.openWritableDatabase();
            instance.close();
          } catch(Throwable e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
          }
        }
      }
    }
    return result;
  }

  /**
   * Retrieve data source instance and open it.
   * @return opened dataSource instance.
   */
  public static BindDummyDataSource open() {
    BindDummyDataSource instance=getInstance();
    instance.openWritableDatabase();
    return instance;
  }

  /**
   * Retrieve data source instance and open it in read only mode.
   * @return opened dataSource instance.
   */
  public static BindDummyDataSource openReadOnly() {
    BindDummyDataSource instance=getInstance();
    instance.openReadOnlyDatabase();
    return instance;
  }

  /**
   * onCreate
   */
  @Override
  protected void onCreate(SupportSQLiteDatabase database) {
    // generate tables
    // log section create BEGIN
    if (this.logEnabled) {
      if (options.inMemory) {
        Logger.info("Create database in memory");
      } else {
        Logger.info("Create database '%s' version %s",this.name, this.version);
      }
    }
    // log section create END
    // log section create BEGIN
    if (this.logEnabled) {
      Logger.info("DDL: %s",BeanA_2Table.CREATE_TABLE_SQL);
    }
    // log section create END
    database.execSQL(BeanA_2Table.CREATE_TABLE_SQL);
    // log section create BEGIN
    if (this.logEnabled) {
      Logger.info("DDL: %s",BeanA_1Table.CREATE_TABLE_SQL);
    }
    // log section create END
    database.execSQL(BeanA_1Table.CREATE_TABLE_SQL);
    if (options.databaseLifecycleHandler != null) {
      options.databaseLifecycleHandler.onCreate(database);
    }
    justCreated=true;
  }

  /**
   * onUpgrade
   */
  @Override
  protected void onUpgrade(SupportSQLiteDatabase database, int previousVersion,
      int currentVersion) {
    // log section BEGIN
    if (this.logEnabled) {
      Logger.info("Update database '%s' from version %s to version %s",this.name, previousVersion, currentVersion);
    }
    // log section END
    // if we have a list of update task, try to execute them
    if (options.updateTasks != null) {
      List<SQLiteUpdateTask> tasks = buildTaskList(previousVersion, currentVersion);
      for (SQLiteUpdateTask task : tasks) {
        // log section BEGIN
        if (this.logEnabled) {
          Logger.info("Begin update database from version %s to %s", previousVersion, previousVersion+1);
        }
        // log section END
        task.execute(database, previousVersion, previousVersion+1);
        // log section BEGIN
        if (this.logEnabled) {
          Logger.info("End update database from version %s to %s", previousVersion, previousVersion+1);
        }
        // log section END
        previousVersion++;
      }
    } else {
      // drop all tables
      SQLiteUpdateTaskHelper.dropTablesAndIndices(database);

      // generate tables
      // log section BEGIN
      if (this.logEnabled) {
        Logger.info("DDL: %s",BeanA_2Table.CREATE_TABLE_SQL);
      }
      // log section END
      database.execSQL(BeanA_2Table.CREATE_TABLE_SQL);
      // log section BEGIN
      if (this.logEnabled) {
        Logger.info("DDL: %s",BeanA_1Table.CREATE_TABLE_SQL);
      }
      // log section END
      database.execSQL(BeanA_1Table.CREATE_TABLE_SQL);
    }
    if (options.databaseLifecycleHandler != null) {
      options.databaseLifecycleHandler.onUpdate(database, previousVersion, currentVersion, true);
    }
  }

  /**
   * Returns <code>true</code> if database needs foreign keys.
   */
  @Override
  public boolean hasForeignKeys() {
    return true;
  }

  public void clearCompiledStatements() {
    DaoBeanA_1Impl.clearCompiledStatements();
    DaoBeanA_2Impl.clearCompiledStatements();
  }

  /**
   * <p>Build instance. This method can be used only one time, on the application start.</p>
   */
  public static BindDummyDataSource build(DataSourceOptions options) {
    if (options.forceBuild && instance!=null) {
      Logger.info("Datasource BindDummyDataSource is forced to be (re)builded");
      instance=null;
    }
    BindDummyDataSource result=instance;
    if (result==null) {
      synchronized(mutex) {
        result=instance;
        if (result==null) {
          instance=result=new BindDummyDataSource(options);
          try {
            instance.openWritableDatabase();
            instance.close();
            // force database DDL run
            if (options.populator!=null && instance.justCreated) {
              // run populator only a time
              instance.justCreated=false;
              // run populator
              options.populator.execute();
            }
          } catch(Throwable e) {
            Logger.error(e.getMessage());
            e.printStackTrace();
          }
        } else {
          throw new KriptonRuntimeException("Datasource BindDummyDataSource is already builded");
        }
      }
    } else {
      throw new KriptonRuntimeException("Datasource BindDummyDataSource is already builded");
    }
    Logger.info("Datasource BindDummyDataSource is created");
    return result;
  }

  /**
   * List of tables compose datasource:
   */
  public static SQLiteTable[] getTables() {
    return TABLES;
  }

  /**
   * Rapresents transational operation.
   */
  public interface Transaction extends AbstractDataSource.AbstractExecutable<BindDummyDaoFactory> {
    /**
     * Execute transation. Method need to return {@link TransactionResult#COMMIT} to commit results
     * or {@link TransactionResult#ROLLBACK} to rollback.
     * If exception is thrown, a rollback will be done.
     *
     * @param daoFactory
     * @return
     * @throws Throwable
     */
    TransactionResult onExecute(@NonNull BindDummyDaoFactory daoFactory);
  }

  /**
   * Rapresents batch operation.
   */
  public interface Batch<T> {
    /**
     * Execute batch operations.
     *
     * @param daoFactory
     * @throws Throwable
     */
    T onExecute(@NonNull BindDummyDaoFactory daoFactory);
  }

  class DataSourceSingleThread implements BindDummyDaoFactory {
    private SQLContextInSessionImpl _context;

    protected DaoBeanA_1Impl _daoBeanA_1;

    protected DaoBeanA_2Impl _daoBeanA_2;

    DataSourceSingleThread() {
      _context=new SQLContextInSessionImpl(BindDummyDataSource.this);
    }

    /**
     *
     * retrieve dao DaoBeanA_1
     */
    public DaoBeanA_1Impl getDaoBeanA_1() {
      if (_daoBeanA_1==null) {
        _daoBeanA_1=new DaoBeanA_1Impl(this);
      }
      return _daoBeanA_1;
    }

    /**
     *
     * retrieve dao DaoBeanA_2
     */
    public DaoBeanA_2Impl getDaoBeanA_2() {
      if (_daoBeanA_2==null) {
        _daoBeanA_2=new DaoBeanA_2Impl(this);
      }
      return _daoBeanA_2;
    }

    @Override
    public SQLContext getContext() {
      return _context;
    }

    protected void onSessionOpened() {
    }

    protected void onSessionClear() {
    }

    protected void onSessionClosed() {
    }

    public DataSourceSingleThread bindToThread() {
      return this;
    }
  }
}
