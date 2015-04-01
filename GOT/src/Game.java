import java.io.IOException;
import java.util.Hashtable;

import jxl.read.biff.BiffException;


public class Game{
	
	public static Hashtable<String, Territory> territories  = new Hashtable<String, Territory> ();
	
	public static House lannister = new House (House.HOUSES.LANNISTER);
	public static House baratheon = new House (House.HOUSES.BARATHEON);
	public static House stark = new House (House.HOUSES.STARK);
	public static House greyjoy = new House (House.HOUSES.GREYJOY);
	public static House tyrell = new House (House.HOUSES.TYRELL);
	public static House martell = new House (House.HOUSES.MARTELL);
	
	public static void main (String[] args) throws BiffException, IOException {
		/* 
		 * GET START PHASE : 
		 * Initialize the map
		 * Each house put down their starting units 
		 * Mark down their position on power tracks
		 */
		Map map = new Map (); 
		/*
		 * PLANNING PHASE : 
		 * Each house place down their order tokens
		 */
		PlanningPhase pp = new PlanningPhase ();
		/*
		 * ACTION PHASE : 
		 * Each house reveal and resolve order tokens
		 */
		ActionPhase ap = new ActionPhase();
		
		
	}
}
