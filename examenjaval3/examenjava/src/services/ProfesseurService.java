package services;

import java.util.List;


import entities.Profclasse;
import entities.Professeur;
import repositories.ProfesseurRepository;
import repositories.ProfClasseRepository;


public class ProfesseurService {
    ProfesseurRepository professeurRepository=new ProfesseurRepository();
    ProfClasseRepository ProfesseurClasseRepository=new ProfClasseRepository();

      public  void ajouterProfesseur(Professeur professeurs){
        //Transaction
         professeurRepository.insert(professeurs);
         List<Profclasse> profClasse = professeurs.getProfclasses();
         for (Profclasse pc  : profClasse) {
            ProfesseurClasseRepository.insert(pc);
         }

      }
    public void insertProfesseur(Professeur professeur) {
        professeurRepository.insert(professeur);
    }

    public List<Professeur>listerProfesseurs(){
      return professeurRepository.selectAll();
  }

   
}
