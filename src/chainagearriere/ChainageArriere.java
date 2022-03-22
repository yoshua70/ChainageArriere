package chainagearriere;

import java.util.ArrayList;

public class ChainageArriere {
	
	public static boolean eval(Regle regle, BaseDeFaits bf, ArrayList<String> memoireDetravail) {
		for(Fait premisse : regle.getPremisses())
			if(!bf.appartient(premisse)) return false;
		regle.aEteExecute = true;
		bf.ajouterFait(regle.getConclusion());
		memoireDetravail.add(bf.getFaitsString());
		
		return true;
	}

	public static boolean executer(Fait but, BaseDeFaits bf, BaseDeRegles br) {
		
		ArrayList<Fait> faitsAProuver = new ArrayList<>();
		ArrayList<Regle> reglesAExecuter = new ArrayList<>();
		ArrayList<String> memoireDeTravail = new ArrayList<>();
		memoireDeTravail.add(bf.getFaitsString());
		
		faitsAProuver.add(but);
		
		System.out.println("Base de faits initiale : ");
		bf.afficher();
		System.out.println("Base de règles : ");
		br.afficher();
		System.out.println("############################");
		System.out.println("#   Debut Algorithme       #");
		System.out.println("#   by Michee Allidjinou   #");
		System.out.println("############################");
		
		System.out.println("But : " + but.nom);
		
		while(!bf.appartient(but)) {
			int i = 0;
			Fait faitAProuver = faitsAProuver.remove(faitsAProuver.size() - 1);
			for(Regle regle : br.getRegles()) {
				if(faitAProuver.equals(regle.getConclusion())) {
					i = 0;
					reglesAExecuter.add(regle);
					for(Fait prem : regle.getPremisses()) {
						if(!bf.appartient(prem)) {
							faitsAProuver.add(prem);
							i++;
						}
					}
					if(i == 0) {
						
						try {
							faitsAProuver.remove(faitsAProuver.size() - 1);
						} catch (IndexOutOfBoundsException e) {
							
						}
					}
				}
			}
			
			for(int j = reglesAExecuter.size() - 1; j >= 0; j--) {
				eval(reglesAExecuter.get(j), bf, memoireDeTravail);
			}
			if(faitsAProuver.isEmpty() && !bf.appartient(but))
				return false;
		}
		
		System.out.println("Règles utilisées : ");
		for(int j = 0; j < reglesAExecuter.size(); j++)
			if(reglesAExecuter.get(j).aEteExecute)
				System.out.println(reglesAExecuter.get(j).enonce);
		
		System.out.println("Etats successifs de la mémoire de travail : ");
		for(int j = 0; j < memoireDeTravail.size(); j++)
			System.out.println(memoireDeTravail.get(j));
		return true;
	}
	
	public static void main(String[] args) {
		BaseDeFaits bf = new BaseDeFaits("A,C,D,K");
		BaseDeRegles br = new BaseDeRegles("E&C=>B;A&D=>E;H=>W;F=>G;C&G=>F;A&B=>G");
		
		System.out.println(ChainageArriere.executer(new Fait("F"), bf, br));
	}
}
