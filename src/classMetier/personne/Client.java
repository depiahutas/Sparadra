package classMetier.personne;

import classMetier.Util.Adresse;
import classMetier.Util.Regex;
import classMetier.sante.Mutuelle;
import org.junit.platform.commons.function.Try;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Client extends Personne{
    private int idClient;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    private String dateNaiss;
    private String numSecu;
    private Mutuelle mutuelle;
    private Medecin medecin;
    private ArrayList<Specialiste> listSpecialiste;


    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss)throws IllegalArgumentException {
            if (Pattern.matches(Regex.getRegexDateNaiss(), dateNaiss)) {

                this.dateNaiss = dateNaiss;
            }
             else {
                 throw new IllegalArgumentException("date de naissance incorrecte");
            }
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu)throws IllegalArgumentException {
            if (Pattern.matches(Regex.getRegexNumSecu(),numSecu)){
                this.numSecu = numSecu;
            }
            else{
                throw new IllegalArgumentException("Numéro de sécurité sociale incorrecte");
            }
    }

    public Mutuelle getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(Mutuelle mutuelle) {
            if (mutuelle == null) {
                throw new NullPointerException("la mutuelle ne peut etre null");
            } else {
                this.mutuelle = mutuelle;
            }
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        if (medecin==null){
            throw new NullPointerException("le medecin ne peut etre null");
        }
        else {
            this.medecin = medecin;
        }
    }

    public ArrayList<Specialiste> getListSpecialiste() {
        return listSpecialiste;
    }

    public void setListSpecialiste(ArrayList<Specialiste> listSpecialiste) {
        this.listSpecialiste = listSpecialiste;
    }

    /**
     * constructeur client
     * @param nom voir classe Personne
     * @param prenom voir classe Personne
     * @param mail voir classe Personne
     * @param tel voir classe Personne
     * @param adresse voir classe Personne
     * @param dateNaiss String (Date au format jj/mm/aaaa, controle par REGEX)
     * @param medecin Medecin
     * @param mutuelle Mutuelle
     * @param numSecu String (controle REGEX)
     */
    public Client(int id,String nom, String prenom, String mail, String tel, Adresse adresse, String dateNaiss, Medecin medecin, Mutuelle mutuelle, String numSecu) {
        super(nom, prenom, mail, tel, adresse);
        setIdClient(id);
        setDateNaiss(dateNaiss);
        setMedecin(medecin);
        setMutuelle(mutuelle);
        setNumSecu(numSecu);

    }

    public void updateClient(String nom, String prenom, String mail, String tel, Adresse adresse, String dateNaiss, Medecin medecin, Mutuelle mutuelle, String numSecu){
    this.setNom(nom);
    this.setPrenom(prenom);
    this.setMail(mail);
    this.setTel(tel);
    this.setAdresse(adresse);
    this.setDateNaiss(dateNaiss);
    this.setMedecin(medecin);
    this.setMutuelle(mutuelle);
    this.setNumSecu(numSecu);
    }
}
