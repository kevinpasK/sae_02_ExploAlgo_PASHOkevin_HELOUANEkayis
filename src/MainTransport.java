import java.io.File;
import java.util.List;

public class MainTransport {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Erreur: usage java MainTransport <STATION_DEPART> <STATION_ARRIVEE>");
            System.exit(1);
        }

        String dossier;
        try {
            File jar = new File(MainTransport.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI());
            dossier = jar.getParent();
        } catch (Exception e) {
            dossier = ".";
        }

        String fichierNoeuds = dossier + File.separator + "stan.nodes.txt";
        String fichierArcs = dossier + File.separator + "stan.edges.txt";

        String regex = "\\[|\\]";
        String depart = args[0].split(regex)[1];
        String arrivee = args[1].split(regex)[1];

        Graphe g = LireReseau.lire(fichierNoeuds, fichierArcs);

        Dijkstra dijkstra = new Dijkstra();
        Valeurs valeurs = dijkstra.resoudre(g, depart);

        List<String> chemin = valeurs.calculerChemin(arrivee);

        System.out.println(String.join(";", chemin));
    }
}