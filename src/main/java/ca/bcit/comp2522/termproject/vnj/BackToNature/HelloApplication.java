package ca.bcit.comp2522.termproject.vnj.BackToNature;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Character.MainCharacter;
import ca.bcit.comp2522.termproject.vnj.BackToNature.Tool.Hoe;
import ca.bcit.comp2522.termproject.vnj.BackToNature.Tool.WateringCan;
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
import java.util.ArrayList;

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
        Image Hoe = new Image("farmerwithhoe.png");
        Image Seed = new Image("seed.png");
        Image WateringCan = new Image("playerwithwater.png");
        //ArrayList<Image> tools = new ArrayList<Image>();
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

        if (press.getCode() == KeyCode.F) {
            ImageView.setImage(Seed);
        } else if (press.getCode() == KeyCode.E) {
            ImageView.setImage(WateringCan);
        } else if (press.getCode() == KeyCode.Q) {
            ImageView.setImage(Hoe);
        }
    }

//    public void Inventory(final KeyEvent press) {
//        int counter = 0;
//        Image Hoe = new Image("playerwithhoe.png");
//        Image Seed = new Image("playerwithseed.png");
//        Image WateringCan = new Image("playerwithwater.png");
//        ArrayList<Image> tools = new ArrayList<Image>();
//        tools.add(Hoe);
//        tools.add(Seed);
//        tools.add(WateringCan);
////        if (press.getCode() == KeyCode.R){
////            ImageView.setImage(Seed);
////        }
////        if (counter == 1){
////            ImageView.setImage(Hoe);
////        }




    public static void main(String[] args) {
        launch();
    }
}