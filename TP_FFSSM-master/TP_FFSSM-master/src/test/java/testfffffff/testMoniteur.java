package testfffffff;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.*;
import FFSSM.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testMoniteur {
    Embauche e1, e2;
    Club c;
    Moniteur m1;

    @BeforeEach
    public void setUp(){
        m1 = new Moniteur("244751", "Miralles", "Lucas", "12 rue de Loli", "0642085532", LocalDate.of(2002, 11, 9), 3 , GroupeSanguin.AMOINS, 25);
        c = new Club(m1, "Requin", "0728819");
        e1 = new Embauche(LocalDate.of(2017, 3, 26), m1, c);

        m1.nouvelleEmbauche(c, LocalDate.of(2014, 4, 24));
        m1.nouvelleEmbauche(c, LocalDate.of(2022, 8, 15));
    }


    @Test public void testCreation(){
        assertTrue(e1 instanceof Embauche);
    }

 // Test employeur() et nouvelleEmbauche()
 @Test  public void testEmployeur(){
        assertEquals(c, m1.employeurActuel().get());
    }

 // TerminerEmbauche
 @Test public void testTerminerEmbauche(){
        m1.terminerEmbauche(LocalDate.of(2022, 12, 4));
        List<Embauche> l = m1.emplois();
        assertTrue(l.get(l.size() - 1).estTerminee());
    }

    @Test  public void testEmplois(){
        assertEquals(2, m1.emplois().size());
    }
}
