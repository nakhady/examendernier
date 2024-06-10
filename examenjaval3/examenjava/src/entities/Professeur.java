package entities;

import java.util.ArrayList;
import java.util.List;

public class Professeur {
    private int id;
    private int nci;
    private String nomComplet;
    private String grade;

    List<Classe>classes;
    List<Profclasse>  profs;

    private List<Profclasse>profclasses=new ArrayList<>();
    
    
    public Professeur() {
    }

    public List<Profclasse> getProfclasses() {
        return profclasses;
    }

    public void setProfclasses(List<Profclasse> profclasses) {
        this.profclasses = profclasses;
    }

    public int getNci() {
        return nci;
    }

    public void setNci(int nci) {
        this.nci = nci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
