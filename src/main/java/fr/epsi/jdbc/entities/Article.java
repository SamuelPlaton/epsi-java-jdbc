package fr.epsi.jdbc.entities;

public class Article {
    private int id;
    private String ref;
    private String designation;
    private double prix;
    private int id_fou;

    public Article(int id, String ref, String designation, double prix, int id_fou) {
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.id_fou = id_fou;
    }

    public int getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrix() {
        return prix;
    }

    public int getId_fou() {
        return id_fou;
    }
}
