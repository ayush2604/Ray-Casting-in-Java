package util;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import lib.Constants;
import lib.Shape;
import javax.swing.JPanel;

public class Frame extends JPanel{

    ArrayList<Shape> components;

    public Frame(){
        components = new ArrayList<>();
    }

    public JPanel getFrame(){
        return this;
    }

    public void addRectangle(int x, int y, int width, int height, Color color){
        components.add(new Shape(x,y,width,height,Constants.RECTANGLE_SHAPE, color));
    }

    public void addLine (int x1, int y1, int x2, int y2, Color color){
        components.add(new Shape(x1,y1,x2,y2,Constants.LINE_SHAPE, color));
    }

    protected void paintComponent (Graphics graphics){
        try {
            super.paintComponent(graphics);
            graphics.setColor(Color.red);
            for (Shape shape : components){
                shape.draw(graphics);
            }
        } catch (Exception e) {}
    }
        

    public void clearFrame(){
        components = new ArrayList<>();
        repaint();
    }

    public void renderFrame(){
        repaint();
    }
}
