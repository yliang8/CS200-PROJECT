import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Map {
	
	public Map() throws BiffException, IOException{
		initializeTerrList();
		initializeUnits();
		initializePowerTrack();
	}
	
	// Initial territory list
	public void initializeTerrList() throws BiffException, IOException {
		Workbook workbook = Workbook.getWorkbook(new File("GOTMAPS.xls"));
		Sheet sheet = workbook.getSheet(1);
		int numOfTerr = sheet.getRows()-1; 
		
		for (int i=1; i<=numOfTerr; i++){
			Cell col0 = sheet.getCell(0, i); // name 
			Cell col1= sheet.getCell(1, i); // supply
			Cell col2 = sheet.getCell(2, i); // crown 
			Cell col3 = sheet.getCell(3, i); // castle
			Cell col4 = sheet.getCell(4, i); // landOrSea	
			
			String name = col0.getContents();
			int supply = Integer.parseInt(col1.getContents());
			int crown = Integer.parseInt(col2.getContents());;
			int castle = Integer.parseInt(col3.getContents());
			boolean landOrSea = false; 
			if (Integer.parseInt(col4.getContents())==1){ //sea :true
				landOrSea = true;
			}
			Territory territory = new Territory(name, supply, crown, castle, landOrSea);
			Game.territories.put(name, territory);
		}
		
		for (int i=1; i<=numOfTerr; i++){
			Cell col0 = sheet.getCell(0, i); // name 
			Cell col5 = sheet.getCell(5, i); //adjacent areas 
			
			String name = col0.getContents();
			Territory T = Game.territories.get(name);
			
			String adjNames[] = col5.getContents().split(", "); 
			T.setAdj(adjNames);
		}
		workbook.close();
	}
	
	// Each house put down their starting units 
	public void initializeUnits() throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File("GOTMAPS.xls"));
		Sheet sheet = workbook.getSheet(0); //starting units
		
		for (int j = 1; j<=6; j++){ //column : house name
			for (int i=1; i<=3; i++){ //row: territories
				Cell col1 = sheet.getCell(j, i); 
				String terrs[] = col1.getContents().split(", "); 
				for (String t: terrs){
					Territory occupied = Game.territories.get(t);
					
					switch (i) {
					case 1: //footman
						Unit footman = new Unit (Unit.UNITS.FOOTMAN);
						occupied.addUnits(footman);
						break;
					case 2: //knight
						Unit knight = new Unit (Unit.UNITS.KNIGHT);
						occupied.addUnits(knight);
						break;
					case 3: //ship
						Unit ship = new Unit (Unit.UNITS.SHIP);
						occupied.addUnits(ship);
						break;
					}
					
					switch(j) {
					case 1: 
						if(!Game.lannister.Terrs.contains(occupied)) Game.lannister.Terrs.add(occupied);
						break;
					case 2:
						if(!Game.baratheon.Terrs.contains(occupied)) Game.baratheon.Terrs.add(occupied);
						break;
					case 3: 
						if(!Game.stark.Terrs.contains(occupied)) Game.stark.Terrs.add(occupied);
						break;
					case 4: 
						if(!Game.greyjoy.Terrs.contains(occupied)) Game.greyjoy.Terrs.add(occupied);
						break;
					case 5: 
						if(!Game.tyrell.Terrs.contains(occupied)) Game.tyrell.Terrs.add(occupied);
						break;
					case 6:
						if(!Game.martell.Terrs.contains(occupied)) Game.martell.Terrs.add(occupied);
						break;
					}
				}	
			}
		}
	}

	public void printHS(){
		System.out.println(Game.territories);
	}
	
	// Initialize Power Tracks
	public void initializePowerTrack() throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File("GOTMAPS.xls"));
		Sheet sheet = workbook.getSheet(2); //power tracks
		
		for (int j=0; j<5; j++){ //column : trackname
			for (int i=1; i<=6; i++){ //row: positions
				Cell col = sheet.getCell(j, i); 
				switch (j) {
				case 0: // Ironthrone
					Tracks.ironThrone[i-1] = col.getContents();
					break;
				case 1: // fiefdom track
					Tracks.fiefdoms[i-1] = col.getContents();
					break;
				case 2: //King's court
					Tracks.kingsCourt[i-1] = col.getContents();
					break;
				case 3: // Supply
					if (i<3) {
						String supplies[] = col.getContents().split(", ");
						for (String s: supplies){
							Tracks.supply[i-1] = new LinkedList<String>();;
							Tracks.supply[i-1].add(s);
						}
					}
					break;
				case 4: // Victory
					if (i<3) {
						String victories[] = col.getContents().split(", ");
						for (String v: victories){
							Tracks.victory[i-1] = new LinkedList<String>();;
							Tracks.victory[i-1].add(v);
						}
					}
					break;
				}
			}
		}
	}
	
}
