package classMetier.Util;

import classMetier.sante.Medicament;

import java.util.ArrayList;
import java.util.Objects;

public class Panier {
    private int id;
    private ArrayList<Medicament> resumePanier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Medicament> getResumePanier() {
        return resumePanier;
    }

    public void setResumePanier(ArrayList<Medicament> resumePanier) {
        this.resumePanier = resumePanier;
    }

    public Panier(int id, ArrayList<Medicament> resumePanier) {
        this.id = id;
        this.resumePanier = resumePanier;
    }
}
