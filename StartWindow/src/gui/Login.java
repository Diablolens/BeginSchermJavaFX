package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import StartUp.StartUp;
import javafx.scene.layout.GridPane;

public class Login extends GridPane {
    
     
    
    private static String loggedInUser;
     
      
      
      public static void showLoginScreen() {
        Stage stage = new Stage();
 
        VBox box = new VBox();
        box.setPadding(new Insets(10));
 
        // How to center align content in a layout manager in JavaFX
        box.setAlignment(Pos.CENTER);
 
        Label label = new Label("geef naam en wachtwoord");
 
        TextField textUser = new TextField();
        textUser.setPromptText("Vul naam in");
        TextField textPass = new TextField();
        textPass.setPromptText("Geef het wachtwoord");
 
        Button btnLogin = new Button();
        btnLogin.setText("inloggen");
        
       btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public  void handle(ActionEvent event) {
                // Assume success always!
                setLoggedInUser(textUser.getText());
                stage.close(); // return to main window
            }
        });
        
        box.getChildren().add(label);
        box.getChildren().add(textUser);
        box.getChildren().add(textPass);
        box.getChildren().add(btnLogin);
        
         btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showLoginScreen();
            }
        });
         
      
         
        Scene scene = new Scene(box, 250, 150);
        stage.setScene(scene);
        stage.show();
    }
      
      public static void setLoggedInUser(String user) {
         loggedInUser = user;
 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Met succes ingeloged");
        alert.setHeaderText("Met succes ingeloged");
        String s = user + " logged in!";
        alert.setContentText(s);
        alert.show();
        
    }
}


