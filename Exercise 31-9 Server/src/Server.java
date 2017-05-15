import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class:       Chat Server
 * Developer:   Melissa Bakke
 * Date:        04/18/2017
 * Purpose:     Program  that  enables  two  users  to  chat.   
 */

public class Server extends Application {
    // IO streams
    DataOutputStream toClient = null;
    DataInputStream fromClient = null;

    @Override
    public void start(Stage primaryStage) {
        //Text area for displaying contents
        TextArea clientTA = new TextArea();
        TextArea serverTA = new TextArea();
        clientTA.setEditable(false);
        
        VBox vBox = new VBox(10);
        Label lblClient = new Label("Client");
        Label lblServer = new Label("Server");
        vBox.getChildren().addAll(lblClient, clientTA, lblServer, serverTA);
        vBox.setPadding(new Insets(10));
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 450, 450);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);        
        primaryStage.show();
        
        // Gives the text area focus when the application starts
        serverTA.requestFocus();
        
        // Send text back to the client
        serverTA.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                try {
                    String[] sa = serverTA.getText().split("\n");
                    toClient.writeUTF(sa[sa.length - 1]);
                    toClient.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });  
        
        new Thread(() -> {
            try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                
                // Listen for a connection request
                Socket socket = serverSocket.accept();
                
                // Create data input and output streams
                fromClient = new DataInputStream(socket.getInputStream());
                toClient = new DataOutputStream(socket.getOutputStream());
                
                while (true) {
                    // Receive text from the client
                    String message = fromClient.readUTF();
                    
                    // Display message in text area
                    clientTA.appendText(message + "\n");
                    toClient.flush();
                }
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
