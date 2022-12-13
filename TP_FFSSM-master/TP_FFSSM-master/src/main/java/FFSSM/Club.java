/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    public ArrayList<Licence> lesLicencesDelivrees;

    public ArrayList<Embauche> lesEmployes;

    public ArrayList<Plongee> lesActivites;

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
        this.lesLicencesDelivrees = new ArrayList<Licence>();
        this.lesEmployes = new ArrayList<Embauche>();
        this.lesActivites = new ArrayList<Plongee>();
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        Set<Plongee> s = new HashSet<Plongee>();
        for(Plongee p : this.lesActivites){
            if(!(p.estConforme())){
                s.add(p);
            }
        }
        return s;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        lesActivites.add(p);
    }
    public void addEmbauche(Embauche e){
        lesEmployes.add(e);
    }
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }
    public void addToLicenceDelivrees(Licence l){
        lesLicencesDelivrees.add(l);
    }
}
