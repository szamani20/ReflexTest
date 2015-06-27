package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    static Rectangle rectangle1;
    static Rectangle rectangle2;
    static Rectangle rectangle3;
    static Random random;
    static int enemyCase;
    static int score = 0;
    static int screenWidth;
    static int screenHeight;
    static Label scoreLabel;
    static Label speedLabel;
    static long currentTime;
    static int gameDifficulty = 1500;

    public static void main(String[] args) {
        currentTime = System.currentTimeMillis();
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();

        screenWidth = (int) stage.getWidth() - 50;
        screenHeight = (int) stage.getHeight() - 50;

        scene.setCursor(Cursor.NONE);

        random = new Random(System.currentTimeMillis());
        scoreLabel = new Label(String.valueOf(score));
        scoreLabel.setLayoutX(screenWidth / 2);
        scoreLabel.setLayoutY(0);

        speedLabel = new Label(String.valueOf((score * 1000) / (System.currentTimeMillis() - currentTime)));
        speedLabel.setLayoutX(screenWidth / 2 + 50);
        speedLabel.setLayoutY(0);

        rectangle1 = new Rectangle(100, 100);
        rectangle2 = new Rectangle(100, 100);
        rectangle3= new Rectangle(100, 100);

        rectangle1.setFill(Color.RED);
        rectangle2.setFill(Color.GREEN);
        rectangle3.setFill(Color.BLUE);

        rectangle1.setX(-200);
        rectangle2.setX(-200);
        rectangle3.setX(-200);

        Image image = new Image("/pointer.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(stage.getWidth() / 2);
        imageView.setY(stage.getHeight() / 2);

        group.getChildren().addAll(imageView, rectangle1, rectangle2, rectangle3, scoreLabel, speedLabel);

        stage.setOnCloseRequest(e -> System.exit(0));

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> addEnemy());
            }
        }, 10, gameDifficulty);
        
        scene.setOnMouseMoved(e -> {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        imageView.setX(e.getX() - 10);
                        imageView.setY(e.getY() - 10);
                    });
                }
            };

            thread.start();
        });

        scene.setOnMousePressed(e -> {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        System.out.println(e.getX() + "   " + e.getY());
                        Toolkit.getDefaultToolkit().beep();

                        ////////// this switch case can be more efficient and cleaner ///////////////////
                        switch (enemyCase) {
                            case 0:
                                if (e.getX() >= rectangle1.getX() && e.getX() <= rectangle1.getX() + rectangle1.getWidth()&& e.getY() >= rectangle1.getY()&& e.getY() <= rectangle1.getY() + rectangle1.getHeight()) {
                                    rectangle1.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                } else {
                                    scene.setFill(Color.YELLOW);
                                    --score;
                                }
                                scoreLabel.setText(String.valueOf(score));
                                speedLabel.setText(String.valueOf((double) (score * 1000) / (System.currentTimeMillis() - currentTime)));
                                break;
                            case 1:
                                if (e.getX() >= rectangle2.getX() && e.getX() <= rectangle2.getX() + rectangle2.getWidth()&& e.getY() >= rectangle2.getY()&& e.getY() <= rectangle2.getY() + rectangle2.getHeight()) {
                                    rectangle2.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                } else {
                                    scene.setFill(Color.YELLOW);
                                    --score;
                                }
                                scoreLabel.setText(String.valueOf(score));
                                speedLabel.setText(String.valueOf((double) ((score * 1000) / (System.currentTimeMillis() - currentTime))));
                                break;
                            case 2:
                                if (e.getX() >= rectangle3.getX() && e.getX() <= rectangle3.getX() + rectangle3.getWidth()&& e.getY() >= rectangle3.getY()&& e.getY() <= rectangle3.getY() + rectangle3.getHeight()) {
                                    rectangle3.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                } else {
                                    scene.setFill(Color.YELLOW);
                                    --score;
                                }
                                scoreLabel.setText(String.valueOf(score));
                                speedLabel.setText(String.valueOf((double) (score * 1000) / (System.currentTimeMillis() - currentTime)));
                                break;
                            case 3:
                                if (e.getX() >= rectangle1.getX() && e.getX() <= rectangle1.getX() + rectangle1.getWidth()&& e.getY() >= rectangle1.getY()&& e.getY() <= rectangle1.getY() + rectangle1.getHeight()) {
                                    rectangle1.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                } else if (e.getX() >= rectangle2.getX() && e.getX() <= rectangle2.getX() + rectangle2.getWidth()&& e.getY() >= rectangle2.getY()&& e.getY() <= rectangle2.getY() + rectangle2.getHeight()) {
                                    rectangle2.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                } else {
                                    scene.setFill(Color.YELLOW);
                                    --score;
                                }
                                scoreLabel.setText(String.valueOf(score));
                                speedLabel.setText(String.valueOf((double) (score * 1000) / (System.currentTimeMillis() - currentTime)));
                                break;
                            case 4:
                                if (e.getX() >= rectangle1.getX() && e.getX() <= rectangle1.getX() + rectangle1.getWidth()&& e.getY() >= rectangle1.getY()&& e.getY() <= rectangle1.getY() + rectangle1.getHeight()) {
                                    rectangle1.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                } else if (e.getX() >= rectangle3.getX() && e.getX() <= rectangle3.getX() + rectangle3.getWidth()&& e.getY() >= rectangle3.getY()&& e.getY() <= rectangle3.getY() + rectangle3.getHeight()) {
                                    rectangle3.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                } else {
                                    scene.setFill(Color.YELLOW);
                                    --score;
                                }
                                scoreLabel.setText(String.valueOf(score));
                                speedLabel.setText(String.valueOf((double) (score * 1000) / (System.currentTimeMillis() - currentTime)));
                                break;
                            case 5:
                                if (e.getX() >= rectangle2.getX() && e.getX() <= rectangle2.getX() + rectangle2.getWidth()&& e.getY() >= rectangle2.getY()&& e.getY() <= rectangle2.getY() + rectangle2.getHeight()) {
                                    rectangle2.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                }
                                else if (e.getX() >= rectangle3.getX() && e.getX() <= rectangle3.getX() + rectangle3.getWidth()&& e.getY() >= rectangle3.getY()&& e.getY() <= rectangle3.getY() + rectangle3.getHeight()) {
                                    rectangle3.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                } else {
                                    scene.setFill(Color.YELLOW);
                                    --score;
                                }
                                scoreLabel.setText(String.valueOf(score));
                                speedLabel.setText(String.valueOf((double) (score * 1000) / (System.currentTimeMillis() - currentTime)));
                                break;
                            case 6:
                                if (e.getX() >= rectangle1.getX() && e.getX() <= rectangle1.getX() + rectangle1.getWidth()&& e.getY() >= rectangle1.getY()&& e.getY() <= rectangle1.getY() + rectangle1.getHeight()) {
                                    rectangle1.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                }
                                else if (e.getX() >= rectangle2.getX() && e.getX() <= rectangle2.getX() + rectangle2.getWidth()&& e.getY() >= rectangle2.getY()&& e.getY() <= rectangle2.getY() + rectangle2.getHeight()) {
                                    rectangle2.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                }
                                else if (e.getX() >= rectangle3.getX() && e.getX() <= rectangle3.getX() + rectangle3.getWidth()&& e.getY() >= rectangle3.getY()&& e.getY() <= rectangle3.getY() + rectangle3.getHeight()) {
                                    rectangle3.setX(-200);
                                    ++score;
                                    scene.setFill(Color.WHITE);
                                } else {
                                    scene.setFill(Color.YELLOW);
                                    --score;
                                }
                                scoreLabel.setText(String.valueOf(score));
                                speedLabel.setText(String.valueOf((double) (score * 1000) / (System.currentTimeMillis() - currentTime)));
                                break;
                        }

                        ///////////// when you are pressing mouse button setOnMouseMoved does not work //////////
                        scene.setOnMouseDragged(e -> {
                            imageView.setX(e.getX());
                            imageView.setY(e.getY());
                        });
                    });
                }
            };
            thread.start();
        });
    }

    private static void addEnemy() {
        enemyCase = Math.abs(random.nextInt()) % 7;

        int x1 = Math.abs(random.nextInt()) % screenWidth + 100;
        int x2 = Math.abs(random.nextInt()) % screenWidth + 100;
        int x3 = Math.abs(random.nextInt()) % screenWidth + 100;

        int y1 = Math.abs(random.nextInt()) % screenHeight + 100;
        int y2 = Math.abs(random.nextInt()) % screenHeight + 100;
        int y3 = Math.abs(random.nextInt()) % screenHeight + 100;

        ////////// this switch case can be more efficient and cleaner ///////////////////
        switch (enemyCase) {
            case 0:
                rectangle1.setX(x1);
                rectangle1.setY(y1);
                rectangle2.setX(-200);
                rectangle3.setX(-200);
                break;
            case 1:
                rectangle2.setX(x2);
                rectangle2.setY(y2);
                rectangle1.setX(-200);
                rectangle3.setX(-200);
                break;
            case 2:
                rectangle3.setX(x3);
                rectangle3.setY(y3);
                rectangle1.setX(-200);
                rectangle2.setX(-200);
                break;
            case 3:
                rectangle1.setX(x1);
                rectangle1.setY(y1);
                rectangle2.setX(x2);
                rectangle2.setY(y2);
                break;
            case 4:
                rectangle1.setX(x1);
                rectangle1.setY(y1);
                rectangle3.setX(x3);
                rectangle3.setY(y3);
                rectangle2.setX(-200);
                break;
            case 5:
                rectangle2.setX(x2);
                rectangle2.setY(y2);
                rectangle3.setX(x3);
                rectangle3.setY(y3);
                rectangle1.setX(-200);
                break;
            case 6:
                rectangle1.setX(x1);
                rectangle1.setY(y1);
                rectangle2.setX(x2);
                rectangle2.setY(y2);
                rectangle3.setX(x3);
                rectangle3.setY(y3);
                break;
        }
    }
}
