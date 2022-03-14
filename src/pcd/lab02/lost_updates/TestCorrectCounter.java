package pcd.lab02.lost_updates;

public class TestCorrectCounter {

	public static void main(String[] args) throws Exception {
		/* Introdurre la lock e quindi rendere synchronized le operazioni
		 * va ad inficiare le performance del programma. La soluzione consiste 
		 * nel minimizzare la probabilità che quando uno dei due worker è in lock
		 * anche l'altro in quello stesso momento richiede di entrarci.
		 *  */
		Object lock = new Object();
		int ntimes = Integer.parseInt("800");
		UnsafeCounter c = new UnsafeCounter(0, lock);
		Worker w1 = new Worker(c,ntimes);
		Worker w2 = new Worker(c,ntimes);

		Cron cron = new Cron();
		cron.start();
		w1.start();
		w2.start();
		w1.join();
		w2.join();
		cron.stop();
		System.out.println("Counter final value: "+c.getValue()+" in "+cron.getTime()+"ms.");
	}
}

