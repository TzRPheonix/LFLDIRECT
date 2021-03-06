package com.example.myapplication.Modele;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(tableName = "Utilisateurs")
public class Utilisateurs {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "nom")
    private String nom;

    @ColumnInfo(name = "pseudo")
    private String pseudo;

    @ColumnInfo(name = "dateInscription")
    private String dateInscription;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "mdp")
    private String mdp;

    @ColumnInfo(name = "telephone")
    private String telephone;


    public Utilisateurs(String nom, String pseudo, String dateInscription, String email, String mdp, String telephone) {
        this.nom = nom;
        this.pseudo = pseudo;
        this.dateInscription = dateInscription;
        this.telephone = telephone;
        this.email = email;
        this.mdp = mdp;
    }

    public Utilisateurs(int id, String nom, String pseudo, String dateInscription, String email, String mdp, String telephone) {
        this.id = id;
        this.nom = nom;
        this.pseudo = pseudo;
        this.dateInscription = dateInscription;
        this.telephone = telephone;
        this.email = email;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Utilisateurs{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + pseudo + '\'' +
                ", dateInscription='" + dateInscription + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}