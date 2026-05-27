import java.util.List;

public class MainTransport {

    private static final String FICHIER_NOEUDS = "stan.nodes.txt";
    private static final String FICHIER_ARCS = "stan.edges.txt";


    private static String extraireId(String arg) {
        String regex = "\\[|\\]";
        String[] morceaux = arg.split(regex);
        if (morceaux.length >= 2) {
            return morceaux[1].trim();
        }
        return arg.trim();
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            return;
        }

        String depart = args[0];
        String arrivee = args[1];

        Graphe g = LireReseau.lire(FICHIER_NOEUDS, FICHIER_ARCS);

        Dijkstra dijkstra = new Dijkstra();
        Valeurs valeurs = dijkstra.resoudre(g, depart);

        List<String> chemin = valeurs.calculerChemin(arrivee);

        System.out.println(String.join(";", chemin));
    }
}