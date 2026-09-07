package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Logger {

	private Logger() {}

	private static Logger instance = null;
	public String filename;
	

	public static synchronized Logger get_instance() {
		if(instance == null){
			instance = new Logger();
		}
		return instance;
	}

	public void set_filename(String name) { 
		this.filename = name; 
		
		try {
			File log_file = new File(this.filename);
				if(log_file.createNewFile()){
					System.out.printf("Created file %s%n", this.filename);
				} else {
					System.out.printf("File %s already exists%n", this.filename);
				}

		} catch (IOException e) {
			System.out.println("Error in set_filename(): ");
			e.printStackTrace();
		}
	}

	public void write(String s) {
		
		try {	
			FileWriter writer = new FileWriter(this.filename, true);
			writer.write(s);
			writer.write(System.lineSeparator());
			writer.close();
		} catch(IOException e){
			System.out.println("Error in write(): ");
			e.printStackTrace();
		}
	}

	public void close(){ return; }
}

public class Main {

	public static void main (String[] args) {
		
		Logger logger = Logger.get_instance();
		logger.set_filename("new_log.txt");
		logger.write("Simulation started");
		logger.write("Processing. . .");
		logger.write("Simulation finished");
		logger.set_filename("other_log.txt");
		logger.write("Other file");
		logger.close();
	}
}
