package classMetier.personne;

import classMetier.Util.Adresse;

import java.util.ArrayList;

public class Medecin extends Personne{
    private int numAgr;
    private ArrayList<Client> listPatient;

    public int getNumAgr() {
        return numAgr;
    }

    public void setNumAgr(int numAgr) {
        this.numAgr = numAgr;
    }

    public ArrayList<Client> getListPatient() {
        return listPatient;
    }

    public void setListPatient(ArrayList<Client> listPatient) {
        this.listPatient = listPatient;
    }

    public Medecin(String nom, String prenom, String mail, String tel, Adresse adresse,int numAgr) {
        super(nom, prenom, mail, tel, adresse);
        setNumAgr(numAgr);
    }
}
