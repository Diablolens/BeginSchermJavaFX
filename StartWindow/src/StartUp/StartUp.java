import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import gui.ConfirmBox;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
 
public class StartUp extends Application {
 
    private String loggedInUser;
    Stage window;
 
    public static void main(String[] args) {
        launch(args);
    }
 
    // JavaFX entry point
    // How to open a new window in JavaFX
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Button btnLogin = new Button();
        btnLogin.setLayoutX(50);
        btnLogin.setLayoutY(50);
        btnLogin.setText("Login");
        
        
     
        Button btnStartSpel = new Button("StartSpel");
        btnStartSpel.setLayoutX(50);
        btnStartSpel.setLayoutY(50);
        
        // create a button 
        Button btnSluiten = new Button("Sluiten");
        btnSluiten.setLayoutX(50);
        btnSluiten.setLayoutY(50);
        // set default button 
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
        
        // A layout container for UI controls
        StackPane root = new StackPane();
        root.getChildren().add(btnLogin); 
        root.getChildren().add(btnSluiten);
        root.getChildren().add(btnStartSpel);
       
        
        
 
        // Top level container for all view content
        Scene scene = new Scene(root, 300, 250);
        
 
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
}