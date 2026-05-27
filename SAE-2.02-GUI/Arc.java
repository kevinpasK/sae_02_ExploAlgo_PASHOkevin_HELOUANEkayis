public class Arc {
    private String noeud;
    private int poid;

    public Arc(String n, int p) {
        this.noeud = n;
        this.poid = p;
    }

    public String getNoeud() {
        return this.noeud;
    }

    public int getPoid() {
        return this.poid;
    }
    public String toString() {
        return this.noeud + "(" + this.poid + ")";
    }
}