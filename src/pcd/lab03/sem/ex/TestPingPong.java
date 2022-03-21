package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {
		Semaphore pingerNotifiedEvent = new Semaphore(0);
		Semaphore pongerNotifiedEvent = new Semaphore(0);
		new Pinger(pingerNotifiedEvent, pongerNotifiedEvent).start();
		new Ponger(pingerNotifiedEvent, pongerNotifiedEvent).start();
		
		pongerNotifiedEvent.release();
	}

}
