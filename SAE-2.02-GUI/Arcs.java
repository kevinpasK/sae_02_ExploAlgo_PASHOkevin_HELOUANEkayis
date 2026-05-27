import java.util.ArrayList;
import java.util.List;

public class Arcs {
    private List<Arc> listeArcs;

    public Arcs() {
        this.listeArcs = new ArrayList<>();
    }

    public void ajouterArc(Arc a) {
        this.listeArcs.add(a);
    }

    public List<Arc> getArcs() {
        return this.listeArcs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Arc a : this.listeArcs) {
            sb.append(a.toString()).append(" ");
        }
        return sb.toString();
    }
}