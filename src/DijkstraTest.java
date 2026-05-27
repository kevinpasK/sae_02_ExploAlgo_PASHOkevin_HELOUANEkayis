import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DijkstraTest {

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

        Dijkstra dijkstra = new Dijkstra();
        valeurs = dijkstra.resoudre(g, "A");
    }

    @Test
    void testDistanceDepartNulle() {
        assertEquals(0.0, valeurs.getValeur("A"));
    }

    @Test
    void testDistances() {
        assertEquals(12.0, valeurs.getValeur("B"));
        assertEquals(23.0, valeurs.getValeur("E"));
        assertEquals(66.0, valeurs.getValeur("D"));
        assertEquals(76.0, valeurs.getValeur("C"));
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
    void testDepartDifferent() {
        Dijkstra dijkstra = new Dijkstra();
        Valeurs vD = dijkstra.resoudre(g, "D");
        assertEquals(0.0, vD.getValeur("D"));
        assertEquals(10.0, vD.getValeur("C"));
        assertEquals(23.0, vD.getValeur("B"));
        assertEquals(34.0, vD.getValeur("E"));
    }

    @Test
    void testMemeResultatQueBellmanFord() {
        BellmanFord bf = new BellmanFord();
        Valeurs vBF = bf.resoudre(g, "A");
        for (String n : g.listeNoeuds()) {
            assertEquals(vBF.getValeur(n), valeurs.getValeur(n));
        }
    }
}