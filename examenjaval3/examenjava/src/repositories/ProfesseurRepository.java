package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Professeur;

public class ProfesseurRepository extends Database {
    private final String SQL_INSERT_PROFESSEUR = "INSERT INTO professeur ( `nci`, `nomComplet`, `grade`) VALUES ( ?, ?, ?)";
    private final String SQL_LAST_VALUE_INSERT="SELECT Max(`id_pr`) as max FROM `professeur`";
    private final String SQL_SELECT_PROFESSEUR="select * from professeur";

    // Méthode pour insérer un professeur
    public void insert(Professeur professeur) {
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_INSERT_PROFESSEUR);
            statement.setInt(2, professeur.getNci());
            statement.setString(3, professeur.getNomComplet());
            statement.setString(4, professeur.getGrade());
            executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

     public  Professeur selectLastProfesseur(){
        Professeur professeur=null;
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_LAST_VALUE_INSERT);
     
            ResultSet rs = executeSelect();
            while (rs.next()) {
                professeur=new Professeur(); 
                professeur.setId(rs.getInt("max")); 
             
            }
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return professeur;
      }
    
      public List <Professeur> selectAll(){
        List <Professeur> professeurs= new ArrayList<>();
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_PROFESSEUR);
            ResultSet rs= executeSelect();
            while(rs.next()){
                Professeur professeur=new Professeur();
                professeur.setId(rs.getInt("id"));
                professeur.setNci(rs.getInt("nci"));
                professeur.setNomComplet(rs.getString("nomComplet"));
                professeur.setGrade(rs.getString("grade"));
                professeurs.add(professeur);
            }
            rs.close();
            fermerConnexion();
        }
        catch(SQLException e){
            System.out.println("Erreur de connexion a la BD");
        }
        return professeurs;

    }


    
}
