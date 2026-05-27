import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    private List<String> noeuds;
    private List<Arcs> adjacence;

    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    private int indiceNoeud(String n) {
        return this.noeuds.indexOf(n);
    }

    public void ajouterNoeud(String n) {
        if (this.indiceNoeud(n) == -1) {
            this.noeuds.add(n);
            this.adjacence.add(new Arcs());
        }
    }

    public void ajouterArc(String source, String noeud, int poid) {
        this.ajouterNoeud(source);
        this.ajouterNoeud(noeud);
        int i = this.indiceNoeud(source);
        this.adjacence.get(i).ajouterArc(new Arc(noeud, poid));
    }

    @Override
    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    @Override
    public List<Arc> suivants(String n) {
        int i = this.indiceNoeud(n);
        if (i == -1) {
            return new ArrayList<>();
        }
        return this.adjacence.get(i).getArcs();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.noeuds.size(); i++) {
            sb.append(this.noeuds.get(i)).append(" -> ").append(this.adjacence.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}