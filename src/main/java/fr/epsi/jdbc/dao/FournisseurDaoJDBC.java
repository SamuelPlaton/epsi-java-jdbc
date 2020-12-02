package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.PersistenceManager;
import fr.epsi.jdbc.entities.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJDBC implements FournisseurDao{
    public List<Fournisseur> extraire() {
        try{
            Connection connection = PersistenceManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fournisseur");
            List<Fournisseur> list = new ArrayList<>();
            while(rs.next()){
                list.add(new Fournisseur(
                        rs.getInt("id"),
                        rs.getString("nom")
                ));
            }
            rs.close();
            st.close();
            connection.close();
            return list;

        } catch (SQLException throwables){
            System.out.println("Connexion échouée");
            return null;
        }
    }

    public void insert(Fournisseur fournisseur) {
        try{
            Connection connection = PersistenceManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FOURNISSEUR (ID, NOM) VALUES (?,?)");
            preparedStatement.setInt(1, fournisseur.getId());
            preparedStatement.setString(2, fournisseur.getNom());
            preparedStatement.executeQuery();
            System.out.println("insertion réussie");
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables){
            System.out.println("insertion échouée");
        }
    }

    public int update(String ancienNom, String nouveauNom) {
        try{
            Connection connection = PersistenceManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE FOURNISSEUR SET nom = ? WHERE nom = ?");
            preparedStatement.setString(1, nouveauNom);
            preparedStatement.setString(2, ancienNom);
            preparedStatement.executeUpdate();
            System.out.println("update réussie");
            preparedStatement.close();
            connection.close();
            return 1;

        } catch (SQLException throwables){
            System.out.println("update échouée");
            return 0;
        }
    }

    public boolean delete(Fournisseur fournisseur) {
        try{
            Connection connection = PersistenceManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE id = ?");
            preparedStatement.setInt(1, fournisseur.getId());
            preparedStatement.executeUpdate();
            System.out.println("delete réussie");
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException throwables){
            System.out.println("delete échouée");
            return false;
        }
    }

}
