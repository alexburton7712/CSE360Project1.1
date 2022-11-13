 


public class Pizza {
    //0 = cheese, 1 = pepperoni, 2 = vegetable
    private int type;
    //0 = small, 1 = medium, 2 = large
    private int size;
    //array of strings to hold the toppings on the pizza
    //0 = mushrooms, 1 = onions, 2 = olives, 3 = extra Cheese
    private boolean[] toppings;
    
    //constructor
    public Pizza(int type, int size, boolean[] toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }    

    //getters
    public int getType() {
        return type;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean[] getToppings() {
        return toppings;
    }
    
    
    //setters
    public void setToppings(int index) {
        toppings[index] = !toppings[index];
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public String toString() {
        String pizza = "This pizza is a ";
        
        switch(size) {
            case 0:
                pizza += "small ";
                break;
            case 1:
                pizza += "medium ";
                break;
            case 2:
                pizza += "large ";
                break;
            default:
                pizza += "";
                break;
        }
        
        switch(type) {
            case 0:
                pizza += "cheese pizza ";
                break;
            case 1:
                pizza += "pepperoni pizza ";
                break;
            case 2:
                pizza += "vegetable pizza ";
                break;
            default:
                pizza += "";
                break;
        }
        
        if(!toppings[0] && !toppings[1] && !toppings[2] && !toppings[3]) {
            pizza += "with no toppings.";
        }
        else {
            
            pizza += "with ";
            
            if(toppings[0]) {
                pizza += "mushrooms ";
            }
            if(toppings[1]) {
                pizza += "onions ";
            }
            if(toppings[2]) {
                pizza += "olives ";
            }
            if(toppings[3]) {
                pizza += "extra cheese ";
            }
        }
        
        return pizza;
    }
    
}
