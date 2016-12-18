package registrationScheduler.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import registrationScheduler.store.Results;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class Driver {

	public static void main(String[] args) throws InterruptedException, IOException {
		if (args.length == 4) {
			try {
				if (Integer.parseInt(args[2]) > 3 || Integer.parseInt(args[2]) < 1) throw new Exception();
				if (Integer.parseInt(args[3]) > 4 || Integer.parseInt(args[2]) < 0) throw new Exception();
				File file = new File(args[0]);
				BufferedReader buffer = new BufferedReader(new FileReader(file));
				String filename = args[1];
//				FileWriter fw = new FileWriter(args[1]);
				int NUM_THREADS = Integer.parseInt(args[2]);
				Logger.setDebugValue(Integer.parseInt(args[3]));
				Results results = new Results();
				FileProcessor fp = new FileProcessor(buffer);

				CreateWorkers cw = new CreateWorkers(fp, results, NUM_THREADS, filename);
				cw.startWorkers();
			} catch (Exception e) {
				System.out.println("Please enter four exact command line arguments.\n");
				e.getStackTrace();
			} finally {
				
			}
		} else {
			System.out.println("Please enter four command line arguments.\n");

		}
	}

}
