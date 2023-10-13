package util;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import lib.Constants;

public class Screen extends JFrame {

    private JFrame screen;
    private Frame frame;
    
    public Screen(){
        screen = new JFrame();
        frame = new Frame();
        screen.setTitle("Ray Caster");
        screen.setSize((int)(Constants.SCREEN_WIDTH*Constants.SCREEN_WIDTH_ADJUSTEMENT_FACTOR), 
                        (int)(Constants.SCREEN_HEIGHT*Constants.SCREEN_HEIGHT_ADJUSTEMENT_FACTOR));
        screen.setResizable(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);
    }

    public void drawRectangle(int x, int y, int width, int height, Color color){
        frame.addRectangle(x, y, width, height, color);
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        frame.addLine(x1,y1,x2,y2,color);
    }

    public void drawCastedRays(ArrayList<Ray> rays){
        for(Ray ray: rays) ray.castRay(this);
    }

    public Frame getFrame(){
        return this.frame;
    }

    public JFrame getScreen(){
        return this.screen;
    }

    public void renderScreen(){
        frame.renderFrame();
        screen.add(frame);
    }

    public void clearScreen(){
        frame.clearFrame();
    }

}


