package sports.entity;

public class Sports {
	private int sport_id;
	private String sport_name;

	

	public Sports(int sport_id, String sport_name) {
		this.sport_id = sport_id;
		this.sport_name = sport_name;
	}
	
	
	public String getName() {
		return sport_name;
	}


	public int getSport_id() {
		return sport_id;
	}
	
	@Override
	public String toString() {
		return "Sports [sport_id = " + sport_id + ", sport_name = " + sport_name + "]";
	}
	
}
