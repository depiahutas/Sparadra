package classMetier.sante;

import classMetier.personne.Client;
import classMetier.personne.Medecin;

import java.util.ArrayList;

public class Ordonnance {
    private int id;
    private Medecin medecin;
    private Client client;
    private ArrayList<Medicament> listMed;
    private String date;

    public Ordonnance(Medecin medecin, Client client, ArrayList<Medicament> listMed, String date, int id) {
        this.id = id;
        setMedecin(medecin);
        setClient(client);
        setListMed(listMed);
        setDate(date);
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Medicament> getListMed() {
        return listMed;
    }

    public void setListMed(ArrayList<Medicament> listMed) {
        this.listMed = listMed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getListMedToString() {
        String b="";
        for (Medicament medicament:getListMed()){
            b=b+" | "+medicament.getNom();
        }

        return b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
