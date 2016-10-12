package com.anoopnair.httpzoid;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;

import android.os.AsyncTask;

 class MyExecutor implements Executor {
	 	final int QUEUE_SIZE = 50 ;
        final  PriorityQueue<MyRunnable> mTasks = new PriorityQueue<MyRunnable>(QUEUE_SIZE);
        static MyExecutor mThis ;
        private enumPriority priority ;
        Runnable mActive;
        
        public static MyExecutor getInstance(enumPriority priority){
        	if (mThis == null){
        		mThis = new MyExecutor();
        	}
        	mThis.priority = priority ;
        	return mThis ;
        }
        
        public synchronized void execute(final Runnable r) {
        	
        	mTasks.offer(new MyRunnable(priority) {
				@Override
				public void run() {
					try {
                     r.run();
                  } finally {
                      scheduleNext();
                  }
					
				}
			});
         
            if (mActive == null) {
                scheduleNext();
            }
        }
 
        protected synchronized void scheduleNext() {
            if ((mActive = mTasks.poll()) != null) {
                AsyncTask.execute(mActive);
            }
        }
        
 }
        
