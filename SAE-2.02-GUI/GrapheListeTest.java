import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrapheListeTest {

    private GrapheListe g;

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
    }

    @Test
    void testNombreDeNoeuds() {
        assertEquals(5, g.listeNoeuds().size());
    }

    @Test
    void testNoeudsPresents() {
        List<String> noeuds = g.listeNoeuds();
        assertTrue(noeuds.contains("A"));
        assertTrue(noeuds.contains("B"));
        assertTrue(noeuds.contains("C"));
        assertTrue(noeuds.contains("D"));
        assertTrue(noeuds.contains("E"));
    }

    @Test
    void testArcsSortantsDeA() {
        List<Arc> arcsA = g.suivants("A");
        assertEquals(2, arcsA.size());
        assertEquals("B", arcsA.get(0).getNoeud());
        assertEquals(12.0, arcsA.get(0).getPoid());
        assertEquals("D", arcsA.get(1).getNoeud());
        assertEquals(87.0, arcsA.get(1).getPoid());
    }

    @Test
    void testArcsSortantsDeD() {
        List<Arc> arcsD = g.suivants("D");
        assertEquals(2, arcsD.size());
        assertEquals("B", arcsD.get(0).getNoeud());
        assertEquals("C", arcsD.get(1).getNoeud());
    }

    @Test
    void testNoeudInconnuRenvoieListeVide() {
        assertEquals(0, g.suivants("Z").size());
    }

    @Test
    void testPasDeDoublonDeNoeud() {
        g.ajouterArc("A", "C", 5);
        assertEquals(5, g.listeNoeuds().size());
        assertEquals(3, g.suivants("A").size());
    }
}