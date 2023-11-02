package classMetier.personne;

import classMetier.Util.Adresse;
import classMetier.Util.Specialite;

public class Specialiste extends Medecin{
    private Specialite specialite;

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Specialiste(int id,Personne personne, String numAgr, Specialite specialite) {
        super(id,personne, numAgr);
        setSpecialite(specialite);
    }
}
