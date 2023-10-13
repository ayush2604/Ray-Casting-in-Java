package lib;

import java.awt.Color;

public class Constants {

    //constants for the player
    public static final float DEFAULT_X_POSITION = 0;
    public static final float DEFAULT_Y_POSITION = 0;
    public static final float DEFAULT_DIRECTION = 0.0F;
    public static final float DEFAULT_VIEWING_ANGLE = 60.0F;
    public static final float DEFAULT_POSITION_OFFSET = 1.0F;
    public static final float DEFAULT_DIRECTION_OFFSET = 5.0F;
    public static final float DEFAULT_VIEWING_ANGLE_OFFSET = 0.25F;
    public static final float DEFAULT_DIRECTION_ARROW_LENGTH = 25.0F;
    public static final Color DEFAULT_PLAYER_COLOR = Color.yellow;
    public static final int DEFAULT_PLAYER_SIZE = 15;
    public static final float DEFAULT_PLAYER_STEP = 5.0F;
    public static final float DEFAULT_PLAYER_ANGLE_STEP = 5.0F;

    //constants for the ray
    public static final int DEFAULT_START_X_POSITION = 0;
    public static final int DEFAULT_START_Y_POSITION = 0;
    public static final int DEFAULT_END_X_POSITION = 0;
    public static final int DEFAULT_END_Y_POSITION = 0;
    public static final Color DEFAULT_RAY_COLOR = Color.green;

    //screen parameters
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH = 1400;
    public static final float SCREEN_HEIGHT_ADJUSTEMENT_FACTOR = 1.065F;
    public static final float SCREEN_WIDTH_ADJUSTEMENT_FACTOR = 0.955F;

    //shapes parameters
    public static final int DEFAULT_SHAPE_POSITION = 0;
    public static final Color DEFAULT_SHAPES_COLOR = Color.black;
    public static final int RECTANGLE_SHAPE = 0;
    public static final int LINE_SHAPE = 1;

    //world parameters
    public static final int WORLD_SIZE = 20;
    public static final float RENDERING_AMPLIFICATION_FACTOR = 15000.0F;
    public static final int[] DEFAULT_WORLD = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,
                                               1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,
                                               1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,
                                               1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,
                                               1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
                                               1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
                                               1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
                                               
    public static final int BLOCK_SIZE = (int)((float)Constants.SCREEN_HEIGHT / (float)Constants.WORLD_SIZE);

    //game parameters
    public static final int FPS = 24;

}
