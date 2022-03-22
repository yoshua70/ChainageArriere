package chainagearriere;

import java.util.ArrayList;

public class Regle {

	public String enonce;
	public boolean aEteExecute = false;
	private ArrayList<Fait> _premisses = new ArrayList<>();
	private Fait _conclusion;
	
	Regle(String enonce) {
		this.enonce = enonce;
		setPremisses(enonce.split("=>")[0]);
		setConclusion(enonce.split("=>")[1]);
	}
	
	public void setPremisses(String premisses) {
		for(String fait : premisses.split("&")) {
			this._premisses.add(new Fait(fait));
		}
	}
	
	public void setConclusion(String conclusion) {
		this._conclusion = new Fait(conclusion);
	}
	
	public ArrayList<Fait> getPremisses() {
		return this._premisses;
	}
	
	public Fait getConclusion() {
		return this._conclusion;
	}
	
	public boolean equals(Regle regle) {
		return this.enonce.equals(regle.enonce);
	}
}
