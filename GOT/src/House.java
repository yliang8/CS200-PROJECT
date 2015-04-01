import java.util.LinkedList;


public class House {
	String name;
	LinkedList<Territory> Terrs = new LinkedList<Territory> ();
	LinkedList<Order> Orders = new LinkedList<Order> ();
	int powerToken; //how much money that the current house has
	
	public String toString(){
		return Orders.toString();
	}
	
	public House(){
		
	}
	
	public House(HOUSES house) {
		addOrders();
		switch (house) {
			case LANNISTER:
				name = "LANNISTER";
				break;
			case BARATHEON:
				name = "BARATHEON";
				break;
			case STARK:
				name = "STARK";
				break;
			case GREYJOY:
				name = "GREYJOY";
				break;
			case TYRELL:
				name = "TYRELL";
				break;
			case MARTELL:
				name = "MARTELL";
				break;
		}
	}
	
	public void addOrders(){
		Order raid = new Order (Order.ORDERS.RAID);
		Order march0 = new Order (Order.ORDERS.MARCH0);
		Order marchn = new Order (Order.ORDERS.MARCHN);
		Order defense = new Order (Order.ORDERS.DEFENSE);
		Order support = new Order (Order.ORDERS.SUPPORT);
		Order consolidate = new Order (Order.ORDERS.CONSOLIDATE);
		Order sraid = new Order (Order.ORDERS.sRAID);
		Order smarch = new Order (Order.ORDERS.sMARCH);
		Order sdefense = new Order (Order.ORDERS.sDEFENSE);
		Order ssupport = new Order (Order.ORDERS.sSUPPORT);
		Order sconsolidate = new Order (Order.ORDERS.sCONSOLIDATE);
		for (int i = 0;i<2; i++){
			Orders.add(raid);
			Orders.add(defense);
			Orders.add(support);
			Orders.add(consolidate);
		}
		Orders.add(march0);
		Orders.add(marchn);
		Orders.add(sraid);
		Orders.add(smarch);
		Orders.add(ssupport);
		Orders.add(sdefense);
		Orders.add(sconsolidate);
	}
	
	
	public enum HOUSES {
		LANNISTER,
		BARATHEON,
		STARK,
		GREYJOY,
		TYRELL,
		MARTELL,
	}
	
	public boolean containsOrder(String o){
		for(Order order: Orders){
			if(order.getName().equals(o)){
				return true;
			}
		}
		return false;
	}
	
	
	public LinkedList<Order> getOrders(){ 
		return Orders;
	}
	
	public Order getOrder(String o){
		for(Order order: Orders){
			if(order.getName().equals(o)){
				return order;
			}
		}
		return null;
	}
	
	public LinkedList<Territory> getTerrs(){
		return Terrs;
	}
}
