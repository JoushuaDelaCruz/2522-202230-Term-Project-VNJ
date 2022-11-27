package ca.bcit.comp2522.termproject.vnj.BackToNature;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Character.MainCharacter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.awt.Point;

/**
 * The game driver.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class Main extends Application {
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
    /**
     * Default number that is associated with North.
     */
    public static final int NORTH = 1;
    /**
     * Default number that is associated with SOUTH.
     */
    public static final int SOUTH = 2;
    /**
     * Default number that is associated with EAST.
     */
    public static final int EAST = 3;
    /**
     * Default number that is associated with WEST.
     */
    public static final int WEST = 4;
    /**
     * Default frame rate per seconds.
     */
    public static final int FPS = 60;
    /**
     * Default nano seconds per seconds.
     */
    public static final int NANO_PER_SECONDS = 1000000000;
    private GraphicsContext graphicsContext;
    private final boolean gameOver = false;
    private AnimationTimer timer;
    private MainCharacter player;
    private FarmLand farmLand;
    /**
     * Creates and displays the game objects in a JavFX Window.
     *
     * @param stage contains the Scene
     */
    public void start(final Stage stage) {
        stage.setTitle("Back To Nature");
        stage.setResizable(false);
        player = new MainCharacter("Joushua", new Point(0, 0), "FacingForwardSprite.png");
        GridPane gridPane = new GridPane();
        Group root = new Group(gridPane, player.getImageView());
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        farmLand = new FarmLand(MAX_ROWS, MAX_COLUMNS);
        farmLand.draw(gridPane);
        scene.setOnKeyPressed(this::processKeyPress);
        stage.setScene(scene);
        stage.show();
//        run();
    }

    /**
     * Listens to keys input by the user and might change the map or moves the character.
     *
     * @param event a key input
     */
    public void processKeyPress(final KeyEvent event) {
        switch (event.getCode()) {
            case UP -> {
                if (player.getImageView().getY() > 0) {
                    player.move(NORTH);
                }
            }
            case DOWN -> {
                if (player.getImageView().getY() < (SCREEN_HEIGHT - TILE_SIZE)) {
                    player.move(SOUTH);
                }
            }
            case RIGHT -> {
                if (player.getImageView().getX() < (SCREEN_WIDTH - TILE_SIZE)) {
                    player.move(EAST);
                }
            }
            case LEFT -> {
                if (player.getImageView().getX() > 0) {
                    player.move(WEST);
                }
            }
            case A -> {
                int x = (int) ((player.getImageView().getX() / TILE_SIZE));
                int y = (int) ((player.getImageView().getY() / TILE_SIZE));
                farmLand.setTillSoilImage(new Point(x, y));
            }
            default -> { }
        }
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
