package ca.bcit.comp2522.termproject.vnj.BackToNature;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Character.MainCharacter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.awt.Point;

/**
 * Main driver of the game.
 *
 * @version 2022
 * @author Joushua Dela Cruz
 */
public class Driver extends Application {
    /* Default screen Setting */
    /**
     * Default tile size of the game in pixels.
     */
    public static final int ORIGINAL_TILE_SIZE = 16; // 16x16 tile
    /**
     * Default scale to accommodate with any screen resolutions. (To make images bigger)
     */
    public static final int SCALE = 3;
    /**
     * Default number for the tile size on the game.
     */
    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48 tile
    /**
     * Default max number of columns.
     */
    public static final int MAX_COLUMNS = 16;
    /**
     * Default max number of rows.
     */
    public static final int MAX_ROWS = 16;
    /**
     * Default screen width of the window.
     */
    public static final int SCREEN_WIDTH = TILE_SIZE * MAX_COLUMNS;
    /**
     * Default screen height of the window.
     */
    public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_ROWS;
    private MainCharacter player;
    /**
     * Creates and displays the game objects in a JavFX Window.
     *
     * @param stage contains the Scene
     */
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Back To Nature");
        stage.setResizable(false);
        player = new MainCharacter("Joushua", new Point(0, 0), "FacingForwardSprite.png");
        javafx.scene.canvas.Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        Group root = new Group(canvas, player.getImageView());
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        FarmLand farmLand = new FarmLand(SCREEN_WIDTH, SCREEN_HEIGHT);
        farmLand.draw(graphicsContext);
        scene.setOnKeyPressed(this::processKeyPressed);
        scene.setOnKeyReleased(keyEvent -> player.resetMovements());
        stage.setScene(scene);
        stage.show();
        AnimationTimer timer = new Timer();
        timer.start();
    }

    /**
     * Processes the keys pressed by the user.
     *
     * @param event the KeyEvent
     */
    private void processKeyPressed(final KeyEvent event) {
        switch (event.getCode()) {
            case W -> player.setMovingUp(true);
            case S -> player.setMovingDown(true);
            case A -> player.setMovingLeft(true);
            case D -> player.setMovingRight(true);
            default -> {
            }
        }
    }
    /**
     * A timer that updates all the frame in the game while it is not yet game over.
     */
    private class Timer extends AnimationTimer {
        /**
         * Default frame rate per seconds.
         */
        public static final int FPS = 60;
        /**
         * Default number of nano in a second.
         */
        public static final int NANO_UNITS_IN_SECOND = 1000000000;
        private final double drawInterval;
        private double delta;
        private long lastTime;
        private long timer;
        private int drawCount;

        /**
         * Constructs a timer into their default value.
         */
        Timer() {
            drawInterval = NANO_UNITS_IN_SECOND / FPS;
            lastTime = System.nanoTime();
        }

        /**
         * Updates and redraws each frame on the screen.
         *
         * @param now the time in nanoseconds.
         */
        @Override
        public void handle(final long now) {
            delta += (now - lastTime) / drawInterval;
            timer += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {
                update();
                delta--;
                drawCount++;
            }
            if (timer >= NANO_UNITS_IN_SECOND) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    /**
     * Updates the scene: the user's movement, images, crops, etc.
     */
    public void update() {
        player.move();
    }
    /**
     * Launches the JavaFX application.  We still need a main method in our
     * JavaFX applications.  The main method must do one thing.  Pass
     * the command line arguments (args) to the launch method inherited from
     * the Application class.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}