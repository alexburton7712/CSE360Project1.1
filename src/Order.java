 

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
    private String name;
    private boolean discount = false;
    private double price;
    private int orderNum;
    
    public Order(ArrayList<Pizza> pizzaList, int id, String name) {
        this.pizzaList = pizzaList;
        
        
        this.id = id;
        this.name = name;
        if (id != 0)
            discount = true;
        this.price = calculatePrice();
        this.state = 0;
        
        this.orderNum = 0;
        
    }
    
    
    //calculates price for the order
    public double calculatePrice() {
        double price = 0;
        for(int i = 0; i < this.pizzaList.size(); i++) {
            switch(pizzaList.get(i).getSize()) {
                case 0:
                    this.price += 8;
                case 1:
                    this.price += 10;
                case 2:
                    this.price += 12;
                default:
                    this.price = price;
            }
        }
        //25% off
        if(discount) {
            price = price * 0.75;
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
    
    public String getName() {
        return name;
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
    
    public int getOrderNum() {
        return orderNum;
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}
