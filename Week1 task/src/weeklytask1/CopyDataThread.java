package weeklytask1;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyDataThread extends Thread{


FileReader source;
FileWriter target;

public CopyDataThread(FileReader source, FileWriter target) 
{ 
	this.source = source; this.target = target; 
}

public void run() 
{ 
	try 
	{
		int ch; 
		int count = 0; 
		while ((ch = source.read()) != -1) 
		{ 
			target.write(ch); 
			count++; 
			if (count % 10 == 0) 
			{ 
				System.out.println("10 characters are copied"); Thread.sleep(5000); // 5 seconds delay 				
			} 
			} 
		    source.close(); 
		    target.close(); 
		    System.out.println("File copy completed.");
			} 
			catch (Exception e) 
			{ 
				System.out.println("Error during file copy: " + e.getMessage());
			} 
	        }

}
