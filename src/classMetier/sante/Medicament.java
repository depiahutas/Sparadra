package classMetier.sante;

import classMetier.Util.CategorieMedicament;

public class Medicament {
    private String nom;
    private double prix;
    private String dateMES;
    private int quantite;
    private CategorieMedicament categorie;

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
        this.nom = nom;
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
        this.dateMES = dateMES;
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
        this.categorie = categorie;
    }
}
