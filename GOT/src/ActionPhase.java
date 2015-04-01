
public class ActionPhase {
	
	/*
	 * ACTION PHASE : 
	 * Each house reveal and resolve order tokens
	 * Resolve combat if ensued
	 */
	public ActionPhase(){
		
	}
	
	public void resolveOrders(){
//		resolveRaid();
//		resolveMarch();
//		resolveDefense();
//		resolveSupport();
//		resolveConsolidate();
	}
	
	/*
	 * If raid order, remove adjacent area's 
	 * support, consolidate or raid order
	 */
	public void resolveRaid(House h){
		// Get the adjacent areas of the current territory that this raid order is on 
		// Check if any of these areas are controlled by another house
		// If true, then check if there is support, consolidate or raid order on it
		// Randomly remove one of them
		// Remove itself
	}
	
	/*
	 * If march order, all units in the Order 
	 * token's assigned may march to one
	 * or more adjacent areas. If march enters
	 * an area containing one or more army's 
	 * enemy's units, a combat ensues
	 * */
	public void resolveMarch(House h){
		// Get the adjacent areas of the current territory that this march order is on 
		// Randomly move one or more unit to one or more of these areas
		// Check if these areas are controlled by another house
		// If no, then move there, delete this march token
		// If yes, a combat ensues, after the combat is resolved, delete this token
	}
	
	/*
	 * If defense order, contribute its combat
	 * strength to any number of attacks against
	 * its assigned area
	 */
	public void resolveDefense(House h){
		// Add combat strengths to its assigned area in a combat
	}
	
	/* 
	 * If support order, can support the house 
	 * itself or another player; during the 
	 * combat phase, supporting units adjacent 
	 * to the embattled area may add their 
	 * combat strength to one of the two 
	 * participant in the combat
	 */
	public void resolveSupport(House supporting, House supported){
		// Add combat strengths to the house supported
	}
	
	/*
	 * If consolidate order, gain one power token
	 * from the power pool, plus one power token
	 * for each power icon printed on the assigned
	 * area.
	 */
	public void resolveConsolidate(House h){
		
	}
	
	public void resolveCombat(){
		
	}
	
}
