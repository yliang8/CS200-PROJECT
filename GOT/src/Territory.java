import java.util.Arrays;
import java.util.LinkedList;

public class Territory {
	private String name;
	private int supply; //number of supplies
	private int crown; //number of crowns
	private int castle;//castle = 1, stronghold = 2, no castle or stronghold = 0;
	private boolean landOrSea; //true(1) = sea, false(0) = land
	private String[] adjTerrs; //name of its adjacent areas
	private LinkedList<Unit> units = new LinkedList<Unit> (); //the units in this territory
	private Order order = new Order ();
	 
	public Territory(String name, int supply, int crown, int castle, boolean landOrSea){
		this.name = name;
		this.supply = supply;
		this.crown = crown;
		this.castle = castle; 
		this.landOrSea = landOrSea;
	}
	
	public String getName(){
		return name;
	}
	public int getSupply(){
		return supply;
	}
	public int getCrown(){
		return crown;
	}
	public int getCastle(){
		return castle;
	}
	public boolean getLandOrSea(){
		return landOrSea;
	}
	public String[] getAdj(){
		return adjTerrs;
	}
	public LinkedList<Unit> getUnits(){
		return units;
	}
	public Order getOrder(){
		return order;
	}
	
	
	public void setName(String n){
		name = n;
	}
	public void setSupply(int s){
		supply = s;
	}
	public void setCrown(int c){
		crown = c;
	}
	public void setCastle(int c){
		castle = c;
	}
	public void setLandOrSea(boolean info){
		landOrSea = info;
	}
	public void setAdj(String[] adj){
		adjTerrs = adj;
	}
	public void addUnits(Unit u){
		units.add(u);
	}
	public void setOrder(Order o){
		order = o;
	}
	public void deleteOrder(){
		order = null;
	}
	
	
	public String toString() {
		return String.format("%s, %d, %d, %d, %b, %s, %s, %s\n", name, supply, crown, castle, landOrSea, Arrays.toString(adjTerrs), units, order);
	}
}
