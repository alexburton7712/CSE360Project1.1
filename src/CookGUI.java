 


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
import java.util.ArrayList;

public class CookGUI extends BorderPane{
    
    private Label title, orderNum;
    private Button cookButton;
    private Button customerButton;
    private VBox outer;
    private ArrayList<Order> pizzaList;
    
    public CookGUI(ArrayList<Order> orderList) {
        outer = new VBox();
        pizzaList = new ArrayList<>();
        
        title = new Label("Order");
        outer.getChildren().addAll(title);
        
        for(int i = 0; i < orderList.size(); i++)
        {
            Order tempOrder = orderList.get(i);
            for(int j = 0; j < tempOrder.getPizzaList().size(); j++)
            {
                Pizza tempPizza = tempOrder.getPizzaList().get(j);
                VBox cookOrder = new VBox();
                Label orderName = new Label(tempOrder.getName() + "\n" + tempOrder.getOrderNum() + "\n" + tempPizza.getSize() +"\n" + tempPizza.getType());
                cookOrder.getChildren().addAll(orderName);
                outer.getChildren().addAll(cookOrder);
                cookOrder.setStyle("-fx-border-color: black");
                Insets inset = new Insets(25);
                cookOrder.setPadding(inset);                
                cookOrder.setMargin(outer, new Insets(0, 0, 0, 8));
            }
        }       
        
        
        Insets inset = new Insets(25);
        outer.setPadding(inset);                
        outer.setMargin(outer, new Insets(0, 0, 0, 8));
        
        this.setCenter(outer);
    }

}
