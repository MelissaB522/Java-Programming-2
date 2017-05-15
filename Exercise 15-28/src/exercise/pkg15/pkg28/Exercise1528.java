/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise.pkg15.pkg28;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author mb0242181
 */
public class Exercise1528 extends Application {
    @Override
    public void start(Stage primaryStage){
        HBox hBox = new HBox();
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPause, btResume, btReverse);
        
        BorderPane pane = new BorderPane();
        pane.setBottom(hBox);
        
        FanPane fan = new FanPane();
        pane.setCenter(fan);
        
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), e -> fan.move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> fan.reverse());
        
        Scene scene = new Scene(pane, 200, 230);
        primaryStage.setTitle("Circle Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.widthProperty().addListener(e -> fan.setW(scene.getWidth()));
        scene.heightProperty().addListener(e -> fan.setH(scene.getHeight()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }    
}

class FanPane extends Pane {
    private double w = 200;
    private double h = 200;
    private double radius = Math.min(w, h) * 0.45;
    
    private Arc arc[] = new Arc[4];
    private double startAngle = 30;
    private Circle circle = new Circle(w/2, h/2, radius);
    
    public FanPane() {
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        getChildren().add(circle);
        
        for (int i = 0; i < 4; i++) {
            arc[i] = new Arc(w/2, h/2, radius * 0.9, radius * 0.9, startAngle + i*90, 35);
            arc[i].setFill(Color.RED);
            arc[i].setType(ArcType.ROUND);
            getChildren().addAll(arc[i]);
        }
    }
    
    private void setValues() {
        radius = Math.min(w, h) * 0.45;
        circle.setRadius(radius);
        circle.setCenterX(w/2);
        circle.setCenterY(h/2);
        
        for (int i = 0; i < 4; i++) {
            arc[i].setRadiusX(radius * 0.9);
            arc[i].setRadiusY(radius * 0.9);
            arc[i].setCenterX(w/2);
            arc[i].setCenterY(h/2);
            arc[i].setStartAngle(startAngle + i * 90);
        }
    }
    
    private double increment = 5;
    
    public void move() {
        setStartAngle(startAngle + increment);
    }
    
    public void reverse(){
        increment = -increment;
    }
    
    public void setStartAngle(double angle){
        this.startAngle = angle;
        setValues();
    }
    
    public void setW(double w) {
        this.w = w;
        setValues();
    }
    
    public void setH(double h) {
        this.h = h;
        setValues();
    }

    
}
