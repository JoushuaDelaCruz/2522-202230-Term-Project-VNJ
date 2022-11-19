package ca.bcit.comp2522.termproject.vnj.BackToNature;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The game driver.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class Main extends Application {
    /**
     * Creates and displays the game objects in a JavFX Window.
     *
     * @param stage contains the Scene
     */
    public void start(final Stage stage) {
        Text hello = new Text(50, 50, "Hello, JavaFX!");
        Text question = new Text(120, 80, "How's it going?");

        Group root = new Group(hello, question);
        Scene scene = new Scene(root, 300, 120, Color.LIGHTGREEN);

        stage.setTitle("A JavaFX Program");
        stage.setScene(scene);
        stage.show();
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
