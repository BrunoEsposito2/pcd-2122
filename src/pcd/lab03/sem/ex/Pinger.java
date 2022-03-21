package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Pinger extends Thread {

	private Semaphore pingerNotifiedEvent;
	private Semaphore pongerNotifiedEvent;
	
	public Pinger(Semaphore pingerNotifiedEvent, Semaphore pongerNotifiedEvent) {
		this.pingerNotifiedEvent = pingerNotifiedEvent;
		this.pongerNotifiedEvent = pongerNotifiedEvent;
	}	
	
	public void run() {
		while (true) {
			try {
				this.pongerNotifiedEvent.acquire();
				System.out.println("ping!");
				this.pingerNotifiedEvent.release();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}