package repositories;

import java.sql.SQLException;

import entities.Profclasse;

public class ProfClasseRepository extends Database {
    private final String SQL_INSERT_PROFESSEUR_CLASSE = "INSERT INTO `professeur_classe `(`id`,`id_pr`, `id_cl`) VALUES (?,?,?)";
    public void insert(Profclasse  profClasse){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT_PROFESSEUR_CLASSE);
             statement.setInt(1,profClasse.getId());
             statement.setInt(2,profClasse.getProfesseur().getId());
             statement.setInt(3,profClasse.getClasse().getId());
             executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    } 
    
}
