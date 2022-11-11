package src;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonType;

public class cashierUI extends BorderPane{
    
    //vbox to store all of the radio button data
    private VBox vbox1;
    private VBox vbox2;
    private Label label1;
    private Label label2;
    private Label label3;
    private Button submit;
    private ToggleGroup group1;
    private RadioButton dummyR;
    private int index;//for while loop in button handler
    private boolean go;//for the while ^

    
    //*********************array to be deleted****************************
    private ArrayList<String> pizzaDeets;
    //********************************************************************
    
    Image pizza;
    ImageView pizzaWindow;
    
    
    
    public cashierUI() {
        //variable new
        //vbox
        vbox1 = new VBox();//overall vbox
        vbox1.setPadding(new Insets(25));
        vbox2 = new VBox();
        
        //array list which is displayed next to the radiobox
        pizzaDeets = new ArrayList<>();
        
        //labels
        label1 = new Label("Sun Devil Pizza\n\n\n");
        label2 = new Label("Select which order has been delivered and click submit to complete the order"); 
        label3 = new Label("Orders:");
        
        //submit button
        submit = new Button("Submit");
        
        //the group for all of the radio buttons
        group1 = new ToggleGroup();
        
        //dummy radio button
        dummyR = new RadioButton();
        
        //for index in button handler
        index = 0;
        go = true;
        
        
        //*********************delete me****************************
        pizzaDeets.add("cheese, but included is everything \neverything you could ever want");
        pizzaDeets.add("peperoni");
        pizzaDeets.add("afgan");
        pizzaDeets.add("my head hurts");
        //*****************************************************************************
        
        //adds the "sun devil pizza' label
        vbox1.getChildren().add(label1);
        vbox1.getChildren().add(label2);
        vbox1.getChildren().add(label3);
        
        //adds the text next to the radio buttons
        for (int i = 0; i < pizzaDeets.size(); i++) {
            vbox2.getChildren().add(new RadioButton(pizzaDeets.get(i)));
            dummyR = (RadioButton) vbox2.getChildren().get(i);
            dummyR.setToggleGroup(group1);
        }
        vbox1.getChildren().add(vbox2);//adds the box to vbox1
        
        vbox2.setPadding(new Insets(17));
        VBox.setMargin(vbox1, new Insets(0, 0, 0, 8));
        VBox.setMargin(vbox2, new Insets(0, 0, 15, 0));
        
        //adding the submit button
        vbox1.getChildren().add(submit);
        vbox1.setPadding(new Insets(17));
        
        vbox2.setStyle("-fx-border-color: black");
        
        this.setCenter(vbox1);
        
        /*if(group1.getToggles().indexOf(group1.getSelectedToggle()) != 1) {
            submit.setOnAction(new ButtonHandler());
        } else {
            //System.out.println("you cant do this");
        }*/
        
        submit.setOnAction(new ButtonHandler());
    }
    
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            /*if(group1.getToggles().indexOf(group1.getSelectedToggle()) == 0) {
                
            }
            //System.out.println("you cant do this");
            //System.out.println("the selected toggle is " + group1.getSelectedToggle());
            while(go) {
                if(group1.getToggles().indexOf(group1.getSelectedToggle()) == index) {
                    
                }
                index++;
                go = false;
            }*/
            
            //handles if anything is selected
            if(group1.getSelectedToggle() != null) {
                //if it is empty then you cant remove anything
                //if(group1.getToggleGroup() == null) {
                    
                //}
                if(confirmDeletePopup("", "Complete this order?","The order will not be recoverable if it is deleted.") == true) {
                    vbox2.getChildren().remove(group1.getSelectedToggle());
                }
            } else {
                errorPopup("No order selected.", "Please select an order to complete and remove.", "ERROR");
            }
        }
    }//end PizzaTypeHandeler
    
    //error message in errorPopup(title, error, message, picture type)
    private static void errorPopup(String error, String message, String title) {
        Alert al = new Alert(AlertType.ERROR);
        al.setTitle(title);
        al.setHeaderText(error);
        al.setContentText(message);
        al.showAndWait();
    }
    
    //confirm message in errorPopup(title, error, message, picture type)
    private static boolean confirmDeletePopup(String title, String error, String message) {
        Alert al = new Alert(AlertType.CONFIRMATION);
        al.setTitle(title);
        al.setHeaderText(error);
        al.setContentText(message);
        //al.showAndWait();
        
        //the option
        Optional<ButtonType> option = al.showAndWait();
        if(option.get() == null) {
            //this.label.setText("No selection");
            System.out.println("No selection");
        } else if (option.get() == ButtonType.OK) {
            System.out.println("deleted");
            cdel("Order deleted", "", "Complete");
            return true;
        } else if (option.get() == ButtonType.CANCEL) {
            System.out.println("canceled");
            return false;
        } else {
            System.out.println("canceled");
            return false;
        }
        
        //covers all cases incaase of error
        return false;
    }
    
    //completed delete popup cdel(message, error, title)
    private static void cdel(String error, String message, String title) {
        Alert al = new Alert(AlertType.INFORMATION);
        al.setTitle(title);
        al.setHeaderText(error);
        al.setContentText(message);
        al.showAndWait();
    }
}