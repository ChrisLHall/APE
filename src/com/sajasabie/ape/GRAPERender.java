package com.sajasabie.ape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * User: Nai
 * Date: 8/14/12
 * Created for: com.sajasabie.ape
 */
public class GRAPERender extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Font defFont = new Font("Courier New", Font.PLAIN, 12);

	public List<GRAPEObject> rObject;

    //private final Rectangle2D.Double boundingrect = new Rectangle2D.Double(1,1,899,899);
    public void paint(Graphics g) {
        //First, call the paint function to clar the screen
        super.paint(g);
        //convert graphics to graphics2d
        Graphics2D g2d = (Graphics2D) g;
        //render a bounding box
        g2d.setColor(Color.BLACK);
        //g2d.draw(boundingrect);
        //render some text, also in black
        g2d.setFont(GRAPERender.defFont);
        g2d.drawString("Framerate: " + main.rThread.framerateactual, 16, 16);
        g2d.drawString("Physics Sim framerate: " + main.psthread.framerateactual, 16, 32);
        if(main.psthread.simobjects != null)
        	g2d.drawString("Object count: " + main.psthread.simobjects.size(), 16, 48);

        for(GRAPEObject tObj : rObject) {
            //tObj.reshape();
            g2d.setColor(tObj.rColor);
            g2d.fill(tObj.rShape);
        }
        //render all of the JIRenderables currently attached to the screen

    }

}
