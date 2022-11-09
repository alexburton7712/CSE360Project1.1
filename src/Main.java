
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
//Alex was here too
public class Main extends Application
{
    @Override
    public void start(Stage stage) {   
         
    	CustomerGUI gui = new CustomerGUI();
    	
    	StackPane rootPane = new StackPane();
        rootPane.getChildren().add(gui);
        
        //Creating a scene object 
        Scene scene = new Scene(rootPane, 630, 540);  
        
        //Setting title to the Stage 
        stage.setTitle("Pizza GUI"); 
           
        //Adding scene to the stage 
        stage.setScene(scene); 
           
        //Displaying the contents of the stage 
        stage.show(); 
     }//end start

    public static void main(String[] args)
    {
        launch(args);
    }//end main
}
