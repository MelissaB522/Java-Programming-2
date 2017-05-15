package control.a.clock.exercise.pkg15.pkg32;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;


/**
 * Class:       ControlAClockExercise1532
 * Developer:   Melissa Bakke
 * Date:        02/09/2017
 * Purpose:     Clock animation with functioning start and stop buttons
 */
public class ControlAClockExercise1532 extends Application {
    @Override
    public void start (Stage primaryStage) {
        // Create a clock and a label
        ClockPane clock = new ClockPane();
        String timeString = clock.getHour() + ":" + clock.getMinute()
                + ":" + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);
        
        // Place clock and label in border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
        
        // Create start and stop buttons
        HBox paneForButtons = new HBox(20);
        Button btStop = new Button("Stop");
        Button btStart = new Button("Start");
        paneForButtons.getChildren().addAll(btStop, btStart);
        paneForButtons.setAlignment(Pos.CENTER);
        pane.setBottom(paneForButtons);
        
        // Create a timeline and set duration and cycle count
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> initalStart(clock)));
        animation.setCycleCount(Timeline.INDEFINITE);
        
        // Clicking on buttons calls appropriate method and passes animation to them
        btStop.setOnAction(e -> clockStop(animation));
        btStart.setOnAction(e -> clockStart(clock, animation));
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
    // Stops the clock
    public void clockStop(Timeline animation){
        animation.stop();
    }
    
    // Starts the clock initally
    public void initalStart(ClockPane clock){
        clock.setCurrentTime();
    }
    
    // Starts the clock after being stopped
    public void clockStart(ClockPane clock, Timeline animation){
        animation.play();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }    
}
