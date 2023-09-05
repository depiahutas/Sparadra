package classMetier.Util;

import java.util.regex.Pattern;

public class Adresse {
    private int numero;
    private String rue;
    private String codePostal;
    private String ville;

    /**
     *
     * @param numero
     * @param rue
     * @param codePostal
     * @param ville
     */
    public Adresse(int numero, String rue, String codePostal, String ville) {
        setNumero(numero);
        setRue(rue);
        setVille(ville);
        setCodePostal(codePostal);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero)throws IllegalArgumentException {
            if (Pattern.matches(Regex.getRegexNumeroAdresse(),""+numero)){
                this.numero = numero;
            }else {
                throw new IllegalArgumentException("Numéro adresse incorrecte");
            }
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue){
            if (Pattern.matches(Regex.getRegexNomAdresse(),rue)){
                this.rue = rue;
            }
            else{
                throw new IllegalArgumentException("Rue incorrecte");
            }
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal)throws IllegalArgumentException {

            if (Pattern.matches(Regex.getRegexCodePostal(),codePostal)) {
                this.codePostal = codePostal;
            }
            else {
                throw new IllegalArgumentException("code postal incorrecte");
            }
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville)throws IllegalArgumentException {

            if (Pattern.matches(Regex.getRegexVille(),ville))
            {
                this.ville = ville;
            }
            else {
                throw new IllegalArgumentException("ville incorrecte");
            }
    }
}
