/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab5t5;

import java.applet.Applet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author Areej
 */
public class MultiLineApplet extends Applet implements Runnable {

    Thread th;
    int xy[][] = new int[10][4];
    int i = 0;

    public void init() {
        th = new Thread(this);
        th.start();

        this.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                try {
                    if (i < 10) {
                        xy[i][0] = e.getX();
                        xy[i][1] = e.getY();
                        repaint();
                    }

                } catch (Exception n) {
                    System.out.println("error");
                }
            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if (i < 10) {

                        i++;
                    }
                } catch (Exception o) {
                    System.out.println("error");
                }

            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        }
        );

        this.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                try {
                    if (i < 10) {
                        xy[i][2] = e.getX();
                        xy[i][3] = e.getY();

                        repaint();
                    }
                } catch (Exception k) {
                    System.out.println("error");
                }
            }

        }
        );

    }

    public void paint(Graphics g) {
        int j;
        try {
            for ( j = 0; j <= i; j++) {
                g.drawLine(xy[j][0], xy[j][1], xy[j][2], xy[j][3]);
            }
        } catch (Exception m) {
           j=0;
        }

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

    // TODO start asynchronous download of heavy resources
}
