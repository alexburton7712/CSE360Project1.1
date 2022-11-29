
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

    
    Image pizza;
    ImageView pizzaWindow;
    
    
    
    public cashierUI(ArrayList<Order> orderList) {
        VBox container = new VBox();
        
        for(int i = 0; i < orderList.size(); i++)
        {
            VBox order = new VBox();
            String name = orderList.get(i).getName();
            int orderID = orderList.get(i).getID();
            Label title = new Label("Name: " + name + " OrderID: " + orderID );
            order.getChildren().add(title);
            for(int j = 0; j < orderList.get(i).getPizzaList().size(); j++)
            {
                VBox pizza = new VBox();
                Pizza tempPizza = orderList.get(i).getPizzaList().get(j);
                String size = "Large";
                String type = "Veggie";
                String Mush = "Y",Onions = "Y", Olives = "Y", Extra = "Y";
                boolean [] temp = tempPizza.getToppings();
                if(tempPizza.getSize() == 0)
                {
                    size = "Small";
                }
                else if(tempPizza.getSize() == 1)
                {
                    size= "Medium";
                }
                    
                if(tempPizza.getType() == 0)
                {
                    type = "Cheese";
                }
                else if(tempPizza.getType() == 1)
                {
                    type= "Pepperonni";
                }
                    
                if(temp[0] == false)
                {
                    Mush = "N";
                }
                if(temp[1] == false)
                {
                    Onions = "N";
                }
                if(temp[2] == false)
                {
                    Olives = "N";
                }
                if(temp[3] == false)
                {
                    Extra = "N";
                }
                    
                Label pizzaLabel = new Label("Pizza"+"\nSize: " + size +"   Type: " + type + "\nMushrooms: " +  Mush + "        Onions: " + Onions + "      Olives: " + Olives + "      Extra Cheese: " +
                Extra );
                
                pizza.getChildren().addAll(pizzaLabel);
                order.getChildren().addAll(pizza);
                pizza.setStyle("-fx-border-color: black");
                Insets inset = new Insets(25);
                pizza.setPadding(inset);                
                pizza.setMargin(container, new Insets(0, 0, 0, 8));
            }
            container.getChildren().addAll(order);
            order.setStyle("-fx-border-color: black");
            Insets inset = new Insets(25);
            order.setPadding(inset);                
            order.setMargin(container, new Insets(0, 0, 0, 8));
        }
        Insets inset = new Insets(25);
        container.setPadding(inset);                
        container.setMargin(container, new Insets(0, 0, 0, 8));
        
        this.setCenter(container);
    }    

}
