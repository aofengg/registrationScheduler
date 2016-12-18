package registrationScheduler.threadMgmt;

import java.io.IOException;
import registrationScheduler.store.ObjectPool;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.Student;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class WorkerThread implements Runnable {
	final static int total_student_number = 80;
	final static int total_course_number = 7;
	final static int total_register_number = 5;
	private FileProcessor fp = null;
//	private ArrayList<Student> student_list = null;
	private int register_fail = 0;
	private StdoutDisplayInterface results = null;
	
	public WorkerThread(FileProcessor fpIn, StdoutDisplayInterface resultsIn) {
		this.fp = fpIn;
		this.results = resultsIn;
		Logger.writeMessage("WorkerThread constructor is called", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public static void register(Student student, ObjectPool course) {
		student.register(course);
		course.addObject();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		assignment();
	}
	//synchronized

	/**
	 * Assign each student five courses depends on the preference. 
	 */
	public void assignment() {
		String line = null;
		try {
			while ((line = this.fp.readOneLineAsString()) != null) {
				String[] sp = line.split("\\s+");
				Student student = new Student(sp[0], Integer.parseInt(sp[1]), Integer.parseInt(sp[2]), 
						Integer.parseInt(sp[3]), Integer.parseInt(sp[4]), Integer.parseInt(sp[5]), 
						Integer.parseInt(sp[6]), Integer.parseInt(sp[7]));
				this.register_fail = 0;
				for (int preference = 1; preference <= total_register_number; preference++) {
					if (student.get_course_from_preference(preference).getNumIdle() > 0) {
						register(student, student.get_course_from_preference(preference));
					}
					else {
						this.register_fail++;
					}
				}
				for (int i = 1; i <= this.register_fail && i <= total_course_number-total_register_number; i++) {
					if (student.get_course_from_preference(total_register_number + i).getNumIdle() > 0) {
						register(student, student.get_course_from_preference(total_register_number + i));
					}
				}
				((Results)this.results).add(student);
				//student.outputToStd();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
