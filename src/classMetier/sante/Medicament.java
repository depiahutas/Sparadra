package classMetier.sante;

import classMetier.Util.CategorieMedicament;

public class Medicament {
    private String nom;
    private double prix;
    private String dateMES;
    private int quantite;
    private CategorieMedicament categorie;

    /**
     * constructeur médicament
     * @param nom String (controle REGEX)
     * @param prix double (2 chiffres apres la virgule)
     * @param dateMES String (date format jj//mm/aaaa)
     * @param quantite int (controle par REGEX)
     * @param categorie Categorie
     */
    public Medicament(String nom, double prix, String dateMES, int quantite, CategorieMedicament categorie) {
        setNom(nom);
        setPrix(prix);
        setDateMES(dateMES);
        setQuantite(quantite);
        setCategorie(categorie);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null) {
            throw new NullPointerException("le nom ne peut etre null");
        } else {
            this.nom = nom;
        }
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
            this.prix = prix;

    }

    public String getDateMES() {
        return dateMES;
    }

    public void setDateMES(String dateMES) {
        if (dateMES==null){
            throw new NullPointerException("la date de mise en service ne peut etre null");
        }
        else {
            this.dateMES = dateMES;
        }
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public CategorieMedicament getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieMedicament categorie) {
        if (categorie==null){
            throw new NullPointerException("la categorie ne peut etre null");
        }
        else {
            this.categorie = categorie;
        }
    }
}
