package com.sajasabie.ape;


import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Nai
 * Date: 8/14/12
 * Created for: com.sajasabie.ape
 */
public class GRAPEObject {
    public Color rColor;
    public RectangularShape rShape;
    public List<Double> x;
    public List<Double> y;
    public List<Double> radius;
    public double xx, yy, rr;

    public GRAPEObject(double x, double y, double r) {
        this.y = new ArrayList<Double>();
        this.x = new ArrayList<Double>();
        this.radius = new ArrayList<Double>();
        this.x.add(x);
        this.y.add(y);
        this.radius.add(r);
        xx = x;
        yy = y;
        rr = r;

        //rColor = Color.BLACK;
        ranCol();
        rShape = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
    }

    public void reshape() {
        /*if(x.size() > 1) {
            x.remove(0);
            y.remove(0);
            radius.remove(0);
            //System.out.println(x);
            rShape = new Ellipse2D.Double(x.get(0) - radius.get(0), y.get(0) - radius.get(0), radius.get(0)*2, radius.get(0)*2);
        }*/
    	rShape.setFrame(xx - rr, yy-rr, rr*2, rr*2);
    }

    public void addPos(double x,double y,double r) {
        /*this.x.add(x);
        this.y.add(y);
        this.radius.add(r);*/
    	xx = x;
    	yy = y;
    	rr = r;
        this.reshape();
    }

    public void ranCol() {
        int color = (int)(Math.random() * 0x00FFFFFF);
        color += 0xFF000000;
        rColor = new Color(color);
    }
}
