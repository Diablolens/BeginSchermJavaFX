package gui;

import java.io.FileInputStream;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BeginScherm {
     Stage window;
     
    Button btnLogin = new Button();
    Button btnStartSpel = new Button("StartSpel");
    Button btnSluiten = new Button("Sluiten");
    
     public void BeginScherm(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        Pane root = new Pane();
        
        //stream lezen mogelijk om in te lezen en wegteschrijven
        Image img = new Image (new FileInputStream("C:\\test.png"));
        ImageView imgView = new ImageView(img);
        root.getChildren().add(imgView);
        
     
        
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
        
       
        
         btnSluiten.setDefaultButton(true); 
        
         window.setOnCloseRequest(e-> {
          e.consume();
          closeProgram();
              });
        btnSluiten.setOnAction(e-> closeProgram()); 
        
        
}
      private void closeProgram(){
        Boolean aswer = ConfirmBox.display("Title","Zeker dat u wilt aflsuiten?");
        if (aswer) 
        {
            window.close();
        }
    }
}
