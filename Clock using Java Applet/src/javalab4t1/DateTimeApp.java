/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab4t1;

import java.applet.Applet;
import java.awt.*;
import java.util.*;

/**
 *
 *
 * @author Areej
 */
public class DateTimeApp extends Applet implements Runnable {

    Thread th;

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        th = new Thread(this);
        th.start();
        // TODO start asynchronous download of heavy resources
    }

    public void paint(Graphics g) {
        Date d = new Date();
        g.drawString(d.toString(), 70, 100);

    }

    public void run() {
        try {
            while (true) {
                repaint();
                Thread.sleep(1000);

            }
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

    // TODO overwrite start(), stop() and destroy() methods
}
