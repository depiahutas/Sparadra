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

    /**
     * constructeur Ordonnance
     * @param medecin voir classe Medecin
     * @param client voir classe Client
     * @param listMed ArrayList<Medicament> (liste des medicament de l'ordonannce)
     * @param date String (date format jj/mm/aaaa)
     * @param id int (id ordonnance cache de l'utilisateur)
     */
    public Ordonnance(Medecin medecin, Client client, ArrayList<Medicament> listMed, String date, int id) {
        setId(id);
        setMedecin(medecin);
        setClient(client);
        setListMed(listMed);
        setDate(date);
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        if(medecin==null){
            throw new NullPointerException("le medecin ne peut etre null");
        }
        else {
            this.medecin = medecin;
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if(client==null){
            throw new NullPointerException("le nom ne peut etre null");
        }
        else {
            this.client = client;
        }
    }

    public ArrayList<Medicament> getListMed() {
        return listMed;
    }

    public void setListMed(ArrayList<Medicament> listMed) {
        if(listMed==null){
            throw new NullPointerException("le nom ne peut etre null");
        }
        else {
            this.listMed = listMed;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if(date==null){
            throw new NullPointerException("le nom ne peut etre null");
        }
        else {
            this.date = date;
        }
    }

    public String getListMedToString() {
        StringBuilder b= new StringBuilder();
        for (Medicament medicament:getListMed()){
            b.append(" | ").append(medicament.getNom());
        }

        return b.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
