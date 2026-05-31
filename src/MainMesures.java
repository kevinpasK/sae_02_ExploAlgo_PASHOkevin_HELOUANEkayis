import java.io.File;

public class MainMesures {

    public static void main(String[] args) {

        String dossier;
        try {
            File jar = new File(MainMesures.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI());
            dossier = jar.getParent();
        } catch (Exception e) {
            dossier = ".";
        }

        String fichierNoeuds = dossier + File.separator + "stan.nodes.txt";
        String fichierArcs = dossier + File.separator + "stan.edges.txt";

        String[][] trajets = {
                {"HLRTT0", "NYCHV0"},
                {"HLRTT0", "NYGAR1"},
                {"ARART0", "ESKLB1"},
                {"JRSNG1", "VAWIL0"}
        };

        Graphe g = LireReseau.lire(fichierNoeuds, fichierArcs);

        System.err.println("depart  | arrivee | cout BF | cout Dij | temps BF (s) | temps Dij (s)");
        System.err.println("--------|---------|---------|----------|--------------|---------------");

        for (String[] trajet : trajets) {
            String depart = trajet[0];
            String arrivee = trajet[1];

            BellmanFord bf = new BellmanFord();
            long startBF = System.nanoTime();
            Valeurs vBF = bf.resoudre(g, depart);
            long endBF = System.nanoTime();
            double tempsBF = (endBF - startBF) / 1_000_000_000.0;

            Dijkstra dij = new Dijkstra();
            long startDij = System.nanoTime();
            Valeurs vDij = dij.resoudre(g, depart);
            long endDij = System.nanoTime();
            double tempsDij = (endDij - startDij) / 1_000_000_000.0;

            System.err.println(depart + "  | " + arrivee + "  | "
                    + vBF.getValeur(arrivee) + "   | "
                    + vDij.getValeur(arrivee) + "   | "
                    + tempsBF + "    | "
                    + tempsDij);
        }
    }
}