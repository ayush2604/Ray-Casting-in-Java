package src;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import lib.Constants;
import util.Screen;
import util.Ray;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App implements KeyListener{

    private World world;
    private Screen screen;
    private Player player;
    private boolean exitCode;

    public App(){
        world = new World();
        screen = new Screen();
        player = new Player(100.0F,100.0F, 90.0F, 60.0F);
        exitCode = false;
        initialiseKeyManagement();
    }

    private void initialiseKeyManagement(){
        JFrame keyHandler = screen.getScreen();
        keyHandler.addKeyListener(this);
        keyHandler.setFocusable(true);
        keyHandler.setFocusTraversalKeysEnabled(false);
        keyHandler.setVisible(true);
    }

    public void refreshApp(){
        world.initialiseWorld();
        while (true) {
            if (exitCode) break;
            world.drawWorldOnScreen(screen);
            player.drawPlayerOnScreen(screen);
            ArrayList<Ray> castedRays = player.castRays(screen, world);
            screen.drawCastedRays(castedRays);
            world.renderWorldOnScreen(castedRays, screen);
            screen.renderScreen();
            try {
                TimeUnit.MILLISECONDS.sleep( (long) (1000 / Constants.FPS) );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            screen.clearScreen();
        }
    }

    @Override
    public void keyTyped(KeyEvent key) {
        if (key.getKeyChar() == 'w') {
            player.moveForward(Constants.DEFAULT_PLAYER_STEP);
            if (player.isPlayerInWall(world)) {
                player.moveBackward(Constants.DEFAULT_PLAYER_STEP);
            }
        }
        else if (key.getKeyChar() == 's') {
            player.moveBackward(Constants.DEFAULT_PLAYER_STEP);
            if (player.isPlayerInWall(world)){
                player.moveForward(Constants.DEFAULT_PLAYER_STEP);
            }
        }
        else if (key.getKeyChar() == 'd') {
            player.increaseDirection(Constants.DEFAULT_PLAYER_ANGLE_STEP);
        }
        else if (key.getKeyChar() == 'a') {
            player.decreaseDirection(Constants.DEFAULT_PLAYER_ANGLE_STEP);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
