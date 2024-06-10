import java.util.List;
import java.util.Scanner;

import entities.Classe;
import entities.Profclasse;
import entities.Professeur;
import services.ClasseService;
import services.ProfesseurService;

public class ResponsablePegagogiqueView {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc = new Scanner(System.in);
        ClasseService classeService= new ClasseService();
        ProfesseurService professeurService= new ProfesseurService();
        do{
            System.out.println("1-Ajouter une classe");
            System.out.println("2-Lister les classes");
            System.out.println("3-Ajouter des professeurs");
            System.out.println("4-Lister les professeurs");
            System.out.println("5-Filtrer les classes d'un professeur");
            choix=sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                System.out.println("Entrez le niveau de la classe(L1, L2, L3)");
                String niveau=sc.nextLine();
                System.out.println("Entrez la filière de la classe");
                String filiere=sc.nextLine();
                Classe cl= new Classe();
                cl.setNiveau(niveau);
                cl.setFiliere(filiere);
                classeService.ajouterClasse(cl);
                System.out.println("Classe ajoutée avec succés");


                    break;
                case 2:
                List<Classe> listerClasses=classeService.ListerClasse();
                for(Classe c: listerClasses){
                    System.out.println("id: "+c.getId());
                    System.out.println("niveau: "+c.getNiveau());
                    System.out.println("filiere: "+c.getFiliere());
                    System.out.println("******************************");
                }

                    break;

                case 3:
                Professeur professeur=new Professeur();
                  System.out.println("Entrer le nci");
                  professeur.setNci(sc.nextInt());
                  sc.nextLine();
                  System.out.println("Entrer le nom complet");
                  professeur.setNomComplet(sc.nextLine());
                  System.out.println("Entrer le grade");
                  professeur.setGrade(sc.nextLine());

                    listerClasses = classeService.ListerClasse();
                    int response;
                    do {
                        for (Classe c : listerClasses) {
                            System.out.println(c.getNiveau()+"-"+c.getFiliere());
                          }
                         System.out.println("Veuillez selectionner la classe à laquelle vous voulez affecter");
                          int idClasse=sc.nextInt(); 
                          cl= classeService.findClasseById(idClasse);
                          if (listerClasses!=null) {
                            Profclasse profclasse=new Profclasse();
                            professeur.getProfclasses().add(profclasse);

                          }else{
                             System.out.println("Cet Id n'existe pas");
                          } 
                         
                         System.out.println("Voulez continuez 1-Oui 2-Non"); 
                         response=sc.nextInt(); 
                       
                    } while (response==1);

                    if (professeur.getProfclasses().size()==0) {
                        professeurService.ajouterProfesseur(professeur);
                         
                    }else{
                             
                    }        
                  
              break;

                 case 4:
                  List<Professeur> listerProfesseurs=professeurService.listerProfesseurs();
                  for(Professeur p: listerProfesseurs){
                      System.out.println("id: "+p.getId());
                      System.out.println("numéro de carte d'identité: "+p.getNci());
                      System.out.println("nom complet: "+p.getNomComplet());
                      System.out.println("grade: "+p.getGrade());
                      System.out.println("******************************");
                  }

                    
                default:
                    break;
            }
        }while(choix!=5);
    }
}

    
    

