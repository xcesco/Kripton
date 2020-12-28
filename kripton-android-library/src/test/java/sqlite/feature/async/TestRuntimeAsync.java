/*******************************************************************************
 * Copyright 2016-2019 Francesco Benincasa (info@abubusoft.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package sqlite.feature.async;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.abubusoft.kripton.android.KriptonLibrary;
import com.abubusoft.kripton.android.Logger;
import com.abubusoft.kripton.android.sqlite.TransactionResult;

import base.BaseAndroidTest;
import sqlite.feature.async.BindDummy01DataSource.Batch;
import sqlite.feature.async.BindDummy01DataSource.Transaction;

/**
 * The Class TestRuntimeMultithread.
 */
@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class TestRuntimeAsync extends BaseAndroidTest {

	/**
	 * Test multithread writable.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws ExecutionException 
	 */
	@Test
	public void testMultithreadWritable() throws InterruptedException, ExecutionException {
		BindDummy01DataSource ds=BindDummy01DataSource.getInstance();
		
		/*
		Future<List<Channel>> r0 = ds.executeBatchAsync(new Batch<List<Channel> >() {

			@Override
			public List<Channel> onExecute(BindDummy01DaoFactory daoFactory) {
				log("read 0 start");
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				log("read 0 end");
				return daoFactory.getDaoChannel().selectAll();
			}
			
		});		
		
		Thread.sleep(10);
		*/
		ds.execute(new Transaction() {
			
			@Override
			public TransactionResult onExecute(BindDummy01DaoFactory daoFactory) {
				log("Write start");
				try {
					log("Write SLEEP");
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
				Channel bean = new Channel();
				bean.setName("dummy");
				daoFactory.getDaoChannel().insertBean1(bean);
				log("Write end");
				return TransactionResult.COMMIT;
			}
		});
						
		final List<Integer> operations=new ArrayList<>();
		
		Future<List<Channel>> r1 = ds.executeBatchAsync(new Batch<List<Channel> >() {

			@Override
			public List<Channel> onExecute(BindDummy01DaoFactory daoFactory) {
				log("read 1 start");
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				operations.add(1);
				
				List<Channel> list = daoFactory.getDaoChannel().selectAll();
				
				log("read 1 end");
				
				return list;
			}
			
		});		

						
		Future<List<Channel>> r2 = ds.executeBatchAsync(new Batch<List<Channel> >() {

			@Override
			public List<Channel> onExecute(BindDummy01DaoFactory daoFactory) {
				log("read 2 start");
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				operations.add(2);
				
				List<Channel> list = daoFactory.getDaoChannel().selectAll();
				
				log("read 2 end");
				
				return list;
			}
			
		});		
		
		r1.get();
		r2.get();
				
		//int size=resultList.get().size();
		//Boolean done = result.get();
		
		// operation 2 is executed before operation 1
		assertTrue(operations.get(0)==2 && operations.get(1)==1);
		
		// we have to wait
		KriptonLibrary.getExecutorService().awaitTermination(10, TimeUnit.SECONDS);
				

		Logger.info("Finished all thread!");

	}


}
