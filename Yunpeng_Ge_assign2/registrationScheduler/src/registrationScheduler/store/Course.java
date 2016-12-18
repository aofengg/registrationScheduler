package registrationScheduler.store;

import registrationScheduler.util.Logger;

public class Course implements ObjectPool {
	final static int capacity = 60;
	
	private String course_name = null;
	private int course_contain = 0;
	
	public Course(String name) {
		this.course_name = name;
		Logger.writeMessage("Course constructor is called", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public String name() {
		return this.course_name;
	}


	@Override
	public void borrowObject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnObject() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Get the number of the students have been in the class. 
	 */
	@Override
	public int getNumActive() {
		// TODO Auto-generated method stub
		return this.course_contain;
	}
	/**
	 * Get the number of students that can still register the course. 
	 */
	@Override
	public int getNumIdle() {
		// TODO Auto-generated method stub
		return Course.capacity - this.course_contain;
	}

	@Override
	public void addObject() {
		// TODO Auto-generated method stub
		this.course_contain++;
	}
}

