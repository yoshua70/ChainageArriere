package chainagearriere;

import java.util.ArrayList;

public class BaseDeFaits {
	
	private ArrayList<Fait> _faits;
	
	public BaseDeFaits(ArrayList<Fait> faits) {
		this._faits = new ArrayList<>(faits);
	}
	
	public BaseDeFaits(String faits) {
		this._faits = new ArrayList<>();
		for(String fait : faits.split(","))
			this._faits.add(new Fait(fait));
	}
	
	public void setFaits(ArrayList<Fait> faits) {
		this._faits = new ArrayList<>(faits);
	}
	
	public void setFaits(String faits) {
		this._faits = new ArrayList<>();
		for(String fait : faits.split(","))
			this._faits.add(new Fait(fait));
	}
	
	public ArrayList<Fait> getFaits() {
		return this._faits;
	}
	
	public String getFaitsString() {
		String faits = "";
		for(Fait fait : this._faits) {
			faits += fait.nom + ",";
		}
		
		return faits;
	}
	
	public boolean appartient(Fait hypothese) {
		for(Fait fait : this._faits)
			if(fait.equals(hypothese))
				return true;
		return false;
	}
	
	public void ajouterFait(Fait hypothese) {
		if(!this.appartient(hypothese))
			this._faits.add(hypothese);
	}
	
	public void ajouterFait(String hypothese) {
		if(!this.appartient(new Fait(hypothese)))
			this._faits.add(new Fait(hypothese));
	}
	
	public void ajouterFaits(ArrayList<Fait> faits) {
		for(Fait fait : faits)
			if(!this.appartient(fait))
				this._faits.add(fait);
	}
	
	public void ajouterFaits(String faits) {
		for(String fait : faits.split(","))
			if(!this.appartient(new Fait(fait)))
				this._faits.add(new Fait(fait));
	}
	
	public void afficher() {
		for(Fait fait : this._faits)
			System.out.print(fait.nom + ",");
		System.out.println();
	}
}
