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
	
	public GRAPEObject myGObj;
	
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
		
		myGObj = new GRAPEObject(pX, pY, pRadius);
		main.renderer.rObject.add(myGObj);
	}
	
	public void setID(int id) {
		ID = id;
	}
	
	public void setGObj(GRAPEObject gobj) {
		myGObj = gobj;
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
	
	public void simulateWithObj(PhySimObj otherobject) {
		/** simulateWithObj(PhySimObj otherobject) :
		 *  Calculates the effect of otherobject on this object, and adds them to the acceleration
		 *  vectors for this time step. Handles collisions. Does not affect the other object.
		 *  
		 *  Returns: whether the simulation was handled properly
		 */
		double dist = Utility.distance(this.x, this.y, otherobject.x, otherobject.y);
		double dir = Utility.direction(this.x, this.y, otherobject.x, otherobject.y);
		double force = PhySimThread.GRAV_CONST * this.mass * otherobject.mass / (dist * dist);
		accelx += force/mass*Math.cos(dir);
		accely += force/mass*Math.sin(dir);
		
		//handle collisions
		if (dist < (otherobject.radius + radius)) {
			//calculate a new spring force
			force = PhySimThread.ELEC_SPRING_CONST * (dist - (otherobject.radius + radius));
			accelx += force/mass*Math.cos(dir);
			accely += force/mass*Math.sin(dir);
		}
	}
	
	
	public void propagate(double steptime) {
		vx += accelx*steptime;
		vy += accely*steptime;
		x += vx*steptime;
		y += vy*steptime;
		
		if (myGObj != null)
			myGObj.addPos(x, y, radius);
	}
}
