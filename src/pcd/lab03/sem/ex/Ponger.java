package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Ponger extends Thread {
	
	private Semaphore pingerNotifiedEvent;
	private Semaphore pongerNotifiedEvent;
	
	public Ponger(Semaphore pingerNotifiedEvent, Semaphore pongerNotifiedEvent) {
		this.pingerNotifiedEvent = pingerNotifiedEvent;
		this.pongerNotifiedEvent = pongerNotifiedEvent;
	}	
	
	public void run() {
		while (true) {
			try {
				this.pingerNotifiedEvent.acquire();
				System.out.println("pong!");
				this.pongerNotifiedEvent.release();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}