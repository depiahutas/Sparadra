package classMetier.personne;

import classMetier.Util.Adresse;
import classMetier.sante.Mutuelle;

import java.util.ArrayList;
import java.util.Date;

public class Client extends Personne{
    private String dateNaiss;
    private String numSecu;
    private Mutuelle mutuelle;
    private Medecin medecin;
    private ArrayList<Specialiste> listSpecialiste;

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    public Mutuelle getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(Mutuelle mutuelle) {
        this.mutuelle = mutuelle;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public ArrayList<Specialiste> getListSpecialiste() {
        return listSpecialiste;
    }

    public void setListSpecialiste(ArrayList<Specialiste> listSpecialiste) {
        this.listSpecialiste = listSpecialiste;
    }

    public Client(String nom, String prenom, String mail, String tel, Adresse adresse, String dateNaiss, Medecin medecin, Mutuelle mutuelle, String numSecu) {
        super(nom, prenom, mail, tel, adresse);
        setDateNaiss(dateNaiss);
        setMedecin(medecin);
        setMutuelle(mutuelle);
        setNumSecu(numSecu);

    }
}
