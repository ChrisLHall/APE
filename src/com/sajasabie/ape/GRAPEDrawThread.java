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
    long lastTime = System.currentTimeMillis();

    public GRAPEDrawThread(String s, boolean renderBool, List<GRAPEObject> holder, GRAPERender rend) {
        super(s);
        this.rederer = rend;
        this.RENDER = renderBool;
        this.theObjects = holder;
    }

    public void run() {
        while (true) {

            if(System.currentTimeMillis() - lastTime > 1.0/FRAMERATE*1000 && RENDER) {
            lastTime = System.currentTimeMillis();
            //rederer.rObject.get(0).x.add(rederer.rObject.get(0).x.get(0) + 0.1);
            rederer.rObject.get(0).reshape();
            rederer.repaint();
            //System.out.println(rederer.rObject.get(0).x);
            }
            //
        }
    }
}
