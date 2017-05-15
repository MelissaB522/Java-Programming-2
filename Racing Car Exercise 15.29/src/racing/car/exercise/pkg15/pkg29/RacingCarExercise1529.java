package racing.car.exercise.pkg15.pkg29;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Class:       RacingCarExercise1529
 * Developer:   Melissa Bakke
 * Date:        02/09/2017
 * Purpose:     Program that simulates a car racing
 */
public class RacingCarExercise1529 extends Application {
    @Override
    public void start (Stage primaryStage) {
        // Create a pane
        BorderPane pane = new BorderPane();
        pane.setBackground(Background.EMPTY);
        
        //Create car parts and add them to the pane
        Pane carPane = new Pane();
        Circle rearTire = new Circle(15, 100-5, 5, Color.GRAY);
        Circle frontTire = new Circle(35, 100-5, 5, Color.GRAY);
        Rectangle carRec = new Rectangle(0, 100-20, 50, 10);
        carRec.setFill(Color.LIMEGREEN);
        Polygon carTop = new Polygon(10, 100-20, 40, 100-20, 30, 100-30, 20, 100-30);
        carTop.setFill(Color.RED);
        carPane.getChildren().addAll(rearTire, frontTire, carRec, carTop);
        pane.setBottom(carPane);
        
        // Create pause/resume button
        HBox paneForButtons = new HBox(20);
        Button btPauseRes = new Button("Pause/Resume");
        paneForButtons.getChildren().addAll(btPauseRes);
        paneForButtons.setAlignment(Pos.TOP_CENTER);
        pane.setTop(paneForButtons);
        
        // Create a path transition
        PathTransition pt = new PathTransition(Duration.seconds(15), new Line(200, 25, 550, 25));
        pt.setNode(carPane);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.play();
        
        // Pause when button is pressed, resume when released
        btPauseRes.setOnMousePressed(e -> pt.pause());
        btPauseRes.setOnMouseReleased(e -> pt.play());
        
        // Up arrow makes car go faster, down arrow makes car go slower
        pane.setOnKeyPressed(e -> {
            pt.stop();
            switch  (e.getCode()) {
                case DOWN: pt.setDuration(pt.getDuration().add(Duration.seconds(2))); break;
                case UP: pt.setDuration(pt.getDuration().subtract(Duration.seconds(2))); break;
            }
            //System.out.println(pt.getDuration());
            pt.play();
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 100);
        primaryStage.setTitle("Racing Car");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
