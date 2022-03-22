package chainagearriere;

import java.util.ArrayList;

public class BaseDeRegles {

	private ArrayList<Regle> _regles = new ArrayList<>();
	
	public BaseDeRegles(ArrayList<String> regles) {
		for(String regle : regles)
			this._regles.add(new Regle(regle));
	}
	
	public BaseDeRegles(String regles) {
		for(String regle : regles.split(";"))
			this._regles.add(new Regle(regle));
	}
	
	public ArrayList<Regle> getRegles() {
		return this._regles;
	}
	
	public void setRegles(ArrayList<String> regles) {
		for(String regle : regles)
			this._regles.add(new Regle(regle));
	}
	
	public boolean appartient(Regle regle) {
		for(Regle r : this._regles)
			if(r.equals(regle))
				return true;
		return false;
	}
	
	public void afficher() {
		for(Regle regle : this._regles)
			System.out.println(regle.enonce);
	}
	
	public void ajouterRegle(Regle regle) {
		this._regles.add(regle);
	}
}
