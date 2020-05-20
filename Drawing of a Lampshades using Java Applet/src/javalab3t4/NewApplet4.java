/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab3t4;

import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author Areej
 */
public class NewApplet4 extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }

    public void paint(Graphics g) {
        
        Color myColor = new Color(255, 255, 153);
        g.setColor(myColor);
        
        g.fillOval(65, 25, 260, 50);

        g.fillOval(60, 150, 50, 80);

        g.fillOval(145, 120, 100, 160);

        g.fillOval(280, 150, 50, 80);
        
        g.setColor(Color.black);
        
        g.drawOval(65, 25, 260, 50);

        g.drawOval(60, 150, 50, 80);

        g.drawOval(145, 120, 100, 160);

        g.drawOval(280, 150, 50, 80);

        g.drawLine(65, 50, 10, 294);

        g.drawLine(325, 50, 370, 294);

        g.drawArc(10, 235, 360, 120, 180, 180);

        g.drawLine(190, 355, 150, 450);

        g.drawLine(210, 355, 250, 450);

        g.drawRect(75, 450, 250, 30);

    }
    // TODO overwrite start(), stop() and destroy() methods
}
