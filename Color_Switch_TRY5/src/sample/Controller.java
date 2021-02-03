package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {


    @FXML
    private AnchorPane GameMenuAnchorPane;

    public void Play() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        GameMenuAnchorPane.getChildren().setAll(root);
        System.out.println("Daba Dia Bhaiya!!");

//        Stage stage = new Stage();
//        stage.setTitle("Gameplay");
//        stage.setScene(new Scene(root, 640, 420));
//        stage.show();
    }


    public void Main_Play() throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("TheMainGame.fxml"));
//        GameMenuAnchorPane.getChildren().setAll(root);
//        System.out.println("Daba Dia Bhaiya!!");
        TheMainGame2 theMainGame2 = new TheMainGame2();
        Stage stage = new Stage();
        theMainGame2.start(stage);
    }

    public void Exit() {
        System.exit(0);
    }

    public void SettingButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SettingPage.fxml"));
        GameMenuAnchorPane.getChildren().setAll(root);
        System.out.println("Setting Button Pressed!");
    }
    public void Saved_GamesButton() throws IOException {
        //System.out.println("Daba Dia Bhaiya!!");
        Parent root = FXMLLoader.load(getClass().getResource("SavedGamesScreen.fxml"));
        GameMenuAnchorPane.getChildren().setAll(root);
        System.out.println("Saved_Games Button Pressed!");
    }
    public void HelpButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HelpPage.fxml"));
        GameMenuAnchorPane.getChildren().setAll(root);
        System.out.println("Help Button Pressed!");
    }
    public void High_ScoresButton() {
        System.out.println("High_Scores Button Pressed!");
    }
}



