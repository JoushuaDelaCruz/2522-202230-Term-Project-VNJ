package ca.bcit.comp2522.termproject.vnj.BackToNature;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Character.MainCharacter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



import java.io.IOException;

public class HelloApplication extends Application {

    private ImageView ImageView;

    private int move = 20;
    @Override
    public void start(Stage stage) throws IOException {
        Image character = new Image("player.png");
        ImageView = new ImageView(character);
        MainCharacter player = new MainCharacter("Jesus", new Point(0,0));
        stage.setTitle("Back To Nature");
        Group root = new Group(ImageView);
        Canvas canvas = new Canvas(800, 800);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(this::WASD);
        scene.setFill(Color.WHITE);
        stage.setScene(scene);
        stage.show();
    }

    public void WASD(final KeyEvent press){
        Image left = new Image("left.png");
        Image character = new Image("player.png");
        Image right = new Image("right.png");
        Image up = new Image("up.png");
        if (press.getCode() == KeyCode.W) { // moves character up
            ImageView.setImage(up);
            ImageView.setY(ImageView.getY() - move);
        } else if (press.getCode() == KeyCode.S) { // moves character down
            ImageView.setImage(character);
            ImageView.setY(ImageView.getY() + move);
        } else if (press.getCode() == KeyCode.D) { // moves character right
            ImageView.setImage(right);
            ImageView.setX(ImageView.getX() + move);
        } else if (press.getCode() == KeyCode.A) {// moves character left
            ImageView.setImage(left);
            ImageView.setX(ImageView.getX() - move);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}