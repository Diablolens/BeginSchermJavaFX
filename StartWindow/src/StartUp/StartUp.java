import gui.ConfirmBox;
import javafx.application.Application; 
import static javafx.application.Application.launch;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.Label; 
import javafx.stage.Stage; 
public class StartUp extends Application { 
    Stage window;
  
    // launch the application 
    public void start(Stage primaryStage) 
    { 
         window = primaryStage;
        // set title for the stage 
        window.setTitle("Start scherm van regenwormen!");
  
        // create a button 
        Button b = new Button("StartSpel"); 
  
        // set cancel button 
        b.setCancelButton(true); 
   
        // create a button 
        Button b1 = new Button("Sluiten"); 
        
  
        // set default button 
        b1.setDefaultButton(true); 
  
        // create a stack pane 
        TilePane r = new TilePane(); 
  
        // create a label 
        Label l = new Label("button not selected");
        
        window.setOnCloseRequest(e-> {
          e.consume();
          closeProgram();
              });
  
        // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                l.setText("  StartSpel  button    selected    "); 
            } 
        }; 
       
        
        
  
        // when button is pressed 
        b.setOnAction(event); 
        b1.setOnAction(e-> closeProgram()); 
  
        // add button 
        r.getChildren().add(b); 
        r.getChildren().add(b1); 
        r.getChildren().add(l); 
  
        // create a scene 
        Scene sc = new Scene(r, 1080, 920); 
  
        // set the scene 
        window.setScene(sc); 
  
        window.show(); 
    } 
    
    private void closeProgram(){
        Boolean aswer = ConfirmBox.display("Title","Sure you want to exit");
        if (aswer) 
        {
            window.close();
        }
    }
  
    public static void main(String args[]) 
    { 
        // launch the application 
        launch(args); 
    } 
} 