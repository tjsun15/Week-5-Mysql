package sports1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import sports.dao.SportsDao;
import sports.entity.Sports;

public class SportApp {
	
	private Scanner sc = new Scanner(System.in);
	private SportsDao sportsDao = new SportsDao();
	
	public static void main(String[] args) {
		
		new SportApp().run();
	}
/**
 * 
 */
	private void run() {
		
		while(true) {
			printInstructions();
			
			System.out.print("Enter a selection: ");
			String choice = sc.nextLine();
			
			if(choice.isEmpty()) {
				break;
			}
			
			try {
			switch(choice) {
			case "1":
				createSport();
				break;
				
			case "2":
				modifySports();
				break;
				
			case "3":
				listSports();
				break;
				
			case "4":
				deleteSport();
				
				break;
				
				default:
					System.out.println("Invalid selection");
					
				
			}
		}
		catch(Exception e)	{
			System.out.println("There's an error: " + e.getMessage());
			break;
		}
	}
	/**
	 * @throws SQLException 
	 * 
	 */
	}		//added this one
	
	private void deleteSport() throws SQLException {
		listSports();
		System.out.print("Enter the Sports ID to delete:");
		int sport_id = Integer.parseInt(sc.nextLine());
	
		sportsDao.deleteSports(sport_id);
		listSports();
}
	private void modifySports() throws SQLException {
		listSports();
		System.out.print("Enter the Sports ID to modify:");
		int sport_id = Integer.parseInt(sc.nextLine());
	
		System.out.print("Enter the new sport_name: ");
		String sport_name = sc.nextLine();
		
		sportsDao.modifySports(sport_id, sport_name);
		listSports();
}
	private void listSports() throws SQLException {
	List<Sports> sports = sportsDao.fetchSports();
	
	sports.stream().forEach(System.out::println);
}
	private void createSport() throws SQLException {
	System.out.println("Enter name of sport: ");
	String sport_name = sc.nextLine(); 
	sportsDao.createSports(sport_name);
	}
	
	/**
	 * 
	 */
	private void printInstructions() {
		System.out.println("Please choose an option: ");
		System.out.println("1: Create a Sport");
		System.out.println("2: Modify a Sport");
		System.out.println("3: List all Sports");
		System.out.println("4: Delete a Sport");
	}
	}


