package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class TheMainGame2 extends Application implements Colors {
    boolean hitSpace = false;
    boolean is_P_pressed = false;
    AnimationTimer timer;
    Ball ball;
    ArrayList<Star> allStars;
    ArrayList<ColorSwitcher> allColorSwitchers;
    ArrayList<Obstacle> allObstacles;
    Random random;
    Score score;
    Text GameOverText;
    boolean isGameOver = false;
    boolean secondTimePlayed = false;
    boolean started = false;


    @Override
    public void start(Stage primaryStage) throws Exception{

        Music2 music2 = new Music2();
        music2.mediaPlayer.play();

        Pane root = new Pane();
        primaryStage.setTitle("COLOR SWITCH v1.0");

        Scene scene = new Scene(root, 385, 640, Color.BLACK);

        ball = new Ball();


        allStars = new ArrayList<>(35);
        allColorSwitchers = new ArrayList<>(35);
        allObstacles = new ArrayList<>(36);
        random = new Random();
        for (int i=0; i<35; i++) {
            int randomNumber = random.nextInt(5);
            switch (randomNumber) {
                case 0 -> {
                    Obstacle2 o2 = new Obstacle2();
                    double l0 = o2.getObstacle().getLayoutY() - i * 500;
                    o2.getObstacle().setLayoutY(l0);

                    Star s1 = new Star();
                    s1.getStar_ImageView().relocate(181.5, l0+80);
                    root.getChildren().add(s1.getStar_ImageView());
                    allStars.add(s1);

                    ColorSwitcher c0 = new ColorSwitcher();
                    c0.getColorSwitcher_ImageView().relocate(181.5, l0-50);
                    root.getChildren().add(c0.getColorSwitcher_ImageView());
                    allColorSwitchers.add(c0);

                    root.getChildren().add(o2.getObstacle());
                    allObstacles.add(o2);
                }
                case 1 -> {
                    Obstacle1 o1 = new Obstacle1();
                    double location = o1.getObstacle().getLayoutY() - i * 500;
                    o1.getObstacle().setLayoutY(location);

                    Star s2 = new Star();
                    s2.getStar_ImageView().relocate(180.5, location+225);
                    root.getChildren().add(s2.getStar_ImageView());
                    allStars.add(s2);

                    ColorSwitcher c1 = new ColorSwitcher();
                    c1.getColorSwitcher_ImageView().relocate(181.5, location+100);
                    root.getChildren().add(c1.getColorSwitcher_ImageView());
                    allColorSwitchers.add(c1);

                    root.getChildren().add(o1.getObstacle());
                    allObstacles.add(o1);
                }
                case 2 -> {
                    Obstacle3 o3 = new Obstacle3();
                    double l2 = o3.getObstacle().getLayoutY() - i * 500;
                    o3.getObstacle().setLayoutY(l2);

                    Star s3 = new Star();
                    s3.getStar_ImageView().relocate(180.5, l2+250);
                    root.getChildren().add(s3.getStar_ImageView());
                    allStars.add(s3);

                    ColorSwitcher c2 = new ColorSwitcher();
                    c2.getColorSwitcher_ImageView().relocate(181.5, l2+50);
                    root.getChildren().add(c2.getColorSwitcher_ImageView());
                    allColorSwitchers.add(c2);

                    root.getChildren().add(o3.getObstacle());
                    allObstacles.add(o3);
                }
                case 3 -> {
                    Obstacle4 o4 = new Obstacle4();
                    double l3 = o4.getObstacle().getLayoutY() - i * 500;
                    o4.getObstacle().setLayoutY(l3);

                    Star s4 = new Star();
                    s4.getStar_ImageView().relocate(180.5, l3+270);
                    root.getChildren().add(s4.getStar_ImageView());
                    allStars.add(s4);

                    ColorSwitcher c3 = new ColorSwitcher();
                    c3.getColorSwitcher_ImageView().relocate(181.5, l3+50);
                    root.getChildren().add(c3.getColorSwitcher_ImageView());
                    allColorSwitchers.add(c3);

                    root.getChildren().add(o4.getObstacle());
                    allObstacles.add(o4);
                }
                case 4 -> {
                    Obstacle5 o5 = new Obstacle5();
                    double l4 = o5.getObstacle().getLayoutY() - i * 500;
                    o5.getObstacle().setLayoutY(l4);

                    Star s5 = new Star();
                    s5.getStar_ImageView().relocate(180.5, l4+225);
                    root.getChildren().add(s5.getStar_ImageView());
                    allStars.add(s5);

                    ColorSwitcher c4 = new ColorSwitcher();
                    c4.getColorSwitcher_ImageView().relocate(181.5, l4+50);
                    root.getChildren().add(c4.getColorSwitcher_ImageView());
                    allColorSwitchers.add(c4);

                    root.getChildren().add(o5.getObstacle());
                    allObstacles.add(o5);
                }
            }
            Obstacle5 dummyObstacle = new Obstacle5();
            dummyObstacle.getObstacle().setLayoutY(900);
            root.getChildren().add(dummyObstacle.getObstacle());
            allObstacles.add(dummyObstacle);
        }


        //Score score = new Score();
        //root.getChildren().add(score.getScore_Label());

        score = new Score();

        //MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("src/BG_Music").toURI().toString()));
        //mediaPlayer.setAutoPlay(true);

        root.getChildren().add(score.getScore_Label());
        root.getChildren().add(ball.getBall());

        primaryStage.setScene(scene);
        primaryStage.show();


        Text PauseText = new Text("Paused! Press P to Resume");
        PauseText.relocate(37, 300);
        PauseText.setFill(Color.BLACK);
        PauseText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {


                if (keyEvent.getCode() == KeyCode.SPACE) {
                    if (!started){
                        started = true;
                        timer.start();
                    }
                    hitSpace = true;
                }
                if (keyEvent.getCode() == KeyCode.P && !isGameOver) {
                    is_P_pressed = !is_P_pressed;
                    if (is_P_pressed) {
                        root.getChildren().add(PauseText);
                        timer.stop();
                    }
                    else {
                        root.getChildren().remove(PauseText);
                        timer.start();
                    }
                    //Naya Page Kholna h
                }

                if (keyEvent.getCode() == KeyCode.C) {
                    if (score.getScore() >= 10 && !secondTimePlayed) {
                        secondTimePlayed = true;
                        ball.getBall().setLayoutY(ball.getBall().getLayoutY() + 50);
                        root.getChildren().remove(GameOverText);
                        timer.start();
                    }
                }

                if (keyEvent.getCode() == KeyCode.E) {
                    music2.mediaPlayer.stop();
                    primaryStage.close();
                }

            }
        });

        timer = new AnimationTimer() {
            double myTime = 0.0;
            double velocityY = 0;
            double gravity = 15.8;
            double previousVelocity = 0;
            int counter = 0;

            @Override
            public void handle(long l) {

                counter ++;
                double currY = ball.getBall().getLayoutY();
                velocityY += gravity*0.5*Math.pow(myTime, 2);
                double deltaY = velocityY;
                double newY = currY + 1.5*deltaY;
                if (hitSpace == true) {
                    velocityY = -3.5;
                    myTime = .13;
                    hitSpace = false;
                    //System.out.println(colorSwitcher.checkIfCollide(ball) + " ");
                }

                Bounds bounds=ball.getBall().localToScreen(ball.getBall().getBoundsInLocal());
                ball.getBall().setLayoutY(newY);

                if (bounds.getCenterY() <= 600)
                {

                    for (Obstacle obj: allObstacles) {
                        obj.getObstacle().setTranslateY(obj.getObstacle().getTranslateY() + 1.2);
                    }
                    for (Star obj: allStars) {
                        obj.getStar_ImageView().setTranslateY(obj.getStar_ImageView().getTranslateY() + 1.2);
                    }
                    for (ColorSwitcher obj: allColorSwitchers) {
                        obj.getColorSwitcher_ImageView().setTranslateY(obj.getColorSwitcher_ImageView().getTranslateY() + 1.2);
                    }
                }
                if (allStars.get(0).checkIfCollide(ball)) {
                    root.getChildren().remove(allStars.get(0).getStar_ImageView());
                    allStars.remove(0);
                    score.updateScore();
                }
                if (allColorSwitchers.get(0).checkIfCollide(ball)) {
                    allColorSwitchers.get(0).changeBallColor(ball);
                    root.getChildren().remove(allColorSwitchers.get(0).getColorSwitcher_ImageView());
                    allColorSwitchers.remove(0);
                }
                for (Obstacle obj: allObstacles) {
                    if (obj.checkIfCollide(ball)) {
                        System.out.println("Chipak Gya Bhaiya!");
                        //isGameOver = true;
                        if (score.getScore() >= 10 && !secondTimePlayed) {
                            GameOverText = new Text("GameOver! Press C to continue");
                            GameOverText.relocate(10, 300);
                            GameOverText.setFill(Color.BLACK);
                            GameOverText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                            root.getChildren().add(GameOverText);
                            isGameOver = true;
                            timer.stop();
                        }
                        else {
                            GameOverText = new Text("GameOver! Press E to Exit");
                            GameOverText.relocate(10, 300);
                            GameOverText.setFill(Color.BLACK);
                            GameOverText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                            root.getChildren().add(GameOverText);
                            isGameOver = true;
                            timer.stop();
                        }
                    }
                }


                previousVelocity = velocityY;
                myTime += .001;
            }
        };


    }

    public static void main(String[] args) {
        launch(args);
    }
}


































class Ball {
    Circle ball;
    private final double BallX = 182.5;
    private Color CurrentBallColor;

    public Ball() {
        ball = new Circle(10);
        ball.setFill(Color.RED);
        ball.relocate(BallX, 600);
    }

    public Circle getBall() {
        return ball;
    }

    public void setCurrentBallColor(Color currentBallColor) {
        CurrentBallColor = currentBallColor;
        ball.setFill(currentBallColor);
    }

    public Color getCurrentYpos() {
        return CurrentBallColor;
    }
}



abstract class Obstacle {
    Group group;
    RotateTransition rotateTransition;

    public Group getObstacle() {
        return group;
    }

    public boolean checkIfCollide(Ball ball) {
        for (Node nodes_shapes: group.getChildren())
        {
            Shape arcs=(Shape) nodes_shapes;
            Shape intersect=Shape.intersect(arcs, ball.getBall());
            // && arcs.getFill().equals(ball.getFill())
            if (intersect.getBoundsInLocal().getWidth() !=-1 && !arcs.getFill().equals(ball.getBall().getFill())) {
                return true;
            }
        }
        return false;
    }


}
class Obstacle3 extends Obstacle {
    Rectangle rect1;
    Rectangle rect2;
    Rectangle rect3;
    Rectangle rect4;

    Obstacle3() {

        rect1 = new Rectangle();
        rect1.setWidth(10);
        rect1.setHeight(150);
        rect1.setFill(Color.RED);

        rect2 = new Rectangle();
        rect2.setWidth(10);
        rect2.setHeight(150);
        rect2.setFill(Color.YELLOW);
        rect2.setRotate(90);

        rect3 = new Rectangle();
        rect3.setWidth(10);
        rect3.setHeight(150);
        rect3.setFill(Color.BLUE);
        rect3.setRotate(180);

        rect4 = new Rectangle();
        rect4.setWidth(10);
        rect4.setHeight(150);
        rect4.setFill(Color.GREEN);
        rect4.setRotate(270);


        rect1.relocate(125, 200);
        rect2.relocate(200, 275);
        rect3.relocate(275, 200);
        rect4.relocate(200, 125);


        group = new Group(rect1, rect2, rect3, rect4);

        rotateTransition = new RotateTransition();
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setNode(group);
        rotateTransition.setByAngle(-360);
        rotateTransition.setCycleCount(Integer.MAX_VALUE);
        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setInterpolator(Interpolator.LINEAR);

        rotateTransition.play();
    }


}

class Obstacle4 extends Obstacle {

    Obstacle4() {

        Arc arc1=new Arc(192.5, 300, 100, 100, 0, 90);
        arc1.setFill(Color.RED);
        arc1.setType(ArcType.OPEN);

        Arc arc2=new Arc(192.5, 300, 100, 100, 90, 90);
        arc2.setFill(Color.YELLOW);
        arc2.setType(ArcType.OPEN);

        Arc arc3=new Arc(192.5, 300, 100, 100, 180, 90);
        arc3.setFill(Color.GREEN);
        arc3.setType(ArcType.OPEN);

        Arc arc4=new Arc(192.5, 300, 100, 100, 270, 90);
        arc4.setFill(Color.BLUE);
        arc4.setType(ArcType.OPEN);

        group=new Group(arc1, arc2, arc3, arc4);

        rotateTransition = new RotateTransition();
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setNode(group);
        rotateTransition.setByAngle(-360);
        rotateTransition.setCycleCount(Integer.MAX_VALUE);
        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setInterpolator(Interpolator.LINEAR);

        rotateTransition.play();
    }

}

class Obstacle2 extends Obstacle {
    Group group2;
    Group group1;
    RotateTransition rotateTransition2;

    Obstacle2() {

        Arc arc1=new Arc(192.5, 300, 100, 100, 0, 90);
        arc1.setFill(Color.RED);
        arc1.setType(ArcType.OPEN);

        Arc arc2=new Arc(192.5, 300, 100, 100, 90, 90);
        arc2.setFill(Color.YELLOW);
        arc2.setType(ArcType.OPEN);

        Arc arc3=new Arc(192.5, 300, 100, 100, 180, 90);
        arc3.setFill(Color.GREEN);
        arc3.setType(ArcType.OPEN);

        Arc arc4=new Arc(192.5, 300, 100, 100, 270, 90);
        arc4.setFill(Color.BLUE);
        arc4.setType(ArcType.OPEN);

        group1=new Group(arc1, arc2, arc3, arc4);

        rotateTransition = new RotateTransition();
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setNode(group1);
        rotateTransition.setByAngle(-360);
        rotateTransition.setCycleCount(Integer.MAX_VALUE);
        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setInterpolator(Interpolator.LINEAR);

        rotateTransition.play();

        //2nd
        int tmep = -90;
        Arc arc21=new Arc(192.5, 300, 100, 100, 0+tmep, 90);
        arc21.setFill(Color.RED);
        arc21.setType(ArcType.OPEN);

        Arc arc22=new Arc(192.5, 300, 100, 100, 90+tmep, 90);
        arc22.setFill(Color.BLUE);
        arc22.setType(ArcType.OPEN);

        Arc arc23=new Arc(192.5, 300, 100, 100, 180+tmep, 90);
        arc23.setFill(Color.GREEN);
        arc23.setType(ArcType.OPEN);

        Arc arc24=new Arc(192.5, 300, 100, 100, 270+tmep, 90);
        arc24.setFill(Color.YELLOW);
        arc24.setType(ArcType.OPEN);

        group2=new Group(arc21, arc22, arc23, arc24);
        group2.setLayoutY(group2.getLayoutY() - 200);

        rotateTransition2 = new RotateTransition();
        rotateTransition2.setAxis(Rotate.Z_AXIS);
        rotateTransition2.setNode(group2);
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(Integer.MAX_VALUE);
        rotateTransition2.setDuration(Duration.millis(3000));
        rotateTransition2.setInterpolator(Interpolator.LINEAR);

        rotateTransition2.play();

        group = new Group(group1, group2);
    }

    @Override
    public boolean checkIfCollide(Ball ball) {

        boolean a=false, b=false;
        for(Node nodes_shapes: group1.getChildren()) {
            Shape arcs=(Shape) nodes_shapes;
            Shape intersect=Shape.intersect(arcs, ball.getBall());
            // && arcs.getFill().equals(ball.getFill())
            if (intersect.getBoundsInLocal().getWidth() !=-1 && !arcs.getFill().equals(ball.getBall().getFill())) {
                a =true;
                break;
            }
            else {
                a = false;
            }
        }

        for(Node nodes_shapes: group2.getChildren()) {
            Shape arcs=(Shape) nodes_shapes;
            Shape intersect=Shape.intersect(arcs, ball.getBall());
            // && arcs.getFill().equals(ball.getFill())
            if (intersect.getBoundsInLocal().getWidth() !=-1 && !arcs.getFill().equals(ball.getBall().getFill())) {
                b = true;
                break;
            }
            else {
                b = false;
            }
        }
        return (a||b);
    }

}

class Obstacle1 extends Obstacle {

    Obstacle1() {
        Rectangle rect1;
        Rectangle rect2;
        Rectangle rect3;
        Rectangle rect4;

        rect1 = new Rectangle();
        rect1.setWidth(15);
        rect1.setHeight(100);
        rect1.setFill(Color.RED);

        rect2 = new Rectangle();
        rect2.setWidth(15);
        rect2.setHeight(100);
        rect2.setFill(Color.YELLOW);
        rect2.setRotate(90);

        rect3 = new Rectangle();
        rect3.setWidth(15);
        rect3.setHeight(100);
        rect3.setFill(Color.BLUE);
        rect3.setRotate(180);

        rect4 = new Rectangle();
        rect4.setWidth(15);
        rect4.setHeight(100);
        rect4.setFill(Color.GREEN);
        rect4.setRotate(270);

        rect1.relocate(150, 250);
        rect2.relocate(200, 300);
        rect3.relocate(150, 350);
        rect4.relocate(100, 300);

        group = new Group(rect1, rect2, rect3, rect4);
        group.setLayoutY(group.getLayoutY() - 150);
        rotateTransition = new RotateTransition();
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setNode(group);
        rotateTransition.setByAngle(-360);
        rotateTransition.setCycleCount(Integer.MAX_VALUE);
        rotateTransition.setDuration(Duration.millis(3000));
        rotateTransition.setInterpolator(Interpolator.LINEAR);

        rotateTransition.play();
    }
}
class Obstacle5 extends Obstacle {
    Group root2;
    Group root1;
    Obstacle5(){

        Arc arc1=new Arc(192.5-100, 300, 100, 100, 0, 90);
        arc1.setFill(Color.RED);
        arc1.setType(ArcType.OPEN);

        Arc arc2=new Arc(192.5-100, 300, 100, 100, 90, 90);
        arc2.setFill(Color.GREEN);
        arc2.setType(ArcType.OPEN);

        Arc arc3=new Arc(192.5-100, 300, 100, 100, 180, 90);
        arc3.setFill(Color.BLUE);
        arc3.setType(ArcType.OPEN);

        Arc arc4=new Arc(192.5-100, 300, 100, 100, 270, 90);
        arc4.setFill(Color.YELLOW);
        arc4.setType(ArcType.OPEN);

        Arc arc5 = new Arc(192.5+100,300,100 , 100 , 0-90 , 90 );
        arc5.setFill(Color.BLUE);
        arc5.setType(ArcType.OPEN);

        Arc arc6 = new Arc(192.5+100,300,100 , 100 , 90-90 , 90 );
        arc6.setFill(Color.GREEN);
        arc6.setType(ArcType.OPEN);

        Arc arc7 = new Arc(192.5+100,300,100 , 100 , 180-90 , 90 );
        arc7.setFill(Color.RED);
        arc7.setType(ArcType.OPEN);

        Arc arc8 = new Arc(192.5+100,300,100 , 100 , 270-90 , 90 );
        arc8.setFill(Color.YELLOW);
        arc8.setType(ArcType.OPEN);

        root1=new Group(arc1, arc2, arc3, arc4);
        root2 = new Group(arc5,arc6,arc7,arc8);

        RotateTransition rotate=new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setDuration(Duration.seconds(10));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(root1);
        rotate.play();

        RotateTransition rotate2=new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(-360);
        rotate2.setCycleCount(Animation.INDEFINITE);
        rotate2.setDuration(Duration.seconds(10));
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setNode(root2);
        rotate2.play();

        group = new Group(root1,root2);
    }

    @Override
    public boolean checkIfCollide(Ball ball) {
        for(Node nodes_shapes: root2.getChildren()) {
            Shape arcs=(Shape) nodes_shapes;
            Shape intersect=Shape.intersect(arcs, ball.getBall());
            // && arcs.getFill().equals(ball.getFill())
            if (intersect.getBoundsInLocal().getWidth() !=-1 && !arcs.getFill().equals(ball.getBall().getFill())) {
                return true;
            }
        }
        return false;
    }
}

class Star {
    ImageView Star_ImageView;
    //private int Star_YPos;

    public Star() {
        File file = new File("src/sample/star.png");
        Image image = new Image(file.toURI().toString());
        Star_ImageView = new ImageView(image);
        Star_ImageView.setFitHeight(30);
        Star_ImageView.setFitWidth(30);
        Star_ImageView.setLayoutX(180.5);
        Star_ImageView.setLayoutY(300);
        //this.Star_YPos = Ypos;
        //Star_ImageView.setLayoutY(Ypos);
    }

    public boolean checkIfCollide(Ball ball) {
        Bounds Ball_bound = ball.getBall().localToScene(ball.getBall().getBoundsInLocal());
        Bounds Star_bound = Star_ImageView.localToScene(Star_ImageView.getBoundsInLocal());

        return Ball_bound.intersects(Star_bound);
    }

    public ImageView getStar_ImageView() {
        return Star_ImageView;
    }
}

class ColorSwitcher {
    private ImageView ColorSwitcher_ImageView;
    private Random random;

    public ColorSwitcher() {
        File file = new File("src/sample/color_switcher.png");
        Image image = new Image(file.toURI().toString());
        ColorSwitcher_ImageView = new ImageView(image);
        ColorSwitcher_ImageView.setFitHeight(30);
        ColorSwitcher_ImageView.setFitWidth(30);
        ColorSwitcher_ImageView.setLayoutX(180.5);
        ColorSwitcher_ImageView.setLayoutY(200);
        random = new Random();
    }

    public void changeBallColor(Ball ball) {
        int randomNum = random.nextInt(4);
        switch (randomNum) {
            case 0:
                ball.setCurrentBallColor(Color.RED);
                break;
            case 1:
                ball.setCurrentBallColor(Color.GREEN);
                break;
            case 2:
                ball.setCurrentBallColor(Color.YELLOW);
                break;
            case 3:
                ball.setCurrentBallColor(Color.BLUE);
                break;
        }
    }

    public boolean checkIfCollide(Ball ball) {
        Bounds Ball_bound = ball.getBall().localToScene(ball.getBall().getBoundsInLocal());
        Bounds ColorSwitcher_bound = ColorSwitcher_ImageView.localToScene(ColorSwitcher_ImageView.getBoundsInLocal());

        return Ball_bound.intersects(ColorSwitcher_bound);
    }

    public ImageView getColorSwitcher_ImageView() {
        return ColorSwitcher_ImageView;
    }
}

class Score {
    private Text Score_Label;
    private int score;

    public Score() {
        this.score = 0;
        Score_Label = new Text();
        Score_Label.setText(score + "");
        Score_Label.setY(20);
        Score_Label.setX(5);
        Score_Label.setFill(Color.BLACK);
        Score_Label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    }

    public void updateScore() {
        this.score++;
        Score_Label.setText(score + "");
    }

    public int getScore() {
        return score;
    }

    public Text getScore_Label() {
        return Score_Label;
    }
}




class Music2 {

    MediaPlayer mediaPlayer;

    Music2() {
        String s = "src/BG_Music.mp3";
        Media h = new Media(new File(s).toURI().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }
}
