
public class Order {
	
	private Pizza[] pizza;
	// state can be 0-6: ACCEPTED, REJECTED, READY TO COOK, COOKING: ASSEMBLY, 
	//COOKING: BAKING, READY, COMPLETE
	private int state;
	//id = 0 means not ASU student and no discount
	private int id;
	private String firstName;
	private String lastName;
	private boolean discount;
	private double price;
	
	public Order(int id, String firstName, String lastName, boolean discount) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.discount = discount;
	}
	
	
	//calculates price for the order
	public double calculatePrice() {
		int price = 0;
		
		for(int i = 0; i < pizza.length; i++) {
			switch(this.pizza[i].getSize()) {
				case 0:
					price += 8;
				case 1:
					price += 10;
				case 2:
					price += 12;
				default:
					price = 0;
			}
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
	//TODO update pizza getter
	public Pizza[] getPizza() {
		return this.pizza;
	}
	
	public int getId() {
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
	
	//setters
	public void setState(int state) {
		this.state = state;
	}
	
	//TODO make pizza[] setter
	

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
