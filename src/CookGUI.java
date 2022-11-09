
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

public class CookGUI extends BorderPane{
    
    private Label title, orderNum;
    private Button cookButton;
    private Button customerButton;
    private VBox outer;
    
    public CookGUI(Order [] orders) {
        outer = new VBox();
        
        title = new Label("Order");
        outer.getChildren().addAll(title);
        for(int i = 0; i < orders.length; i++)
        {
            Order order = orders[i];
            orderNum = new Label("Order number" + order.getID());
            outer.getChildren().addAll(orderNum,order);
        }      
        
        
        
        Insets inset = new Insets(25);
        outer.setPadding(inset);                
        outer.setMargin(outer, new Insets(0, 0, 0, 8));
        
        this.setCenter(outer);
    }

}
