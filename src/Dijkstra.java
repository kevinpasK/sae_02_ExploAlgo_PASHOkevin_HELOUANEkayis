import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();

        List<String> q = new ArrayList<>();

        for (String v : g.listeNoeuds()) {
            valeurs.setValeur(v, Double.MAX_VALUE);
            q.add(v);
        }
        valeurs.setValeur(depart, 0.0);

        while (!q.isEmpty()) {

            String u = null;
            double valeurMin = Double.MAX_VALUE;
            for (String candidat : q) {
                double valeurCandidat = valeurs.getValeur(candidat);
                if (u == null || valeurCandidat < valeurMin) {
                    u = candidat;
                    valeurMin = valeurCandidat;
                }
            }

            q.remove(u);

            for (Arc arc : g.suivants(u)) {
                String v = arc.getNoeud();
                if (q.contains(v)) {
                    double d = valeurs.getValeur(u) + arc.getPoid();
                    if (d < valeurs.getValeur(v)) {
                        valeurs.setValeur(v, d);
                        valeurs.setParent(v, u);
                    }
                }
            }
        }

        return valeurs;
    }
}