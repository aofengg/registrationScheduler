package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.IOException;

public class FileProcessor {
	private BufferedReader buffer = null;
	
	public FileProcessor(BufferedReader bufferIn) {
		this.buffer = bufferIn;
		Logger.writeMessage("FileProcessor constructor is called", Logger.DebugLevel.CONSTRUCTOR);		
	}
	

	/**
	 * Read one line from the file and return a string. 
	 */
	public synchronized String readOneLineAsString() throws IOException{
		return this.buffer.readLine();
	}
}
