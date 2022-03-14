package pcd.lab02.lost_updates;


public class Worker extends Thread {
	
	private UnsafeCounter counter;
	private int ntimes;
	
	public Worker(UnsafeCounter c, int ntimes){
		counter = c;
		this.ntimes = ntimes;
	}
	
	public void run(){
		for (int i = 0; i < ntimes; i++){
			/* Oppure: usare il synchronized DI COUNTER solo qui
			 * 
			 * synchronized (counter) {
				counter.inc();
			}*/
			counter.inc();
		}
	}
}
