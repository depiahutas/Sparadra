package classMetier.personne;

import classMetier.Util.Adresse;
import classMetier.Util.Regex;
import classMetier.sante.Mutuelle;
import org.junit.platform.commons.function.Try;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Client extends Personne{
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

    /**
     *
     * @param nom
     * @param prenom
     * @param mail
     * @param tel
     * @param adresse
     * @param dateNaiss
     * @param medecin
     * @param mutuelle
     * @param numSecu
     */
    public Client(String nom, String prenom, String mail, String tel, Adresse adresse, String dateNaiss, Medecin medecin, Mutuelle mutuelle, String numSecu) {
        super(nom, prenom, mail, tel, adresse);
        setDateNaiss(dateNaiss);
        setMedecin(medecin);
        setMutuelle(mutuelle);
        setNumSecu(numSecu);

    }
}
