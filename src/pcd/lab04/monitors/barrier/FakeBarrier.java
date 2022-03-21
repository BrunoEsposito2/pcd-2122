package pcd.lab04.monitors.barrier;

/*
 * Barrier - to be implemented
 */
public class FakeBarrier implements Barrier {

	private int nParticipants;
	private int nHits;
	
	public FakeBarrier(int nParticipants) {
		this.nParticipants = nParticipants;
		this.nHits = 0;
	}
	
	@Override
	public synchronized void hitAndWaitAll() throws InterruptedException {
		this.nHits++;
		while (this.nHits < this.nParticipants) {
			wait();
		}
		notifyAll(); //better than notify only -> is more foolproof, but a bit less efficient
		/*this.nHits++;
		if (this.nHits == this.nParticipants)
			notifyAll();
		else 
			/*
			 * while instead of only wait because of spurious signal/wake ups made by JVM/Java specific language
			 * */
			/*while (this.nHits < this.nParticipants) 
				wait();*/
	}

	
}
