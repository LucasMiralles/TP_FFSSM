package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Plongeur extends Personne{
	private int niveau;
    private GroupeSanguin groupe;
    private ArrayList<Licence> lesLicences;
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.groupe = groupe;
    }
    public void ajouteLicence(String numero, LocalDate delivrance, Club c){
        Licence l = new Licence(this, numero, delivrance, c);
        lesLicences.add(l);
        l.addToClub();
    }
    public Licence derniereLicence(){
        lesLicences.sort((date1, date2) -> date1.getDelivrance().compareTo(date2.getDelivrance()));
        return lesLicences.get(lesLicences.size() - 1);
    }
}
