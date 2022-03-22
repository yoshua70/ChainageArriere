package chainagearriere;

public class Fait {

	public String nom;
	boolean estDemandable = false;
	
	Fait(String nom) {
		this.nom = nom;
	}
	
	Fait(String nom, boolean estDemandable) {
		this.nom = nom;
		this.estDemandable = estDemandable;
	}
	
	public boolean equals(Fait fait) {
		return (this.nom.equals(fait.nom)) && (this.estDemandable == fait.estDemandable);
	}
}
