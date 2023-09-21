package classMetier.personne;

import classMetier.Util.Adresse;
import classMetier.Util.Regex;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Medecin extends Personne{
    private String numAgr;
    private ArrayList<Client> listPatient;

    public String getNumAgr() {
        return numAgr;
    }

    public void setNumAgr(String numAgr)throws IllegalArgumentException {
        if(Pattern.matches(Regex.getRegexAgr(),numAgr)){
            this.numAgr = numAgr;
        }
        else {
            throw new IllegalArgumentException("Numéro d'agrément incorrecte");
        }
    }

    public ArrayList<Client> getListPatient() {
        return listPatient;
    }

    public void setListPatient(ArrayList<Client> listPatient) {
        this.listPatient = listPatient;
    }

    /**
     *
     * @param nom voir classe Personne
     * @param prenom voir classe Personne
     * @param mail voir classe Personne
     * @param tel voir classe Personne
     * @param adresse Adresse
     * @param numAgr String ( controle par REGEX)
     */
    public Medecin(String nom, String prenom, String mail, String tel, Adresse adresse, String numAgr) {
        super(nom, prenom, mail, tel, adresse);
        setNumAgr(numAgr);
    }
}
