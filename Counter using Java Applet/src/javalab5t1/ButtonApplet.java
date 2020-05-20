/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab5t1;

import java.applet.Applet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

/**
 *
 * @author Areej
 */
public class ButtonApplet extends Applet implements Runnable {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    int x ;
    Button b1, b2;
    Thread th, th2;

    public void init() {
        // TODO start asynchronous download of heavy resources

        b1 = new Button("+");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(x<10)
                {
                x++;
                repaint();
                }
            }
        });
        
        add(b1);
        b2 = new Button("-");

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if(x>0)
                {
                x--;
                repaint();
                }
            }
        });
        add(b2);
        th = new Thread(this);
        th.start();
        th2 = new Thread(this);
        th2.start();

    }

    public void paint(Graphics g) {
        g.drawString(""+x, 50, 100);

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
