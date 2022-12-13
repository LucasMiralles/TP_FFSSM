package testfffffff;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDate;

import FFSSM.*;
import org.junit.jupiter.api.Test;

public class testClub {
    Moniteur m1, m2;
    Club c;
    Plongeur p;
    Plongee pe;


    @BeforeEach
      public void setUp(){
        m1 = new Moniteur("244751", "Miralles", "Lucas", "12 rue de Loli", "0642085532", LocalDate.of(2002, 11, 9), 3 , GroupeSanguin.AMOINS, 25);
        c = new Club(m1, "Requin", "0728819");

        p = new Plongeur("224885", "Auberge", "harry", "21 rue ampere", "02248850055", LocalDate.of(2000, 1, 1), 5, GroupeSanguin.BMOINS);
        pe = new Plongee(new Site("Valras", "Mer"), m2, LocalDate.of(2022, 12, 21), 100, 2, c);

        m2 = new Moniteur("3IBF3f", "Brignatz", "Loris", "14 rue de Castres", "0781794004", LocalDate.of(2002, 11, 19), 3, GroupeSanguin.APLUS,22);

    }

    @Test  public void testCreation(){
        assertTrue(c instanceof Club);
    }


    @Test  public void testplongeesNonConformes(){
        p.ajouteLicence("34994", LocalDate.of(2016, 8, 2), c);
        pe.ajouteParticipant(p);
        c.organisePlongee(pe);

        int i = c.plongeesNonConformes().size();
        assertEquals(1, i);
        assertTrue(c.plongeesNonConformes().contains(pe));
    }

    @Test  public void testDirecteur(){
        c.setPresident(m2);
        assertEquals(m2, c.getPresident());
    }
}
