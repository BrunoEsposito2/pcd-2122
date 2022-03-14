package pcd.lab02.lost_updates;

public class UnsafeCounter {

	private int cont;
	private Object lock;
	
	public UnsafeCounter(int base){
		this.cont = base;
	}
	
	public UnsafeCounter(int base, final Object lock){
		this.cont = base;
		this.lock = lock;
	}
	
	/*public void inc(){
		cont++;
	}*/
	
	public void inc(){
		synchronized(lock) {
			cont++;
		}
	}
	
	/* Oppure: versione SENZA OGGETTO LOCK come parametro
	 * 
	 * public void inc(){
		synchronized(this) {
			cont++;
		}
	 }
	 * */
	
	public int getValue(){
		return cont;
	}
}
