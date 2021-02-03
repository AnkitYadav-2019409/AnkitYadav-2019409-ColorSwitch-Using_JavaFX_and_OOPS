package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SavedGamesScreen {


    @FXML private AnchorPane SavedGamesScreenAnchorPane;
    @FXML private TableView SavedGamesTableView;
    @FXML private TableColumn GameIDColumn;
    @FXML private TableColumn DateCreatedColumn;
    @FXML private TableColumn ActionColumn;

    //Button Functions
    public void BackToMainMenuButton() throws IOException {
        System.out.println("Daba Dia Bhaiya!!");
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        SavedGamesScreenAnchorPane.getChildren().setAll(root);
        System.out.println("BackToMainMenu Daba Dia Bhaiya!!");
    }
}
