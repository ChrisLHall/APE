package com.sajasabie.ape;

import java.util.ArrayList;
import java.util.List;

public class PhySimThread extends Thread {
	//Gravitational constant
	//distances are in meters, time is in seconds
	//mass is in kilograms
	public static final double GRAV_CONST = 6.6e-11d;
	public static final double ELEC_SPRING_CONST = 4e-11d;
	public boolean canrun;
	public boolean inrun;
	public boolean threadrunning;
	
	public List<PhySimObj> simobjects;
	
	public long lasttime;
	public long rundelay; //run delay in milliseconds
	public double framerateactual;
	
	public double steptime = 30000.0d; //physical step time in seconds
	
	public PhySimThread(long delay) {
		framerateactual = 0d;

		simobjects = new ArrayList<PhySimObj>();
		canrun = false;
		inrun = false;
		threadrunning = true;
		rundelay = delay;
	}
	
	@Override
	public void run() {
		while(threadrunning) {
			if(canrun && System.currentTimeMillis() >= (lasttime + rundelay)) {
				framerateactual = 1000.0d/(System.currentTimeMillis() - lasttime);
				inrun = true;
				lasttime = System.currentTimeMillis();
				
				PhySimObj currentobj = null, otherobj = null;
				
				//first, simulate all the objects
				int objnum = simobjects.size();
				for(int i = 0; i < objnum ; i++ ) {
					//with each object, iterate through all the following objects
					currentobj = simobjects.get(i);
					for(int j = i+1; j < objnum ; j++) {
						otherobj = simobjects.get(j);
						currentobj.simulateWithObj(otherobj);
						otherobj.simulateWithObj(currentobj);
					}
				}
				
				//now, propagate and reset
				for(int i = 0; i < objnum ; i++ ) {
					currentobj = simobjects.get(i);
					currentobj.propagate(steptime);
					currentobj.timeStepReset();
				}
				
				inrun = false;
				
				//see if I can free up some cycles
				if(System.currentTimeMillis() - lasttime < rundelay) {
	            	try {
						PhySimThread.sleep(Math.max(1l, rundelay - (System.currentTimeMillis() - lasttime)));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
			}
		}
	}
	
	public boolean addObject(PhySimObj object) {
		simobjects.add(object);
		
		return true;
	}
}
