package sqlite.feature.relations.case4.persistence;

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
import sqlite.feature.relations.case4.model.ArticleTable;
import sqlite.feature.relations.case4.model.ChannelTable;

/**
 * <p>
 * Implementation of the RssDataSource datasource.
 * This class expose database interface through Dao attribute.
 * </p>
 *
 * @see RssDataSource
 * @see BindRssDaoFactory
 * @see DaoArticle
 * @see DaoArticleImpl
 * @see Article
 * @see DaoChannel
 * @see DaoChannelImpl
 * @see Channel
 */
public class BindRssDataSource extends AbstractDataSource implements BindRssDaoFactory, RssDataSource {
  /**
   * <p>datasource singleton</p>
   */
  static volatile BindRssDataSource instance;

  /**
   * <p>Mutex to manage multithread access to instance</p>
   */
  private static final Object mutex = new Object();

  /**
   * Unique identifier for Dao DaoArticle
   */
  public static final int DAO_ARTICLE_UID = 0;

  /**
   * Unique identifier for Dao DaoChannel
   */
  public static final int DAO_CHANNEL_UID = 1;

  /**
   * List of tables compose datasource
   */
  static final SQLiteTable[] TABLES = {new ArticleTable(), new ChannelTable()};

  /**
   * <p>dao instance</p>
   */
  protected DaoArticleImpl daoArticle = new DaoArticleImpl(this);

  /**
   * <p>dao instance</p>
   */
  protected DaoChannelImpl daoChannel = new DaoChannelImpl(this);

  /**
   * Used only in transactions (that can be executed one for time
   */
  protected DataSourceSingleThread _daoFactorySingleThread = new DataSourceSingleThread();

  protected BindRssDataSource(DataSourceOptions options) {
    super("rss.db", 1, options);
  }

  @Override
  public DaoArticleImpl getDaoArticle() {
    return daoArticle;
  }

  @Override
  public DaoChannelImpl getDaoChannel() {
    return daoChannel;
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
  public static BindRssDataSource getInstance() {
    BindRssDataSource result=instance;
    if (result==null) {
      synchronized(mutex) {
        result=instance;
        if (result==null) {
          DataSourceOptions options=DataSourceOptions.builder()
          	.inMemory(false)
          	.log(true)
          	.build();
          instance=result=new BindRssDataSource(options);
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
  public static BindRssDataSource open() {
    BindRssDataSource instance=getInstance();
    instance.openWritableDatabase();
    return instance;
  }

  /**
   * Retrieve data source instance and open it in read only mode.
   * @return opened dataSource instance.
   */
  public static BindRssDataSource openReadOnly() {
    BindRssDataSource instance=getInstance();
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
      Logger.info("DDL: %s",ChannelTable.CREATE_TABLE_SQL);
    }
    // log section create END
    database.execSQL(ChannelTable.CREATE_TABLE_SQL);
    // log section create BEGIN
    if (this.logEnabled) {
      Logger.info("DDL: %s",ArticleTable.CREATE_TABLE_SQL);
    }
    // log section create END
    database.execSQL(ArticleTable.CREATE_TABLE_SQL);
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
        Logger.info("DDL: %s",ChannelTable.CREATE_TABLE_SQL);
      }
      // log section END
      database.execSQL(ChannelTable.CREATE_TABLE_SQL);
      // log section BEGIN
      if (this.logEnabled) {
        Logger.info("DDL: %s",ArticleTable.CREATE_TABLE_SQL);
      }
      // log section END
      database.execSQL(ArticleTable.CREATE_TABLE_SQL);
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
    DaoArticleImpl.clearCompiledStatements();
    DaoChannelImpl.clearCompiledStatements();
  }

  /**
   * <p>Build instance. This method can be used only one time, on the application start.</p>
   */
  public static BindRssDataSource build(DataSourceOptions options) {
    if (options.forceBuild && instance!=null) {
      Logger.info("Datasource BindRssDataSource is forced to be (re)builded");
      instance=null;
    }
    BindRssDataSource result=instance;
    if (result==null) {
      synchronized(mutex) {
        result=instance;
        if (result==null) {
          instance=result=new BindRssDataSource(options);
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
          throw new KriptonRuntimeException("Datasource BindRssDataSource is already builded");
        }
      }
    } else {
      throw new KriptonRuntimeException("Datasource BindRssDataSource is already builded");
    }
    Logger.info("Datasource BindRssDataSource is created");
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
  public interface Transaction extends AbstractDataSource.AbstractExecutable<BindRssDaoFactory> {
    /**
     * Execute transation. Method need to return {@link TransactionResult#COMMIT} to commit results
     * or {@link TransactionResult#ROLLBACK} to rollback.
     * If exception is thrown, a rollback will be done.
     *
     * @param daoFactory
     * @return
     * @throws Throwable
     */
    TransactionResult onExecute(@NonNull BindRssDaoFactory daoFactory);
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
    T onExecute(@NonNull BindRssDaoFactory daoFactory);
  }

  class DataSourceSingleThread implements BindRssDaoFactory {
    private SQLContextInSessionImpl _context;

    protected DaoArticleImpl _daoArticle;

    protected DaoChannelImpl _daoChannel;

    DataSourceSingleThread() {
      _context=new SQLContextInSessionImpl(BindRssDataSource.this);
    }

    /**
     *
     * retrieve dao DaoArticle
     */
    public DaoArticleImpl getDaoArticle() {
      if (_daoArticle==null) {
        _daoArticle=new DaoArticleImpl(this);
      }
      return _daoArticle;
    }

    /**
     *
     * retrieve dao DaoChannel
     */
    public DaoChannelImpl getDaoChannel() {
      if (_daoChannel==null) {
        _daoChannel=new DaoChannelImpl(this);
      }
      return _daoChannel;
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
