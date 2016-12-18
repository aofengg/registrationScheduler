package registrationScheduler.store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import registrationScheduler.util.Logger;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {
	private ArrayList<Student> student_list = new ArrayList<Student>();

	public Results() {
		//this.student_list.add(new Student("s", 1, 2, 3, 4, 5, 6, 7));
		Logger.writeMessage("Results constructor is called", Logger.DebugLevel.CONSTRUCTOR);
	}

	public synchronized void add(Student student) {
		this.student_list.add(student);
		Logger.writeMessage("An entry is added to the Results data structure", Logger.DebugLevel.RESULTS);
	}

	public String AverageValue() throws NullPointerException {
		int total_score = 0;

		for (int i = 0; i < this.student_list.size(); i++) {
			total_score += this.student_list.get(i).get_total_score();
		}
		float average_preference_score = (float) total_score / student_list.size();
		String averageValue = "Average preference_score is: " + average_preference_score + "\n";

		return averageValue;
	}

	/**
	 * Write the assigned schedule into the screen. 
	 */
	@Override
	public String writeScheduleToScreen() {
		// TODO Auto-generated method stub
		String schedule = "";

		for (int i = 0; i < this.student_list.size(); i++) {
			schedule += this.student_list.get(i).courseDetails();
		}

		return schedule;
	}
	
	/**
	 * Write the assigned schedule into the file. 
	 */
	@Override
	public void writeScheduleToFile(String filename) {
		// TODO Auto-generated method stub
		String schedule = "";
		for (int i = 0; i < this.student_list.size(); i++) {
			schedule += this.student_list.get(i).courseDetails();
		}
		try {
			FileWriter fw = new FileWriter(filename);
			fw.write(schedule);
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
