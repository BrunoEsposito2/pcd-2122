package pcd.ass01.sol.v1;

import pcd.ass01.sol.common.Flag;
import pcd.ass01.sol.common.View;

public class Controller {

	private Master master;
	private Simulation sim;
	private Flag stopFlag;
	private int nWorkers;
	
	public Controller(Simulation sim, int nWorkers) {
		this.sim = sim;
		this.nWorkers = nWorkers;
		stopFlag = new Flag();
	}
	
	public void notifySimulationStarted(View view) {
    	stopFlag.reset();
    	master = new Master(sim, nWorkers, view, stopFlag);
        master.start();
	}
	
	public void notifySimulationStopped(View view) {
		master.interrupt();
		stopFlag.set();
	}
}
