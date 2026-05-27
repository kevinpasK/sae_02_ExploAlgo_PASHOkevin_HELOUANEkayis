import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    private List<String> noeuds;
    private List<Arcs> adjacence;

    /**
     * cree un graphe vide
     */
    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    /**
     * donne la position d'un noeud dans la liste
     * @param n le noeud
     * @return sa position
     */
    private int indiceNoeud(String n) {
        return this.noeuds.indexOf(n);
    }

    /**
     * ajoute un noeud
     * @param n le noeud a ajouter
     */
    public void ajouterNoeud(String n) {
        if (this.indiceNoeud(n) == -1) {
            this.noeuds.add(n);
            this.adjacence.add(new Arcs());
        }
    }

    /**
     * ajoute un arc entre deux noeuds
     * cree les noeuds
     * @param source le noeud de depart
     * @param dest le noeud d'arrivee
     * @param cout le poids de l'arc
     */
    public void ajouterArc(String source, String dest, double cout) {
        this.ajouterNoeud(source);
        this.ajouterNoeud(dest);
        int i = this.indiceNoeud(source);
        this.adjacence.get(i).ajouterArc(new Arc(dest, cout));
    }

    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    public List<Arc> suivants(String n) {
        int i = this.indiceNoeud(n);
        if (i == -1) {
            return new ArrayList<>();
        }
        return this.adjacence.get(i).getArcs();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.noeuds.size(); i++) {
            sb.append(this.noeuds.get(i));
            sb.append(" -> ");
            sb.append(this.adjacence.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}