package util;

import java.awt.Color;
import lib.Constants;

public class Ray {
    private int startPosX, startPosY;
    private int endPosX, endPosY;
    private Color color;
    private boolean isHorizontal, isVertical;
    private float angle;

    public Ray(){
        this.startPosX = Constants.DEFAULT_START_X_POSITION;
        this.startPosY = Constants.DEFAULT_START_Y_POSITION;
        this.endPosX = Constants.DEFAULT_END_X_POSITION;
        this.endPosY = Constants.DEFAULT_END_Y_POSITION;
        this.color = Constants.DEFAULT_RAY_COLOR;
        this.angle = 0.0F;
        this.isHorizontal = false;
        this.isVertical = false;
    }

    public Ray(int startX, int startY, int endX, int endY, float angle, boolean isHorizontal){
        this.startPosX = startX;
        this.startPosY = startY;
        this.endPosX = endX;
        this.endPosY = endY;
        this.color = Constants.DEFAULT_RAY_COLOR;
        this.angle = angle;
        this.isHorizontal = isHorizontal;
        this.isVertical = !this.isHorizontal;
    }

    public int getRayStartPositionX(){
        return this.startPosX;
    }

    public int getRayStartPositionY(){
        return this.startPosY;
    }

    public int getRayEndPositionX(){
        return this.endPosX;
    }

    public int getRayEndPositionY(){
        return this.endPosY;
    }

    public void setIsHorizontal(boolean flag){
        this.isHorizontal = flag;
    }

    public void setIsVertical(boolean flag) {
        this.isVertical = flag;
    }

    public boolean getIsHorizontal(){
        return this.isHorizontal;
    }

    public boolean getIsVertical(){
        return this.isVertical;
    }

    public float getRayLength(){
        return Maths.distance(startPosX, startPosY, endPosX, endPosY);
    }

    public void setRayStartPosition(int startX, int startY){
        this.startPosX = startX;
        this.startPosY = startY;
    }

    public void setRayEndPosition(int endX, int endY){
        this.endPosX = endX;
        this.endPosY = endY;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public float getAngle(){
        return this.angle;
    }

    public void setAngle(float angle){
        this.angle = angle;
    }

    public void castRay(Screen screen){
        screen.drawLine(this.getRayStartPositionX(), this.getRayStartPositionY(), this.getRayEndPositionX(), this.getRayEndPositionY(), this.getColor());
    }

    public void printRayDetails(){
        System.out.print("Ray from point (");
        System.out.print(startPosX + ", " + startPosY + ") to point (");
        System.out.print(endPosX + ", " + endPosY + ").");
        System.out.println("\tRay Length: " + this.getRayLength());
    }
}
