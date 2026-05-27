import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LireReseau {

    public static Graphe lire(String fichier_stations, String fichier_connexions) {
        GrapheListe g = new GrapheListe();

        try (BufferedReader br = new BufferedReader(new FileReader(fichier_stations))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.isBlank()) {
                    continue;
                }
                String[] champs = ligne.split(";");
                String id = champs[0];
                g.ajouterNoeud(id);
            }
        } catch (IOException e) {
            System.out.println("Erreur lecture des arrêts  " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fichier_connexions))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.isBlank()) {
                    continue;
                }
                String[] champs = ligne.split(";");
                String depart = champs[0];
                String arrivee = champs[1];
                int distance = (int) Double.parseDouble(champs[2]);

                g.ajouterArc(depart, arrivee, distance);
                g.ajouterArc(arrivee, depart, distance);
            }
        } catch (IOException e) {
            System.out.println("Erreur lecture des connexions " + e.getMessage());
        }

        return g;
    }
}