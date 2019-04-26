package StartUp;

import gui.ConfirmBox;
import javafx.application.Application; 
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.image.*;
import javafx.scene.layout.*; 
import javafx.stage.Stage;
import java.io.FileInputStream;
import gui.Login;
import gui.BeginScherm;
 
public class StartUp extends Application {
 
    
    Stage window;
    Button btnLogin = new Button();
    Button btnStartSpel = new Button("StartSpel");
    Button btnSluiten = new Button("Sluiten");
    
   
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        // A layout container for UI controls
        Pane root = new Pane();
        
        //stream lezen mogelijk om in te lezen en wegteschrijven
        Image img = new Image (new FileInputStream("C:\\test.png"));
        ImageView imgView = new ImageView(img);
        root.getChildren().add(imgView);
        
        root.getChildren().add(btnLogin);
        btnLogin.setLayoutX(200); // hoe meer naar rechts
        btnLogin.setLayoutY(255); // hoe hoger naar beneden
        btnLogin.setPrefHeight(20);
        btnLogin.setPrefWidth(100);
        btnLogin.setText("Login");
        
        root.getChildren().add(btnSluiten);
        btnSluiten.setLayoutX(200); // hoe meer naar rechts
        btnSluiten.setLayoutY(278); // hoe hoger naar beneden
        btnSluiten.setPrefHeight(20);
        btnSluiten.setPrefWidth(100);
        
        root.getChildren().add(btnStartSpel);
        btnStartSpel.setLayoutX(200); // hoe meer naar rechts
        btnStartSpel.setLayoutY(300); // hoe hoger naar beneden
        btnStartSpel.setPrefHeight(20);
        btnStartSpel.setPrefWidth(100);
        
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                Login.showLoginScreen();
               
            }
        });
        
         btnSluiten.setDefaultButton(true); 
        
         window.setOnCloseRequest(e-> {
          e.consume();
          closeProgram();
              });
        btnSluiten.setOnAction(e-> closeProgram()); 
        
       Scene scene = new Scene(root, 736, 344);
            // primaryStage is the main top level window created by platform
            primaryStage.setTitle("Login scherm");
            primaryStage.setScene(scene);
            primaryStage.show();
      
    }
    private void closeProgram(){
        Boolean aswer = ConfirmBox.display("Title","Zeker dat u wilt aflsuiten?");
        if (aswer) 
        {
            window.close();
        }
    }
 
   
 
    
    public static void main(String[] args) {
        launch(args);
    }
}