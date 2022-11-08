
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
	
}
