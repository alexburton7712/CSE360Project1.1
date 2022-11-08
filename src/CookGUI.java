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
	
	private Label label1;
	private Button cookButton;
	private Button customerButton;
	private VBox vBox;
	
	public CookGUI() {
		label1 = new Label("Are you a cook or a customer?");
		
		cookButton = new Button("Cook");
		
		customerButton = new Button("Customer");
		
		vBox = new VBox();
		
		Insets inset = new Insets(25);
	    vBox.setPadding(inset);
	    
	    vBox.getChildren().addAll(label1);
	    vBox.getChildren().addAll(cookButton);
	    vBox.getChildren().addAll(customerButton);
	    
	    VBox.setMargin(vBox, new Insets(0, 0, 0, 8));
	    
	    this.setCenter(vBox);
	}

}
