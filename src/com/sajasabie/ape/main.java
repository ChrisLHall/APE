package com.sajasabie.ape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * User: Nai
 * Date: 8/14/12
 * Created for: com.sajasabie.ape
 */
public class main {
    public boolean RENDER = false;
    public static GRAPERender renderer;
    public static PhySimThread psthread;


    public static void init() {
        renderer = new GRAPERender();
        renderer.rObject = new LinkedList<GRAPEObject>();
        //renderer.rObject.add(new GRAPEObject(3.0,3.0,3.0));
    }

    public static void main(String[] args) {
        init();
        boolean blah = true;
        final GRAPEDrawThread rThread = new GRAPEDrawThread("BLAH",blah,renderer.rObject,renderer);
        //make the physim thread
        psthread = new PhySimThread(10l);
        psthread.addObject(new PhySimObj(100, 100d, 100d, 0d, 0d, 64d, 32d, false));
       // psthread.addObject(new PhySimObj(101, 150d, 50d, -1e-6d, 0d, 8d, 16d, false));
      //  psthread.addObject(new PhySimObj(102, 200d, 200d, -5e-6d, -5e-6d, 1d, 8d, false));
        // run it
        psthread.canrun = true;
        JFrame frame = new JFrame("GRAPE");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                rThread.stop();
                try {
                	psthread.threadrunning = false;
					psthread.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                System.exit(0);
            }

        });
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
               // System.out.println("BLAH");
               //psthread.addObject(new PhySimObj(mouseEvent.getID(), mouseEvent.getX(), mouseEvent.getY(), -1e-6d, 0d, 8d, 16d, false));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                System.out.println("BLAH");
                psthread.addObject(new PhySimObj(mouseEvent.getID(), mouseEvent.getX(), mouseEvent.getY(), 0, 0d, 8d, 10d, false));
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
            }
        });
        frame.setBackground(Color.WHITE);
        renderer.setBackground(Color.WHITE);
        frame.setLocation(0, 0);
        frame.setSize(900, 900);
        frame.setContentPane(renderer);
        frame.setVisible(true);
        rThread.start();
        psthread.start();
        //while (true);
        //System.out.println("WASSSUUUP");
    }
}
