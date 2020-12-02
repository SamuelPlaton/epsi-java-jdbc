package fr.epsi.jdbc;

import fr.epsi.jdbc.entities.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestSelect {

    public static void main(String[] args) {

        try{
            Connection connection = PersistenceManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fournisseur");
            List<Fournisseur> list = new ArrayList<>();
            while(rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nom"));
                list.add(new Fournisseur(
                        rs.getInt("id"),
                        rs.getString("nom")
                ));
            }
            rs.close();
            st.close();
            connection.close();

            list.forEach( System.out::println );

        } catch (SQLException throwables){
            System.out.println("Connexion échouée");
        }

    }
}
