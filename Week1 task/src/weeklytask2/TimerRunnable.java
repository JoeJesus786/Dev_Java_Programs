package weeklytask2;

public class TimerRunnable implements Runnable{
	
	@Override 
	public void run() 
	{ 
		while (true) { 
			// Get current time 
			java.time.LocalTime currentTime = java.time.LocalTime.now(); 
			System.out.println("Current Time: " + currentTime); 
			try { // Sleep for 10 seconds 
				Thread.sleep(10000); // 10000 milliseconds = 10 seconds 
				} catch (InterruptedException e) { 
					System.out.println("Timer interrupted"); 
					break; 
					}
			 }
			}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

TimerRunnable timer = new TimerRunnable();
Thread timerThread = new Thread(timer);
timerThread.start();


	}

}
