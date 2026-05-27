public class BellmanFord {
    /**
     * calcule les plus courts chemins depuis le depart
     * @param g le graphe
     * @param depart le noeud de depart
     * @return les valeur
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();

        for (String noeud : g.listeNoeuds()) {
            valeurs.setValeur(noeud, Double.MAX_VALUE);
        }
        valeurs.setValeur(depart, 0.0);

        boolean modification = true;
        while (modification) {
            modification = false;

            for (String x : g.listeNoeuds()) {
                double valeurX = valeurs.getValeur(x);

                if (valeurX == Double.MAX_VALUE) {
                    continue;
                }

                for (Arc arc : g.suivants(x)) {
                    String n = arc.getNoeud();
                    double nouvelleValeur = valeurX + arc.getPoid();

                    if (nouvelleValeur < valeurs.getValeur(n)) {
                        valeurs.setValeur(n, nouvelleValeur);
                        valeurs.setParent(n, x);
                        modification = true;
                    }
                }
            }
        }

        return valeurs;
    }
}