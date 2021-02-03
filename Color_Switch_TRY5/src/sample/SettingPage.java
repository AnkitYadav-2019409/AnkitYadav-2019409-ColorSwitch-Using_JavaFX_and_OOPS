package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

public class SettingPage {


    @FXML private AnchorPane SettingPageAnchorPane;
    @FXML private CheckBox PlayMusicCheckBox;


    public void GoingBackToMainMenu() throws IOException {
        //System.out.println("Daba Dia Bhaiya!!");
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        SettingPageAnchorPane.getChildren().setAll(root);
        //System.out.println("BackToMainMenu Daba Dia Bhaiya!!");
    }

    public void BoxChecked() throws InterruptedException {

        //addmusic();

        if (PlayMusicCheckBox.isSelected()) {
            Music.getInstance().play();

        }
        else {
            Music.getInstance().stop();
        }
    }
}


class Music {
    private static MediaPlayer gen = null;
    public static MediaPlayer getInstance()
    {
        if (gen == null) {
            String s = "src/BG_Music.mp3";
            Media h = new Media(new File(s).toURI().toString());
            gen = new MediaPlayer(h);
        }
        return gen;
    }
    private Music() {
        String s = "src/BG_Music.mp3";
        Media h = new Media(new File(s).toURI().toString());
        gen = new MediaPlayer(h);
    }
}


