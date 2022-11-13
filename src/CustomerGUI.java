 

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
import javafx.scene.control.TextField;
import java.util.Arrays;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;


public class CustomerGUI extends BorderPane{
    
    //instance variabels
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    
    private ToggleGroup group;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    
    private ToggleGroup group2;
    private RadioButton rb4;
    private RadioButton rb5;
    private RadioButton rb6;
    
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    
    private VBox vBox1;
    private VBox vBox2;
    private VBox vBox3;
    private VBox vBox4;
    private VBox vBox5;//for the user input
    
    private HBox hBox1;//for the two bottom buttons create/add to order
    private HBox nameHB;
    private HBox idHB;
    
    //create textboxes
    private TextField nameTextField;
    private TextField idTextField;
    
    private Button button1;
    private Button button2;
    
    //creates the order list
    private ArrayList<Order> orderList;
    
    //**************************will change for testing*****************
    private ArrayList<Pizza> pizzaList;
    //*****************************************************************
    
    //Image pizza;
    //ImageView pizzaWindow;
    
    public CustomerGUI(ArrayList<Order> orderList) {
        
        pizzaList = new ArrayList<>();
        this.orderList = orderList;
        
        //Labels
        label1 = new Label("Sun Devil Pizza");
        label2 = new Label("Pizza Types");
        label3 = new Label("Pizza Toppings");
        label4 = new Label("Pizza Size");
        label5 = new Label("Information");
        
        
        /** pizza image
        pizza = new Image("pizza.png");
        pizzaWindow = new ImageView(pizza);
        pizzaWindow.setLayoutX(2);
        pizzaWindow.setLayoutY(2);
        pizzaWindow.setFitWidth(145);  
        pizzaWindow.setFitHeight(145);
        **/
        
        //radio buttons to select pizza type
        group = new ToggleGroup();

        rb1 = new RadioButton("Cheese");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);

        rb2 = new RadioButton("Pepperoni");
        rb2.setToggleGroup(group);
         
        rb3 = new RadioButton("Vegetable");
        rb3.setToggleGroup(group);
        
        //radio button to select pizza size
        group2 = new ToggleGroup();

        rb4 = new RadioButton("Small");
        rb4.setToggleGroup(group2);
        rb4.setSelected(true);

        rb5 = new RadioButton("Medium");
        rb5.setToggleGroup(group2);
         
        rb6 = new RadioButton("Large");
        rb6.setToggleGroup(group2);
        
        //checkboxes, all of these appear in order starting at index 0
        checkBox1 = new CheckBox("Mushrooms");
        checkBox2 = new CheckBox("Onions");
        checkBox3 = new CheckBox("Olives");
        checkBox4 = new CheckBox("Extra Cheese");
        
        //create textboxs for name of order
        Label nameBoxLabel = new Label("Name for Order:");
        TextField nameTextField = new TextField();
        nameTextField.setPromptText("John Doe");

        Label idBoxLabel = new Label("ASU ID for Order:");
        TextField idTextField = new TextField();
        idTextField.setPromptText("0000000000");

        
        //Creating Buttons 
        button1 = new Button("Add to Order"); 
        button2 = new Button("Complete Order");

        
        //vbox to hold the order screen
        vBox1 = new VBox();
        vBox2 = new VBox();
        vBox3 = new VBox();
        vBox4 = new VBox();
        vBox5 = new VBox(); //user input
        
        hBox1 = new HBox();
        nameHB = new HBox();//Hbox to collect name for order
        idHB = new HBox();//Hbox to collect name for order
        
        //add all the components to the vboxes
        vBox2.getChildren().add(rb1);
        vBox2.getChildren().add(rb2);
        vBox2.getChildren().add(rb3);
        
        vBox3.getChildren().add(checkBox1);
        vBox3.getChildren().add(checkBox2);
        vBox3.getChildren().add(checkBox3);
        vBox3.getChildren().add(checkBox4);
        
        vBox4.getChildren().add(rb4);
        vBox4.getChildren().add(rb5);
        vBox4.getChildren().add(rb6);
        
        vBox1.getChildren().add(label1);
        vBox1.getChildren().add(label2);
        vBox1.getChildren().add(vBox2);
        vBox1.getChildren().add(label3);
        vBox1.getChildren().add(vBox3);
        vBox1.getChildren().add(label4);
        vBox1.getChildren().add(vBox4);
        
        //lebel for information box
        vBox1.getChildren().add(label5);
        
        vBox1.getChildren().add(vBox5);
        
        //groups the bottom two buttons
        hBox1.getChildren().add(button1);
        hBox1.getChildren().add(button2);
        hBox1.setSpacing(17);
        vBox1.getChildren().add(hBox1);

        
        //vBox1.getChildren().add(pizzaWindow);
        
        vBox5.getChildren().add(nameHB);
        vBox5.getChildren().add(idHB);
        nameHB.getChildren().addAll(nameBoxLabel, nameTextField);
        
        nameHB.setSpacing(10);
        idHB.getChildren().addAll(idBoxLabel, idTextField);
        idHB.setSpacing(10);
        
        Insets inset = new Insets(25);
        vBox1.setPadding(inset);
        
        vBox2.setPadding(inset);
        
        vBox3.setPadding(inset);
        
        vBox4.setPadding(inset);
        
        vBox5.setPadding(inset);
        
        VBox.setMargin(vBox1, new Insets(0, 0, 0, 8));
        
        vBox1.setStyle("-fx-border-color: black");
        vBox2.setStyle("-fx-border-color: black");
        vBox3.setStyle("-fx-border-color: black");
        vBox4.setStyle("-fx-border-color: black");
        vBox5.setStyle("-fx-border-color: black");
        
        this.setCenter(vBox1);
        button1.setOnAction(new PizzaHandler());
        //button2.setOnAction(new orderCreater());
        
        
        button2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event)
            {
            try {
                //if it wont crash and will convert to string
                int correctID;
                //creates pizza array list
                //read from memory and get the last order stored and add one
                //to that ordernumber 
                //If there is no orders in memory, start at 1 again
                int orderNum = 0;
                
                if(orderList.size() == 0) {
                    orderNum = 1;
                } else {
                    orderNum = orderList.get(orderList.size()-1).getOrderNum() + 1;
                }
                //if this does not work then it throws the error
                if(!idTextField.getText().equals("")) {
                    correctID = Integer.parseInt(idTextField.getText());   
                } else {
                    correctID = 0;
                }
                String name = "";
                //runs if it is namefiled is not empty
                if(!nameTextField.getText().equals("")) {
                    name = nameTextField.getText();
                } else {
                    invalidID("No Name", "Please enter a name", "Error");
                }
                Order order = new Order(pizzaList, correctID, name);
                
                orderList.add(order);
                
                System.out.println("the try was not cought");
            }
            catch (NumberFormatException ex){
                //invalidID("Invalid ID", "Please enter a valid ASU id", "Error");
                System.out.println("the try catch was cought");
            }
            
            for(int i = 0; i < orderList.size(); i++) {
                //System.out.println(orderList().get(i).getName());
            }
            //print orderList(i) see if the details are right
        }
        
    //(error, message, title)
    private static void invalidID(String error, String message, String title) {
        Alert al = new Alert(AlertType.ERROR);
        al.setTitle(title);
        al.setHeaderText(error);
        al.setContentText(message);
        al.showAndWait();
    }      
        });
        
        
    }
    
    //adds pizza to the pizza list
    //adds pizza to order (order creates order)
    private class PizzaHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            int pizzaType = -1;
                    //cheese pizza selected
            if(rb1.isSelected()) {
                pizzaType = 0;
            }
               //pepperoni pizza
            else if(rb2.isSelected()) {
                pizzaType = 1;
            }
                //vegetable pizza
            else {
                pizzaType = 2;
            }
                    
            //size of the pizza
            int size = -1;
            if(rb4.isSelected()) {
                size = 0;
            }
            //pepperoni pizza
            else if(rb5.isSelected()) {
                size = 1;
            }
            //vegetable pizza
            else {
                size = 2;
            }
                
            boolean[] toppings = new boolean[4];
                    
            if(checkBox1.isSelected()) {
                toppings[0] = true;
            }
            if(checkBox2.isSelected()) {
                toppings[1] = true;
            }
            if(checkBox3.isSelected()) {
                toppings[2] = true;
            }
            if(checkBox4.isSelected()) {
                toppings[3] = true;
            }
                            
        
            Pizza pizza = new Pizza(pizzaType, size, toppings);
            pizzaList.add(pizza);
        }
    }
    
    //this creates the order
    
}
