package registrationScheduler.threadMgmt;

import java.util.ArrayList;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class CreateWorkers {
	private FileProcessor fp = null;
	private StdoutDisplayInterface results = null;
	private int NUM_THREADS = 0;
	private ArrayList<Thread> thread_list = new ArrayList<Thread>();
	private String filename = null;
	
	public CreateWorkers(FileProcessor fpIn, StdoutDisplayInterface resultsIn, int NUM_THREADSIn, String filenameIn) {
		this.fp = fpIn;
		this.results = resultsIn;	
		this.NUM_THREADS = NUM_THREADSIn;
		this.filename = filenameIn;
		Logger.writeMessage("CreateWorker constructor is called", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public void startWorkers() throws InterruptedException{
		WorkerThread wt = new WorkerThread(fp, this.results);

		for (int i = 0; i < this.NUM_THREADS; i++) {
			Thread t = new Thread(wt);
			this.thread_list.add(t);
//			System.out.println("Create how many threads ? ----------->"+i);
		}
		for (int i = 0; i < this.thread_list.size(); i++) {
			this.thread_list.get(i).start();
//			System.out.println("Start how many threads ? ----------->"+i);
			Logger.writeMessage("One thread run() is called", Logger.DebugLevel.THREAD);
		}
		for (int i = 0; i < this.thread_list.size(); i++) {
			this.thread_list.get(i).join();
//			System.out.println("Join how many threads ? ----------->"+i); 
		}
		

		/**
		 * Write the assigned schedule into the file. 
		 */
		((Results)this.results).writeScheduleToFile(this.filename);
		

		/**
		 * Logger debug output. 
		 */
		Logger.writeMessage(((Results)this.results).AverageValue(), Logger.DebugLevel.AVERAGE);
		Logger.writeMessage(((Results)this.results).writeScheduleToScreen(), Logger.DebugLevel.CONTENTS);
	
	}
}
