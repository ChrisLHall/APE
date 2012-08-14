package com.sajasabie.ape;

public class PhySimObj {
	public double x;
	public double y;
	public double vx;
	public double vy;
	public double accelx;
	public double accely;
	public double mass;
	public double radius;
	
	public boolean cancollide;
	
	public int ID;
	
	public PhySimObj() {
		this(IDManager.getNextID());
	}
	
	public PhySimObj(int id) {
		this(id, 0d, 0d, 0d, 0d, 0d, 0d, false);
	}
	
	public PhySimObj(int id, double pX, double pY, double pVx, double pVy, double pMass, double pRadius, boolean pCanCollide) {
		ID = id;
		
		x = pX;
		y = pY;
		vx = pVx;
		vy = pVy;
		mass = pMass;
		
		accelx = 0;
		accely = 0;
		
		radius = pRadius;
		cancollide = pCanCollide;
	}
	
	public void timeStepReset() {
		/** timeStepReset() :
		 *  Resets all force variables that need to be refreshed for each time step. 
		 *  Primary function is to reset acceleration vectors to 0.
		 *  
		 *  Returns: nothing.
		 */
		accelx = 0;
		accely = 0;
	}
	
	public boolean simulateWithObj(PhySimObj otherobject) {
		/** simulateWithObj(PhySimObj otherobject) :
		 *  Calculates the effect of otherobject on this object, and adds them to the acceleration
		 *  vectors for this time step. Handles collisions. Does not affect the other object.
		 *  
		 *  Returns: whether the simulation was handled properly
		 */
		return true;
	}
}
