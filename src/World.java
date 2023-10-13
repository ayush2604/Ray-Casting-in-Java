package src;

import java.awt.Color;
import java.util.ArrayList;
import lib.Constants;
import util.Maths;
import util.Ray;
import util.Screen;

public class World {
    
    private int world[];
    private int worldSize;
    private int blockSize;

    public World(){
        world = new int[Constants.WORLD_SIZE*Constants.WORLD_SIZE];
        worldSize = Constants.WORLD_SIZE;
        blockSize = Constants.BLOCK_SIZE;
    }

    public boolean isValidIndex(int x, int y){
        return x >= 0 && y >= 0 && x < this.getWorldSize() && y < this.getWorldSize();
    }

    public int[] getWorld(){
        return this.world;
    }

    public int getWorldSize(){
        return this.worldSize;
    }

    public int getBlock(int x, int y){
        if (isValidIndex(x, y)) return world[x*this.getWorldSize() + y];
        return 0;
    }

    public void setWorldSize(int size){
        this.worldSize = size;
        blockSize = Constants.SCREEN_HEIGHT/this.worldSize;
    }

    public int getBlockSize(){
        return this.blockSize;
    }

    public void setWorld(int[] _world){
        this.world = _world;
    }

    public void initialiseWorld(){
        this.setWorld(Constants.DEFAULT_WORLD);
    }

    public int getBlockValue(float x, float y, float angle, boolean isVertical){
        boolean isHorizontal = !isVertical;
        int xIndex = (int)(y / (float) this.getBlockSize());
        int yIndex = (int)(x / (float) this.getBlockSize());
        if (angle > 90.0F && angle < 180.0F){
            if (isVertical) yIndex--;
        }
        else if (angle >= 180.0F && angle < 270.0F){
            if (isVertical) yIndex--;
            else xIndex--;
        }
        else if (angle >= 270.0F && angle < 360.0F){
            if (isHorizontal) xIndex--;
        }
        return this.getBlock(xIndex, yIndex);
    }

    public void drawWorldOnScreen(Screen screen){
        for (int row = 0; row < this.getWorldSize(); row++){
            for(int col = 0; col < this.getWorldSize(); col++){
                Color blockColor = this.getBlock(row, col) == 1 ? Color.black : Color.gray;
                int blockSize = this.getBlockSize();
                screen.drawRectangle(col * blockSize, row * blockSize, blockSize - 1, blockSize - 1, blockColor);
            }
        }
    }

    public void renderWorldOnScreen(ArrayList<Ray> rays, Screen screen){
        int renderingAreaWidth = Constants.SCREEN_WIDTH - Constants.SCREEN_HEIGHT;
        int renderingAreaHeight = Constants.SCREEN_HEIGHT;
        int renderedRectanglePositionX = (int)((float)renderingAreaHeight);
        int renderedRectanglePositionY = (int)((float)renderingAreaHeight/2.0F);
        int renderedRectangleWidth = renderingAreaWidth / rays.size();
        int renderedRectangleHeight = 0;
        //sky
        screen.drawRectangle(renderedRectanglePositionX, 0, 
                             renderedRectangleWidth * rays.size(), renderingAreaHeight/2, new Color(135, 206, 235));
        //ground
        screen.drawRectangle(renderedRectanglePositionX, renderedRectanglePositionY,
                             renderedRectangleWidth * rays.size(), renderingAreaHeight/2, new Color(234,182,79));
        for (Ray ray: rays) {
            Color color = new Color(0,255,100);
            if (ray.getIsHorizontal()) color = new Color(0,200,75);
            renderedRectangleHeight = (int)(Constants.RENDERING_AMPLIFICATION_FACTOR/(Maths.cos(ray.getAngle())*ray.getRayLength()));
            screen.drawRectangle(renderedRectanglePositionX, renderedRectanglePositionY - renderedRectangleHeight/2,
                                    renderedRectangleWidth, renderedRectangleHeight, color);
            renderedRectanglePositionX += renderedRectangleWidth;
        }
    }
}
