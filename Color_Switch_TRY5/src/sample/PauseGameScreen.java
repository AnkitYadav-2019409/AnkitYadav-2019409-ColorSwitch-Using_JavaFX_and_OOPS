package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PauseGameScreen {


    @FXML private AnchorPane PauseScreenAnchorPane;


    //Buttons Functions:
    public void BackToMainMenuButton() throws IOException {
        System.out.println("Back To Main Menu Button Daba Dia Bhaiya!");
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        PauseScreenAnchorPane.getChildren().setAll(root);
    }
    public void ResumeGameButton() throws IOException {
        System.out.println("Resume Game Button Daba Dia Bhaiya!");
        Parent root = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        PauseScreenAnchorPane.getChildren().setAll(root);
    }

}
