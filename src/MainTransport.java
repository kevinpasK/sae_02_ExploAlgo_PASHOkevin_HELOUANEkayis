import java.util.List;

public class MainTransport {

    private static final String FICHIER_NOEUDS = "C:/Users/kevin/Desktop/sae_algo/sae_02_ExploAlgo_PASHOkevin_HELOUANEkayis/src/stan.nodes.txt";
    private static final String FICHIER_ARCS = "C:/Users/kevin/Desktop/sae_algo/sae_02_ExploAlgo_PASHOkevin_HELOUANEkayis/src/stan.edges.txt";


    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Erreur: usage java MainTransport <STATION_DEPART> <STATION_ARRIVEE>");
            System.exit(1);
        }

        String regex = "\\[|\\]";
        String depart = args[0].split(regex)[1];
        String arrivee = args[1].split(regex)[1];

        Graphe g = LireReseau.lire(FICHIER_NOEUDS, FICHIER_ARCS);

        Dijkstra dijkstra = new Dijkstra();
        Valeurs valeurs = dijkstra.resoudre(g, depart);

        List<String> chemin = valeurs.calculerChemin(arrivee);

        System.out.println(String.join(";", chemin));
    }
}