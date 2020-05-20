/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab5t2;

import java.applet.Applet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

/**
 *
 * @author Areej
 */
public class BallApplet extends Applet implements Runnable {

    Button b1, b2;
    Thread th, th2;
    int x = 0, y = 200;
    volatile int flag = 0;

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        b1 = new Button("start");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                flag = 0;
                repaint();

            }
        });

        add(b1);
        b2 = new Button("pause");

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                flag = 1;

            }
        });
        add(b2);
        th = new Thread(this);
        th.start();
        th2 = new Thread(this);
        th2.start();

        // TODO start asynchronous download of heavy resources
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        //g.drawOval(x, y, 40, 40);
        g.fillOval(x, y, 40, 40);

    }

    public void run() {
        while (true) {
            try {
                repaint();
                if (flag == 0) {
                    while (x <= getWidth() / 2 && y >= 0) {
                        x += 20;
                        y -= 20;
                        repaint();
                        Thread.sleep(100);
                    }
                    while (x <= getWidth() && y <= getHeight() / 2) {
                        x += 20;
                        y += 20;
                        repaint();
                        Thread.sleep(100);
                    }
                    while (x >= getWidth() / 2 && y <= getHeight()) {
                        x -= 20;
                        y += 20;
                        repaint();
                        Thread.sleep(100);

                    }
                    while (x >= 0 && y >= getHeight() / 2) {

                        x -= 20;
                        y -= 20;
                        repaint();
                        Thread.sleep(100);

                    }
                } else {
                    while(flag==1)
                    {
                    Thread.sleep(100);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }

    // TODO overwrite start(), stop() and destroy() methods
}
