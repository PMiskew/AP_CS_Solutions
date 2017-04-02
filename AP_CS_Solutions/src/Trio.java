
public class Trio implements MenuItem {

	private Sandwich sandwich;
	private Salad salad;
	private Drink drink;

	public Trio(Sandwich sandwich, Salad salad, Drink drink) {
		this.sandwich = sandwich;
		this.salad = salad;
		this.drink = drink;
	}
	
	public String getName(){
		
		return sandwich.getName() +"/"+salad.getName()+"/"+drink.getName() +" Trio";
	}
	
	public double getPrice() {
		
		double pSandwich = sandwich.getPrice();
		double pSalad = salad.getPrice();
		double pDrink = drink.getPrice();
		
		double total = pSandwich + pSalad + pDrink;
		
		double minPrice = Math.min(pSandwich,Math.min(pSalad, pDrink));
		
		total = total - minPrice;
		
		return total;
	
		
	}
	
	/**
	 * THIS METHOD HAS BEEN ADDED TO TEST THE CODE
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sandwich sandwich1 = new Sandwich(2.75,"Cheeseburger");
		Sandwich sandwich2 = new Sandwich(3.00,"Club Sandwich");
		
		Salad salad1 = new Salad(1.25,"Spinich Salad");
		Salad salad2 = new Salad(2.50,"Cole Slaw");
		
		Drink drink1 = new Drink(0.50,"Orange Soda");
		Drink drink2 = new Drink(3.50,"Cappuccino");
		
		Trio trio1 = new Trio(sandwich1,salad1,drink1);
		Trio trio2 = new Trio(sandwich2,salad2,drink2);
		
		System.out.println(trio1.getName());
		System.out.println("Price: "+trio1.getPrice());

		System.out.println(trio2.getName());
		System.out.println("Price: "+trio2.getPrice());
	
		
	}

}
