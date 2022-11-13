 


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
        
        /*
        for(int i = 0; i < orders.length; i++)
        {
            Order order = orders[i];
            orderNum = new Label("Order number" + order.getID());
            //outer.getChildren().addAll(orderNum,order);
            outer.getChildren().addAll(orderNum);
        }*/    
        
        for(int i = 0; i < pizzaList.size(); i++) {
            int size = pizzaList.get(i).getPizzaList().size();
            for(int j = 0; j < size; j++) {
                outer.getChildren().add(
                new VBox(
                    new Label(
                        pizzaList.get(i).getPizzaList().get(j).toString()
                        )
                    )
                );
            }
        }
        
        
        
        Insets inset = new Insets(25);
        outer.setPadding(inset);                
        outer.setMargin(outer, new Insets(0, 0, 0, 8));
        
        this.setCenter(outer);
    }

}
