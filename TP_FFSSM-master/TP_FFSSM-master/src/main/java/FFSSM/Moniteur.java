/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.*;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public ArrayList<Embauche> lesEmployeurs;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupe, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, groupe);
        this.numeroDiplome = numeroDiplome;
        this.lesEmployeurs = new ArrayList<Embauche>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
            if(this.lesEmployeurs.size() == 0) return Optional.ofNullable(null);
            lesEmployeurs.sort((o1, o2) -> o1.getDebut().compareTo(o2.getDebut()));
            return Optional.ofNullable(lesEmployeurs.get(lesEmployeurs.size() - 1).getEmployeur());
        }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
       Embauche e = new Embauche(debutNouvelle, this, employeur);
       employeur.addEmbauche(e);
        lesEmployeurs.add(e);
    }

    public void terminerEmbauche(LocalDate fin){
        lesEmployeurs.sort((o1, o2) -> o1.getDebut().compareTo(o2.getDebut()));
        lesEmployeurs.get(lesEmployeurs.size() - 1).terminer(fin);
    }

    public List<Embauche> emplois() {
        return lesEmployeurs;
    }

}
