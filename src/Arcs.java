import java.util.ArrayList;
import java.util.List;

public class Arcs {

    private List<Arc> listeArcs;

    /**
     * cree une liste vide
     */
    public Arcs() {
        this.listeArcs = new ArrayList<>();
    }

    /**
     * ajoute un arc dans la liste
     * @param a l'arc a ajouter
     */
    public void ajouterArc(Arc a) {
        this.listeArcs.add(a);
    }

    /**
     * @return la liste des arcs
     */
    public List<Arc> getArcs() {
        return this.listeArcs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Arc a : this.listeArcs) {
            sb.append(a.toString()).append(" ");
        }
        return sb.toString();
    }
}