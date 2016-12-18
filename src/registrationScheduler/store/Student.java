package registrationScheduler.store;

import java.io.FileWriter;
import java.io.IOException;

import registrationScheduler.util.Logger;

public class Student {
	private String student_name = null;
	private int A_preference;
	private int B_preference;
	private int C_preference;
	private int D_preference;
	private int E_preference;
	private int F_preference;
	private int G_preference;
	private int A_get = 0;
	private int B_get = 0;
	private int C_get = 0;
	private int D_get = 0;
	private int E_get = 0;
	private int F_get = 0;
	private int G_get = 0;
	
	public Student (String name, int a, int b, int c, int d, int e, int f, int g) {
		this.student_name = name;
		this.A_preference = a;
		this.B_preference = b;
		this.C_preference = c;
		this.D_preference = d;
		this.E_preference = e;
		this.F_preference = f;
		this.G_preference = g;
		Logger.writeMessage("Student constructor is called", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public String name() {
		return this.student_name;
	}
	/**
	 * Returns the course is full of students or not.
	 */
	public boolean full_course() {
		if (this.A_get+this.B_get+this.C_get+this.D_get+this.E_get+this.F_get+this.G_get >= 5) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Returns the course's name from the student's preference.
	 */
	public Course get_course_from_preference(int preference) {
		if (this.A_preference == preference) {
			return Entity.A;
		}
		if (this.B_preference == preference) {
			return Entity.B;
		}
		if (this.C_preference == preference) {
			return Entity.C;
		}
		if (this.D_preference == preference) {
			return Entity.D;
		}
		if (this.E_preference == preference) {
			return Entity.E;
		}
		if (this.F_preference == preference) {
			return Entity.F;
		}
		else {
			return Entity.G;
		}
	}
	/**
	 * Returns the total preference score based on which courses the student has been registered.
	 */
	public int get_total_score() {
		return this.A_preference*this.A_get + this.B_preference*this.B_get
				+ this.C_preference*this.C_get + this.D_preference*this.D_get
				+ this.E_preference*this.E_get+ this.F_preference*this.F_get
				+ this.G_preference*this.G_get;
	}
	/**
	 * Register a course for a student and mark that the student has gotten this course.
	 */
	public void register(ObjectPool course) {
		if (((Course)course).name() == "A") {
			this.A_get = 1;
		}
		if (((Course)course).name() == "B") {
			this.B_get = 1;
		}
		if (((Course)course).name() == "C") {
			this.C_get = 1;
		}
		if (((Course)course).name() == "D") {
			this.D_get = 1;
		}
		if (((Course)course).name() == "E") {
			this.E_get = 1;
		}
		if (((Course)course).name() == "F") {
			this.F_get = 1;
		}
		if (((Course)course).name() == "G") {
			this.G_get = 1;
		}
	}
	/**
	 * Write which courses the student has been registered into the output file.
	 */
	public synchronized void outputToFile(FileWriter fw) throws IOException {
		//FileWriter fw = new FileWriter(filename, true);
		fw.write(this.student_name + "  ");
		if (this.A_get == 1) {
			fw.write("A  ");
		}
		if (this.B_get == 1) {
			fw.write("B  ");
		}
		if (this.C_get == 1) {
			fw.write("C  ");
		}
		if (this.D_get == 1) {
			fw.write("D  ");
		}
		if (this.E_get == 1) {
			fw.write("E  ");
		}
		if (this.F_get == 1) {
			fw.write("F  ");
		}
		if (this.G_get == 1) {
			fw.write("G  ");
		}
		fw.write("" + this.get_total_score() + "\n");
		
		fw.close();
	}
	

	/**
	 * Get the courses registered details of the student. 
	 */
	public String courseDetails() {
		//FileWriter fw = new FileWriter(filename, true);
		String details = this.student_name + "  ";
		if (this.A_get == 1) {
			details += "A  ";
		}
		if (this.B_get == 1) {
			details += "B  ";
		}
		if (this.C_get == 1) {
			details += "C  ";
		}
		if (this.D_get == 1) {
			details += "D  ";
		}
		if (this.E_get == 1) {
			details += "E  ";
		}
		if (this.F_get == 1) {
			details += "F  ";
		}
		if (this.G_get == 1) {
			details += "G  ";
		}
		details += this.get_total_score() + "\n";
		return details;
	}
}
