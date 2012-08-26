package com.sajasabie.ape;


import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
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
    public Color rLineColor = Color.BLACK;
    public RectangularShape rShape;
    public Line2D.Double rVeloLine;
    //public List<Double> x;
    //public List<Double> y;
    //public List<Double> radius;
    public double xx, yy, rr, vx, vy;
    public final double VELOLINE_FACTOR = 5000;

    public GRAPEObject(double x, double y, double r) {
        //this.y = new ArrayList<Double>();
        //this.x = new ArrayList<Double>();
        //this.radius = new ArrayList<Double>();
        //this.x.add(x);
        //this.y.add(y);
        //this.radius.add(r);
        xx = x;
        yy = y;
        rr = r;
        vx = 0d;
        vy = 0d;

        //rColor = Color.BLACK;
        ranCol();
        rVeloLine = new Line2D.Double(xx,yy,xx+VELOLINE_FACTOR*Math.signum(vx)*(Math.abs(vx)),yy+VELOLINE_FACTOR*Math.signum(vy)*(Math.abs(vy)));
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
    	rVeloLine.setLine(xx,yy,xx+VELOLINE_FACTOR*Math.signum(vx)*Math.sqrt(Math.abs(vx)),yy+VELOLINE_FACTOR*Math.signum(vy)*Math.sqrt(Math.abs(vy)));
    	System.out.println(vx);
    	rShape.setFrame(xx - rr, yy-rr, rr*2, rr*2);
    }

    public void addPos(double x,double y,double r, double vxx, double vyy) {
        /*this.x.add(x);
        this.y.add(y);
        this.radius.add(r);*/
    	xx = x;
    	yy = y;
    	rr = r;
    	vx = vxx;
    	vy = vyy;
        this.reshape();
    }

    public void ranCol() {
        int color = (int)(Math.random() * 0x00FFFFFF) & 0x00FFFFFF;
        color += 0xFF000000;
        rColor = new Color(color);
    }
}
