package com.sajasabie.ape;

import java.util.List;

/**
 * User: Nai
 * Date: 8/14/12
 * Created for: com.sajasabie.ape
 */
public class GRAPEDrawThread extends Thread {
    private boolean RENDER;
    private List<GRAPEObject> theObjects;
    private GRAPERender rederer;
    public double FRAMERATE = 60.0;
    public double framerateactual;
    private long lastTime;
    
    public boolean threadrunning;

    public GRAPEDrawThread(String s, boolean renderBool, List<GRAPEObject> holder, GRAPERender rend) {
        super(s);
        lastTime = System.currentTimeMillis();
        framerateactual = 0d;
        this.rederer = rend;
        this.RENDER = renderBool;
        this.theObjects = holder;
        
        threadrunning = false;
    }

    public void run() {
        while (threadrunning) {
            if(System.currentTimeMillis() - lastTime > 1.0/FRAMERATE*1000) {
            	framerateactual = 1000.0d/(System.currentTimeMillis() - lastTime);
	            lastTime = System.currentTimeMillis();
	            //rederer.rObject.get(0).x.add(rederer.rObject.get(0).x.get(0) + 0.1);
	            //rederer.rObject.get(0).reshape();
	            rederer.repaint();
	            //System.out.println(rederer.rObject.get(0).x);
            }
            //
        }
    }
}
