package entities;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private int id;
    private String libelle;
    private String filiere;
    private String niveau;
    

    List<Professeur>  professeurs =new ArrayList<>();
    List<Inscription>  inscriptions;
    List<Profclasse>  profs;


    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }


    public Classe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public String setFiliere(String string){
        return filiere;
    }
    

    public String getFiliere() {
        return filiere;
    }

    
    
}
