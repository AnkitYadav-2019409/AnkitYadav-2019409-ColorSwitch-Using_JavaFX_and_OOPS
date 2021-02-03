package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Color Switch v1.0");

        Scene meraScene = new Scene(root, 385, 640);
        primaryStage.setScene(meraScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



