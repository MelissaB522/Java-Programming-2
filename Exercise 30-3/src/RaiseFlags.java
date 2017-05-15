
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class:       RaiseFlags
 * Developer:   Melissa Bakke
 * Date:        04/04/2017
 * Purpose:     Rewrite  Listing  15.13  using  a  thread  to  animate  a  flag  
 * being raised. Compare the program with Listing 15.13 by setting the delay time
 * to 10 in both programs. Which one runs the animation faster?
 */
public class RaiseFlags extends Application{
    private double y = 300;
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane 
        Pane pane = new Pane();

        // Add an image view and add it to pane
        ImageView imageView = new ImageView("image/us.gif");
        pane.getChildren().add(imageView);

        new Thread(() -> {
            try {
                while (true) {                    
                    if (y > 0) {
                        imageView.setVisible(true);
                        imageView.setY(y -= 10);
                    }
                    
                    Platform.runLater(() -> {
                        imageView.setY(y);
                    });
                    Thread.sleep(200);
                } // End while loop
            } // End try
            catch (InterruptedException ex) {}
        } // End run method
        ).start();
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 300);
        primaryStage.setTitle("RaiseFlags"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
  
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
