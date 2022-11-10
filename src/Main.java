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
import javafx.scene.control.Button;
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
    private Button swapScreen;
    int screen = 0;
    @Override    
    public void start(Stage stage) {       
        Order dummy[] = new Order[3];
        boolean dum[] = new boolean[]{true, false, true, true};
        
        dummy[0] = new Order(0, 0, dum, 111, "Alex", "Bill", true);
        dummy[1] = new Order(1, 0, dum, 123, "Wills", "Frank", false);
        dummy[2] = new Order(0, 1, dum, 444, "Ashers", "Bill", true);
        
        StackPane rootPane = new StackPane();
        CustomerGUI gui = new CustomerGUI();
        Scene scene = new Scene(rootPane, 630, 540);
        rootPane.getChildren().add(gui);
        
        StackPane secondPane = new StackPane();
        CookGUI cookGUI = new CookGUI(dummy);
        Scene scene2 = new Scene(secondPane, 630, 540); 
        secondPane.getChildren().add(cookGUI);
        
        StackPane thirdPane = new StackPane();
        cashierUI cashierGUI = new cashierUI();
        Scene scene3 = new Scene(thirdPane, 630, 540); 
        thirdPane.getChildren().add(cashierGUI);
        
        //StackPane fourthPane = new StackPane();
        //LoginGUI loginGUI = new LoginGUI();
        //Scene scene4 = new Scene(thirdPane, 630, 540); 
        //thirdPane.getChildren().add(loginGUI);
        
        
        swapScreen = new Button("Swap GUI");   
        swapScreen.setTranslateX(270);
        swapScreen.setTranslateY(240);
        swapScreen.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event)
            {
                if(screen == 0){
                    stage.setScene(scene); 
                    screen = 1;
                    rootPane.getChildren().add(swapScreen);
                }
                else if(screen == 1){
                    stage.setScene(scene2);
                    screen = 2;
                    secondPane.getChildren().add(swapScreen);
                }
                else if(screen == 2){
                    stage.setScene(scene3);
                    screen = 0;
                    thirdPane.getChildren().add(swapScreen);
                }
                //else if(screen == 3) {
                //	stage.setScene(scene4);
                //    screen = 0;
                //    fourthPane.getChildren().add(swapScreen);
                //}
            }
        });
        
        
 
        stage.setTitle("Pizza GUI"); 
           
        //Adding scene to the stage
        rootPane.getChildren().add(swapScreen); 
        stage.setScene(scene); 
        //Displaying the contents of the stage 
        stage.show(); 
        
     }//end start
     
    public static void main(String[] args)
    {
        launch(args);
    }//end main
    //changes
    
    
    
}
