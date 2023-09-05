package classMetier.Util;

import classMetier.personne.Client;
import classMetier.sante.Medicament;
import classMetier.sante.Ordonnance;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Achat {
    private Client client;
    private ArrayList<Medicament> listMed;
    private double prix;
    private String date;

    private Ordonnance ordonnance;

    public Achat(Client client, ArrayList<Medicament> listMed, double prix, String date, Ordonnance ordonnance) {
        setClient(client);
        setListMed(listMed);
        setPrix(prix);
        setDate(date);
        setOrdonnance(ordonnance);
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date)throws IllegalArgumentException {
        if (Pattern.matches(Regex.getRegexDate(),date)){
            this.date = date;
        }
        else {
            throw new IllegalArgumentException("date incorrecte");
        }
    }

    public Ordonnance getOrdonnance() {
            return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }
}
