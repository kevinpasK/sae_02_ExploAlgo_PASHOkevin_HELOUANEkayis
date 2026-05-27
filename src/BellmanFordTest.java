import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BellmanFordTest {

    private GrapheListe g;
    private Valeurs valeurs;

    @BeforeEach
    void setUp() {
        g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        BellmanFord bf = new BellmanFord();
        valeurs = bf.resoudre(g, "A");
    }

    @Test
    void testDistanceDepartNulle() {
        assertEquals(0, valeurs.getValeur("A"));
    }

    @Test
    void testDistances() {
        assertEquals(12, valeurs.getValeur("B"));
        assertEquals(23, valeurs.getValeur("E"));
        assertEquals(66, valeurs.getValeur("D"));
        assertEquals(76, valeurs.getValeur("C"));
    }

    @Test
    void testParents() {
        assertEquals("A", valeurs.getParent("B"));
        assertEquals("B", valeurs.getParent("E"));
        assertEquals("E", valeurs.getParent("D"));
        assertEquals("D", valeurs.getParent("C"));
    }

    @Test
    void testCheminVersC() {
        List<String> chemin = valeurs.calculerChemin("C");
        assertEquals(Arrays.asList("A", "B", "E", "D", "C"), chemin);
    }

    @Test
    void testCheminVersDepart() {
        assertEquals(Arrays.asList("A"), valeurs.calculerChemin("A"));
    }

    @Test
    void testDepartDifferent() {
        BellmanFord bf = new BellmanFord();
        Valeurs vD = bf.resoudre(g, "D");
        assertEquals(0, vD.getValeur("D"));
        assertEquals(10, vD.getValeur("C"));
        assertEquals(23, vD.getValeur("B"));
        assertEquals(34, vD.getValeur("E"));
    }
}