package src;

import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import java.util.ArrayList;

//public class Order extends HBox{
public class Order {
    
    private Pizza pizza;
    
    private ArrayList<Pizza> pizzaList;
    // state can be 0-6: ACCEPTED, REJECTED, READY TO COOK, COOKING: ASSEMBLY, 
    //COOKING: BAKING, READY, COMPLETE
    private int state;
    //private orderNum;
    //id = 0 means not ASU student and no discount
    private int id;
    private String firstName;
    private String lastName;
    private boolean discount;
    private double price;
    private Label name;
    public Order(int type, int size, boolean[] toppings, int id, String firstName, String lastName, boolean discount) {
        this.pizza = new Pizza(type, size, toppings);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.discount = discount;
        this.price = calculatePrice();
        
        /*
        Insets inset = new Insets(25);
        this.setPadding(inset);
        this.setStyle("-fx-border-color: black");
        
        name = new Label("Name: "+ firstName + " " + lastName);
        this.getChildren().addAll(name);
        */
    }
    
    
    //calculates price for the order
    public double calculatePrice() {
        int price = 0;
        
        switch(this.pizza.getSize()) {
            case 0:
                price += 8;
            case 1:
                price += 10;
            case 2:
                price += 12;
            default:
                price = 0;
        }
        return price;
    }
    
    //changes the order to the next state in the process
    public void setNextState() {
        this.state++;
    }
    
    //getters
    public int getState() {
        return state;
    }
    public Pizza getPizza() {
        return pizza;
    }
    
    public int getID() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public boolean isDiscount() {
        return discount;
    }
    
    public double getPrice() {
        return price;
    }
    
    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }
    
    //setters
    public void setState(int state) {
        this.state = state;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName =lastName;
    }
    
    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}
