package src;

import java.awt.Color;
import java.util.ArrayList;

import lib.Constants;
import util.Maths;
import util.Ray;
import util.Screen;

public class Player {
    
    private float posX, posY;
    private float direction;
    private float viewingAngle;

    public Player(){
        this.posX = Constants.DEFAULT_X_POSITION;
        this.posY = Constants.DEFAULT_Y_POSITION;
        this.direction = Constants.DEFAULT_DIRECTION;
        this.viewingAngle = Constants.DEFAULT_VIEWING_ANGLE;
    }

    public Player(int x, int y){
        this.posX = x;
        this.posY = y;
        this.direction = Constants.DEFAULT_DIRECTION;
        this.viewingAngle = Constants.DEFAULT_VIEWING_ANGLE;
    }

    public Player (float _direction, float _viewingAngle) {
        this.posX = Constants.DEFAULT_X_POSITION;
        this.posY = Constants.DEFAULT_Y_POSITION;
        this.direction = _direction;
        this.viewingAngle = _viewingAngle;
    }

    public Player (float x, float y, float _direction, float _viewingAngle) {
        this.posX = x;
        this.posY = y;
        this.direction = _direction;
        this.viewingAngle = _viewingAngle;
    }

    public float getPositionX(){
        return this.posX;
    }

    public float getPositionY(){
        return this.posY;
    }

    public void setPosition(float x, float y){
        this.posY = x;
        this.posY = y;
    }

    public float getDirection(){
        return this.direction;
    }

    public void setDirection(float _direction){
        this.direction = _direction;
    }

    public float getViewingAngle(){
        return this.viewingAngle;
    }

    public void setViewingAngle(float angle){
        this.viewingAngle = angle;
    }

    public void moveForward (float step) {
        float xOffset = step * (float)Maths.cos(direction);
        float yOffset = step * (float)Maths.sin(direction);
        this.posX += xOffset;
        this.posY += yOffset;
    }

    public void moveBackward (float step) {
        float xOffset = step * (float)Maths.cos(direction);
        float yOffset = step * (float)Maths.sin(direction);
        this.posX -= xOffset;
        this.posY -= yOffset;
    }

    public void increaseDirection (float step){
        this.direction += step;
        this.direction = Maths.shiftAngleInRange(this.direction);
    }

    public void decreaseDirection (float step){
        this.direction -=  step;
        this.direction = Maths.shiftAngleInRange(this.direction);
    }

    public void increaseViewingAngle(float step){
        this.viewingAngle += step;
    }

    public void decreaseViewingAngle(float step){
        this.viewingAngle -= step;
    }

    public void moveForward () {
        float step = Constants.DEFAULT_POSITION_OFFSET;
        float xOffset = (float)step * (float)Maths.cos(viewingAngle);
        float yOffset = (float)step * (float)Maths.sin(viewingAngle);
        this.posX += xOffset;
        this.posY += yOffset;
    }

    public void moveBackward () {
        float step = Constants.DEFAULT_POSITION_OFFSET;
        float xOffset = step * Maths.cos(viewingAngle);
        float yOffset = step * Maths.sin(viewingAngle);
        this.posX -= xOffset;
        this.posY -= yOffset;
    }

    public void increaseDirection (){
        float step = Constants.DEFAULT_DIRECTION_OFFSET;
        this.direction += step;
        this.direction = Maths.shiftAngleInRange(this.direction);
    }

    public void decreaseDirection (){
        float step = Constants.DEFAULT_DIRECTION_OFFSET;
        this.direction -=  step;
        this.direction = Maths.shiftAngleInRange(this.direction);
    }

    public void increaseViewingAngle(){
        float step = Constants.DEFAULT_VIEWING_ANGLE_OFFSET;
        this.viewingAngle += step;
    }

    public void decreaseViewingAngle(){
        float step = Constants.DEFAULT_VIEWING_ANGLE_OFFSET;
        this.viewingAngle -= step;
    }

    public boolean isPlayerInWall(World world) {
        if (world.getBlock( (int)(this.getPositionY()/ world.getBlockSize()), 
        (int)(this.getPositionX()/ world.getBlockSize())) != 0) {
            return true;
        }
        return false;        
    }

    public void drawPlayerOnScreen(Screen screen){
        Color playerColor = Constants.DEFAULT_PLAYER_COLOR;

        screen.drawRectangle((int) this.getPositionX() - Constants.DEFAULT_PLAYER_SIZE/2,
                            (int) this.getPositionY() - Constants.DEFAULT_PLAYER_SIZE/2,
                            Constants.DEFAULT_PLAYER_SIZE, Constants.DEFAULT_PLAYER_SIZE, playerColor);
    }

    private Ray castRay (float angle, Screen screen, World world) {
        float blockSize = world.getBlockSize();
        float playerX = this.getPositionX(), playerY = this.getPositionY();
        float posHorizontalX = Float.MAX_VALUE, posHorizontalY = Float.MAX_VALUE;
        float posVerticalX = Float.MAX_VALUE, posVerticalY = Float.MAX_VALUE;
        float xOffset = 0;
        float yOffset = 0;
        int posRayX, posRayY;

        //for the rays coinciding with vertical walls
        if (angle <= 90 || angle > 270){
            posVerticalX = ((int)(playerX/blockSize) + 1.0F) * blockSize;
            posVerticalY = playerY + Maths.absolute(playerX - posVerticalX) * Maths.tan(angle);
            xOffset = blockSize;
            yOffset = xOffset * Maths.tan(angle);

        }
        else{
            posVerticalX = (int)(playerX/blockSize) * blockSize;
            posVerticalY = playerY - Maths.absolute(playerX - posVerticalX) * Maths.tan(angle);
            xOffset = -blockSize;
            yOffset = (float)xOffset * Maths.tan(angle);
        }
        
        for(int counter = 0; counter < world.getWorldSize() - 1; counter++) {
            if (world.getBlockValue(posVerticalX, posVerticalY, angle, true) != 0) break;
            posVerticalX += xOffset;
            posVerticalY += yOffset;
        }
        
        //for the rays coinciding with horizontal walls
        if (angle >= 0 && angle <= 180) {
            posHorizontalY = ((int)(playerY/blockSize) + 1)*blockSize;
            posHorizontalX = (int)(playerX + Maths.absolute(playerY - posHorizontalY) / Maths.tan(angle));
            yOffset = blockSize;
            xOffset = yOffset / Maths.tan(angle);
        }
        else{
            posHorizontalY = (int)(playerY/blockSize)*blockSize;
            posHorizontalX = (int)(playerX - Maths.absolute(playerY - posHorizontalY) / Maths.tan(angle));
            yOffset = -blockSize;
            xOffset = yOffset / Maths.tan(angle);
        }

        for(int counter = 0; counter < world.getWorldSize() - 1; counter++) {
            if (world.getBlockValue(posHorizontalX, posHorizontalY, angle, false) != 0) break;
            posHorizontalX += xOffset;
            posHorizontalY += yOffset;
        }

        float horizontalDistance = Maths.distance(playerX, playerY, posHorizontalX, posHorizontalY);
        float verticalDistance =  Maths.distance(playerX, playerY, posVerticalX, posVerticalY);
        boolean horizontalFlag = false;

        if (horizontalDistance < verticalDistance){
            posRayX = (int)posHorizontalX;
            posRayY = (int)posHorizontalY;
            horizontalFlag = true;
        }
        else{
            posRayX = (int)posVerticalX;
            posRayY = (int)posVerticalY;
        }

        Ray ray = new Ray ((int)playerX, (int)playerY, posRayX, posRayY, Maths.absolute(angle - this.getDirection()), horizontalFlag);
        return ray;
    }

    public void printPlayerDetails(){
        System.out.print("Position: (" + this.getPositionX() + ", " + this.getPositionY() + ")");
        System.out.println("\tDirection: " + this.getDirection() + "\tViewing Angle: " + this.getViewingAngle());
    }

    public ArrayList<Ray> castRays(Screen screen, World world) {
        ArrayList<Ray> castedRays = new ArrayList<>();
        for (float angle = this.direction - (this.viewingAngle/2.0F); 
            angle < this.direction + (this.viewingAngle/2.0F); 
            angle += Constants.DEFAULT_VIEWING_ANGLE_OFFSET){
            castedRays.add(castRay (Maths.shiftAngleInRange(angle), screen, world));
        }
        return castedRays;
    }

}