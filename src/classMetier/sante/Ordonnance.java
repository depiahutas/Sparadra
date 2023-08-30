package classMetier.sante;

import classMetier.personne.Client;
import classMetier.personne.Medecin;

import java.util.ArrayList;
import java.util.Date;

public class Ordonnance {
    private Medecin medecin;
    private Client client;
    private ArrayList<Medicament> listMed;
    private Date date;

    public Ordonnance(Medecin medecin, Client client, ArrayList<Medicament> listMed, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getListMedToString() {
        return null;
    }
}
