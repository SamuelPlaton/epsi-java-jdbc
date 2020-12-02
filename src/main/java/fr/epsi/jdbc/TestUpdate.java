package fr.epsi.jdbc;

import java.sql.*;

public class TestUpdate {

    public static void main(String[] args) {

        try{
            Connection connection = PersistenceManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("UPDATE FOURNISSEUR SET nom = 'La maison des peintures' WHERE id = 10");
            System.out.println("update réussie");
            rs.close();
            st.close();
            connection.close();

        } catch (SQLException throwables){
            System.out.println("insertion échouée");
        }

    }
}
