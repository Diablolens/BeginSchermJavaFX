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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
 
public class StartUp extends Application {
 
    private String loggedInUser;
    Stage window;
    Button btnLogin = new Button();
    Button btnStartSpel = new Button("StartSpel");
    Button btnSluiten = new Button("Sluiten");
    
    @Override
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
        
        
         btnSluiten.setDefaultButton(true); 
        
         window.setOnCloseRequest(e-> {
          e.consume();
          closeProgram();
              });
        btnSluiten.setOnAction(e-> closeProgram()); 
        
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showLoginScreen();
            }
        });
        // Top level container for all view content
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
 
    public void setLoggedInUser(String user) {
        loggedInUser = user;
 
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Met succes ingeloged");
        alert.setHeaderText("Met succes ingeloged");
        String s = user + " logged in!";
        alert.setContentText(s);
        alert.show();
    }
 
    public void showLoginScreen() {
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
            public void handle(ActionEvent event) {
                // Assume success always!
                setLoggedInUser(textUser.getText());
                stage.close(); // return to main window
            }
        });
 
        box.getChildren().add(label);
        box.getChildren().add(textUser);
        box.getChildren().add(textPass);
        box.getChildren().add(btnLogin);
        
        Scene scene = new Scene(box, 250, 150);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}