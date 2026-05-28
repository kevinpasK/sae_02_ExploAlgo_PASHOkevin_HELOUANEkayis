import java.util.List;

public class MainDijkstra {

    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        String depart = "A";
        String arrivee = "C";

        Dijkstra dijkstra = new Dijkstra();
        Valeurs valeurs = dijkstra.resoudre(g, depart);

        System.out.println("valeurs depuis " + depart);
        System.out.print(valeurs);

        List<String> chemin = valeurs.calculerChemin(arrivee);
        System.out.println("plus court chemin de " + depart + " a " + arrivee + "," + chemin);
        System.out.println("cout total " + valeurs.getValeur(arrivee));
    }
}