package weeklytask1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try { 
			FileReader fr = new FileReader("source.txt"); 
			FileWriter fw = new FileWriter("target.txt"); 
			CopyDataThread thread = new CopyDataThread(fr, fw); 
			thread.setPriority(Thread.NORM_PRIORITY + 1); // Set thread priority 
			thread.start(); 
			} catch (IOException e) { 
				System.out.println("File not found or error opening file: " + e.getMessage()); 
				}
		

	}

}
