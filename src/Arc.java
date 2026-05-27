public class Arc {

    private String noeud;
    private double poid;
    /**
     * cree un arc vers un noeud avec un poids
     * @param noeud le noeud d'arrivee
     * @param poid le poids de l'arc
     */
    public Arc(String noeud, double poid) {
        this.noeud = noeud;
        this.poid = poid;
    }

    /**
     * @return le noeud d'arrivee
     */
    public String getNoeud() {
        return this.noeud;
    }

    /**
     * @return le poids de l'arc
     */
    public double getPoid() {
        return this.poid;
    }

    public String toString() {
        return this.noeud + "(" + this.poid + ")";
    }
}