package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.animation.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


import java.io.IOException;

public class GameplayController {

    @FXML private AnchorPane GamePlay_AnchorPane;

    @FXML private Circle uchallatiball;

    @FXML private Group Obstacle1;

    @FXML private Group Obstacle3;

    @FXML private Group Obstacle21;

    @FXML private Group Obstacle22;

    //Ball
    private TranslateTransition BallUP;
    private RotateTransition Obstacle1Animate;
    private RotateTransition Obstacle21Animate;
    private RotateTransition Obstacle22Animate;
    private RotateTransition Obstacle3Animate;


    public void BounceBall() {
        //Jump the ball to some height

        BallUP.setToY(uchallatiball.getCenterY() - 5);
        uchallatiball.setCenterY(uchallatiball.getCenterY() - 5);
        BallUP.play();
        System.out.println("Jumped!");

    }

    public void InitializeAnimate() {


        GamePlay_AnchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case W: BounceBall();System.out.println("uireng");break;
                }
            }
        });
        BallUP = new TranslateTransition();
        BallUP.setNode(uchallatiball);
        BallUP.setDuration(Duration.millis(1));
        BallGravity();
        rotateObstacles();
        //GamePlay_AnchorPane.getChildren().add(keyListener);
        System.out.println("Done Dona DOne");
    }

    public void BallGravity() {
        Bounds bounds = GamePlay_AnchorPane.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),
                new KeyValue(uchallatiball.layoutYProperty(), bounds.getMaxY()-uchallatiball.getRadius())));
        //uchallatiball.setLayoutY((600 - uchallatiball.getLayoutBounds().getMinY()));
                //new KeyValue(uchallatiball.layoutYProperty(), bounds.getMaxY()-uchallatiball.getRadius())));
        timeline.setCycleCount(Integer.MAX_VALUE);
        timeline.play();
    }

    public void rotateObstacles() {
        Obstacle1Animate = new RotateTransition();
        Obstacle1Animate.setAxis(Rotate.Z_AXIS);
        Obstacle1Animate.setByAngle(360);
        Obstacle1Animate.setCycleCount(Integer.MAX_VALUE);
        Obstacle1Animate.setDuration(Duration.millis(4000));
        Obstacle1Animate.setInterpolator(Interpolator.LINEAR);
        Obstacle1Animate.setNode(Obstacle1);

        Obstacle21Animate = new RotateTransition();
        Obstacle21Animate.setAxis(Rotate.Z_AXIS);
        Obstacle21Animate.setByAngle(360);
        Obstacle21Animate.setCycleCount(Integer.MAX_VALUE);
        Obstacle21Animate.setDuration(Duration.millis(4000));
        Obstacle21Animate.setInterpolator(Interpolator.LINEAR);
        Obstacle21Animate.setNode(Obstacle21);

        Obstacle22Animate = new RotateTransition();
        Obstacle22Animate.setAxis(Rotate.Z_AXIS);
        Obstacle22Animate.setByAngle(-360);
        Obstacle22Animate.setCycleCount(Integer.MAX_VALUE);
        Obstacle22Animate.setDuration(Duration.millis(4000));
        Obstacle22Animate.setInterpolator(Interpolator.LINEAR);
        Obstacle22Animate.setNode(Obstacle22);

        Obstacle3Animate = new RotateTransition();
        Obstacle3Animate.setAxis(Rotate.Z_AXIS);
        Obstacle3Animate.setByAngle(-360);
        Obstacle3Animate.setCycleCount(Integer.MAX_VALUE);
        Obstacle3Animate.setDuration(Duration.millis(4000));
        Obstacle3Animate.setInterpolator(Interpolator.LINEAR);
        Obstacle3Animate.setNode(Obstacle3);

        Obstacle1Animate.play();
        Obstacle21Animate.play();
        Obstacle22Animate.play();
        Obstacle3Animate.play();
    }
    public void ReleaseBall() {
        //Drop the ball

        BallUP.setToY(uchallatiball.getCenterY() + 5);
        uchallatiball.setCenterY(uchallatiball.getCenterY() + 5);
        BallUP.play();
        System.out.println("Dropped!");
    }

    //Buttons
    public void BackToMainMenuButton() throws IOException {
        System.out.println("Back To Main Menu Daba Dia Bhaiya!!");
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        GamePlay_AnchorPane.getChildren().setAll(root);
    }
    public void PauseButton() throws IOException {
        System.out.println("Pause Daba Dia Bhaiya!!");
        Parent root = FXMLLoader.load(getClass().getResource("PauseGameScreen.fxml"));
        GamePlay_AnchorPane.getChildren().setAll(root);
    }
}