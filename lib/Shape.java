package lib;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
    
    private int startX, startY;
    private int endX, endY;
    private int shapeType;
    Color color;

    Shape(){
        this.startX = Constants.DEFAULT_SHAPE_POSITION;
        this.startY = Constants.DEFAULT_SHAPE_POSITION;
        this.endX = Constants.DEFAULT_SHAPE_POSITION;
        this.endY = Constants.DEFAULT_SHAPE_POSITION;
        this.shapeType = Constants.RECTANGLE_SHAPE;
        this.color = Constants.DEFAULT_SHAPES_COLOR;
    }

    public Shape(int x1, int y1, int x2, int y2, int type, Color color){
        this.startX = x1;
        this.startY = y1;
        this.endX = x2;
        this.endY = y2;
        this.shapeType = type;
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color _color){
        this.color = _color;
    }

    public int getStartX(){
        return this.startX;
    }

    public int getStartY(){
        return this.startY;
    }

    public void setLocation (int x, int y){
        this.startX = x;
        this.startY = y;
    }

    public int getEndX(){
        return this.endX;
    }

    public int getEndY(){
        return this.endY;
    }

    public int getShapeType(){
        return this.shapeType;
    }

    public void setShapeType(int type){
        this.shapeType = type;
    }

    public void draw (Graphics graphics){
        switch (this.getShapeType()) {
            case Constants.RECTANGLE_SHAPE:
                graphics.setColor(this.getColor());
                graphics.fillRect(startX, startY, endX, endY);
                break;
            case Constants.LINE_SHAPE:
                graphics.setColor(this.getColor());
                graphics.drawLine(startX, startY, endX, endY);
                break;
        }
    }
}