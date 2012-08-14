package com.sajasabie.ape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

/**
 * User: Nai
 * Date: 8/14/12
 * Created for: com.sajasabie.ape
 */
public class main {
    public boolean RENDER = false;
    public static GRAPERender renderer;


    public static void init() {
        renderer = new GRAPERender();
        renderer.rObject = new LinkedList<GRAPEObject>();
        renderer.rObject.add(new GRAPEObject(3.0,3.0,3.0));
    }

    public static void main(String[] args) {
        init();
        boolean blah = true;
        final GRAPEDrawThread rThread = new GRAPEDrawThread("BLAH",blah,renderer.rObject,renderer);
        JFrame frame = new JFrame("GRAPE");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                rThread.stop();
                System.exit(0);
            }
        });
        frame.setBackground(Color.WHITE);
        renderer.setBackground(Color.WHITE);
        frame.setLocation(0, 0);
        frame.setSize(620,620);
        frame.setContentPane(renderer);
        frame.setVisible(true);
        rThread.run();
        //while (true);
        //System.out.println("WASSSUUUP");
    }
}
