 
import javafx.scene.control.Button;
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
import javafx.scene.paint.Color;
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
                if(tempPizza.getState() != 3){
                
                    Button state = new Button("State: " + tempPizza.getState() + " Change State");
                    VBox cookOrder = new VBox();
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
                    
                    Label orderName = new Label("Order Name: " + tempOrder.getName() + "    Order Number: " + tempOrder.getID()
                    +"\nSize: " + size +"   Type: " + type + "\nMushrooms: " +  Mush + "        Onions: " + Onions + "      Olives: " + Olives + "      Extra Cheese: " +
                    Extra );
                    state.setOnAction(new EventHandler<ActionEvent>(){
                        public void handle(ActionEvent event)
                        {
                            if(tempPizza.getState() == 0)
                            {
                                tempPizza.setState(1);
                            }
                            else if(tempPizza.getState() == 1)
                            {
                                tempPizza.setState(2);
                            }
                            else if(tempPizza.getState() == 2)
                            {
                                tempPizza.setState(3);
                            }
                            state.setText("State: " + tempPizza.getState() + " Change State");
                            cookOrder.setStyle("-fx-background-color: #FFFFFF;");
                            if(tempPizza.getState() == 3)
                            {
                                cookOrder.setOpacity(0);
                                for(int k = 0; k < orderList.size(); k++)
                                {
                                    if(orderList.get(k).getPizzaList().size() == 0)
                                    {
                                        orderList.remove(k);
                                    }
                                    for(int l = 0; l < orderList.get(k).getPizzaList().size();l++)
                                    {
                                        if(orderList.get(k).getPizzaList().get(l) == tempPizza)
                                        {
                                            orderList.get(k).getPizzaList().remove(l);
                                        }
                                    }
                                }
                            }
                        }
                    });
                    
                    cookOrder.getChildren().addAll(orderName,state);
                    outer.getChildren().addAll(cookOrder);
                    cookOrder.setStyle("-fx-border-color: black");
                    Insets inset = new Insets(25);
                    cookOrder.setPadding(inset);                
                    cookOrder.setMargin(outer, new Insets(0, 0, 0, 8));
                    
                }
            }
        }       
        
        
        Insets inset = new Insets(25);
        outer.setPadding(inset);                
        outer.setMargin(outer, new Insets(0, 0, 0, 8));
        
        this.setCenter(outer);
    }

}
