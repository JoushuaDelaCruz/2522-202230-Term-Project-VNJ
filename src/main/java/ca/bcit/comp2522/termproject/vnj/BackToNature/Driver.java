package ca.bcit.comp2522.termproject.vnj.BackToNature;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Character.MainCharacter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    /**
     * Default x-layout of the start btn.
     */
    public static final int DEFAULT_BTN_XCOORDINATE = 300;
    /**
     * Default y-layout of the start btn.
     */
    public static final int DEFAULT_BTN_YCOORDINATE = 360;
    /**
     * Default x-layout of the end btn.
     */
    public static final int END_BTN_XCOORDINATE = 670;
    /**
     * Default y-layout of the end btn.
     */
    public static final int END_BTN_YCOORDINATE = 720;
    /**
     * Default numbers of wilted crops for the game player to lose.
     */
    public static final int DEFAULT_GAME_OVER = 3;
    /**
     * Default starting point of the user.
     */
    public static final Point STARTING_POINT = new Point(360, 360);
    private MainCharacter player;
    private FarmLand farmLand;
    private GraphicsContext graphicsContext;
    private boolean gameOver;
    /**
     * Creates and displays the game objects in a JavFX Window.
     *
     * @param stage contains the Scene
     */
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Back To Nature");
        Image backgrounds = new Image("friends.jpg", SCREEN_WIDTH, SCREEN_HEIGHT, true, true);
        Image exit = new Image("EndPage.png", SCREEN_WIDTH, SCREEN_HEIGHT, true, true);
        Image startButton = new Image("button.png");
        Image exitButton = new Image("ExitBtn.png");
        ImageView endButton = new ImageView("EndButton.png");
        ImageView exitBtn = new ImageView(exitButton);
        ImageView exitPage = new ImageView(exit);
        ImageView button = new ImageView(startButton);
        ImageView background = new ImageView(backgrounds);
        Group start = new Group(background);
        Group end = new Group(exitPage);
        Scene startUp = new Scene(start);
        Scene endPage = new Scene(end);
        gameOver = false;
        stage.setResizable(false);
        player = new MainCharacter("Joushua", new Point(STARTING_POINT.x, STARTING_POINT.y),
                "FacingForwardSprite.png", SCREEN_WIDTH - TILE_SIZE, SCREEN_HEIGHT - TILE_SIZE);
        javafx.scene.canvas.Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        Group root = new Group(canvas, player.getImageView());
        graphicsContext = canvas.getGraphicsContext2D();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        farmLand = new FarmLand(SCREEN_WIDTH, SCREEN_HEIGHT);
        farmLand.draw(graphicsContext);
        scene.setOnKeyPressed(this::processKeyPressed);
        scene.setOnKeyReleased(keyEvent -> player.resetMovements());
        Button btn = new Button();
        btn.setGraphic(button);
        btn.setFocusTraversable(false);
        btn.setBackground(null);
        btn.setLayoutX(DEFAULT_BTN_XCOORDINATE);
        btn.setLayoutY(DEFAULT_BTN_YCOORDINATE);
        btn.setOnAction(e -> stage.setScene(scene));
        Button endBtn = new Button();
        endBtn.setGraphic(endButton);
        endBtn.setFocusTraversable(false);
        endBtn.setBackground(null);
        endBtn.setLayoutX(END_BTN_XCOORDINATE);
        endBtn.setLayoutY(END_BTN_YCOORDINATE);
        root.getChildren().add(endBtn);
        start.getChildren().add(btn);
        endBtn.setOnAction(e -> stage.setScene(endPage));
        Button closeBtn = new Button();
        closeBtn.setGraphic(exitBtn);
        closeBtn.setFocusTraversable(false);
        closeBtn.setBackground(null);
        closeBtn.setLayoutX(END_BTN_XCOORDINATE);
        closeBtn.setLayoutY(END_BTN_YCOORDINATE);
        end.getChildren().add(closeBtn);
        closeBtn.setOnAction(e -> Platform.exit());
        stage.setScene(startUp);
        stage.show();
        AnimationTimer timer = new Timer();
        timer.start();
        farmLand.drawCrops();
    }
    /**
     * Processes the keys pressed by the user.
     *
     * @param event the KeyEvent
     */
    private void processKeyPressed(final KeyEvent event) {
        if (!gameOver) {
            switch (event.getCode()) {
                case W -> player.setMovingUp(true);
                case S -> player.setMovingDown(true);
                case A -> player.setMovingLeft(true);
                case D -> player.setMovingRight(true);
                case SPACE -> waterPlant();
                default -> {
                }
            }
        }
    }

    /**
     * Waters the soil.
     */
    public void waterPlant() {
        Point userLocation = new Point(player.getXCoordinate(), player.getYCoordinate());
        farmLand.waterSoil(userLocation);
        farmLand.draw(graphicsContext);
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
        /**
         * Default number of days for the plants to grow.
         */
        public static final int DEFAULT_DAYS_TO_GROW = 3;
        private final double drawInterval;
        private double delta;
        private long lastTime;
        private long timer;
        private int days;

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
                repaint();
                delta--;
            }
            if (timer >= NANO_UNITS_IN_SECOND) {
                timer = 0;
                days++;
            }
            if (days >= DEFAULT_DAYS_TO_GROW) {
                grow();
                checkGameState();
                days = 0;
            }
            if (gameOver) {
                stop();
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
     * Re-draws the map.
     */
    public void repaint() {
        farmLand.draw(graphicsContext);
    }

    /**
     * Grows the plants.
     */
    public void grow() {
        farmLand.growPlants();
        farmLand.drawPlants();
        farmLand.drySoils();
    }

    /**
     * Checks if the game is over or if the player won!
     */
    public void checkGameState() {
        if (farmLand.getWiltedCrops() > DEFAULT_GAME_OVER) {
            gameOver = true;
            System.out.println("You lose");
        }
        if (farmLand.allRipening()) {
            gameOver = true;
            System.out.println("You won!");
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
