package testfffffff;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.*;
import FFSSM.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class testPlongee {
    Plongee p, p2;
    Moniteur m1;
    Club c;
    Plongeur pg, pg2;


    @BeforeEach
  public void setUp(){
        m1 = new Moniteur("244751", "Miralles", "Lucas", "12 rue de Loli", "0642085532", LocalDate.of(2002, 11, 9), 3 , GroupeSanguin.AMOINS, 25);
        c = new Club(m1, "Requin", "0728819");
        pg = new Plongeur("224885", "Auberge", "harry", "21 rue ampere", "02248850055", LocalDate.of(2000, 1, 1), 5, GroupeSanguin.BMOINS);
        p = new Plongee(new Site("Valras", "Mer"), m1, LocalDate.of(2022, 12, 21), 100, 2, c);


    }


    @Test  public void testCreation(){
        assertTrue(p instanceof Plongee);
    }

    @Test public void testAjouteParticipant(){
        pg.ajouteLicence("34994", LocalDate.of(2017, 8, 2), c);
        p.ajouteParticipant(pg);

        assertEquals(p.lesPalanquees.get(0).getPossesseur(), pg);
    }

    @Test  public void testEstConforme(){
        pg.ajouteLicence("34994", LocalDate.of(2017, 8, 2), c);
        p.ajouteParticipant(pg);
        assertFalse(p.estConforme());

        pg2 = new Plongeur("3993", "Garcion", "Lois", "paradis", "83739303", LocalDate.of(2002, 1, 10), 2, GroupeSanguin.BPLUS);
        pg2.ajouteLicence("8383", LocalDate.of(2022, 10, 1), c);

        p2 = new Plongee(new Site("Dijon", "foret"), m1, LocalDate.of(2022, 12, 13), 50, 1, c);
        p2.ajouteParticipant(pg2);

        assertTrue(p2.estConforme());
    }
}
