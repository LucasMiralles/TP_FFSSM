package testfffffff;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDate;
import FFSSM.*;
import org.junit.jupiter.api.Test;


public class testLicence {
    Licence l, l2;
    Plongeur p;
    Club c;
    Moniteur m1, m2;


    @BeforeEach
     public void setUp(){
        m1 = new Moniteur("244751", "Miralles", "Lucas", "12 rue de Loli", "0642085532", LocalDate.of(2002, 11, 9), 3 , GroupeSanguin.AMOINS, 25);
        c = new Club(m1, "Requin", "0728819");

        p = new Plongeur("224885", "Auberge", "harry", "21 rue ampere", "02248850055", LocalDate.of(2000, 1, 1), 5, GroupeSanguin.BMOINS);

        m2 = new Moniteur("3IBF3f", "Brignatz", "Loris", "14 rue de Castres", "0781794004", LocalDate.of(2002, 11, 19), 3, GroupeSanguin.APLUS,22);

        l = new Licence(p, "382330", LocalDate.of(2022, 8, 10), c);
    }


    @Test public void testCreation(){
        assertTrue(l instanceof Licence);
    }


    @Test  public void testEstValide(){
        l2 = new Licence(p, "9463", LocalDate.of(2010, 8, 10), c);
        assertFalse(l2.estValide(LocalDate.now()));

        assertTrue(l.estValide(LocalDate.now()));
    }
}
