package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;

public class HelpPage {

    @FXML private AnchorPane HelpPageAnchorPane;


    public void GoingBackToMainMenu() throws IOException {
        //System.out.println("Daba Dia Bhaiya!!");
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        HelpPageAnchorPane.getChildren().setAll(root);
        //System.out.println("BackToMainMenu Daba Dia Bhaiya!!");
    }

}
