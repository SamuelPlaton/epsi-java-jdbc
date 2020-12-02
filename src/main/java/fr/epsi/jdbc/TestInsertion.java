package fr.epsi.jdbc;

import java.sql.*;

public class TestInsertion {

    public static void main(String[] args) {

        try{
            Connection connection = PersistenceManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO FOURNISSEUR (ID, NOM) VALUES (10,'La Maison de la Peinture')");
            System.out.println("insertion réussie");
            rs.close();
            st.close();
            connection.close();

        } catch (SQLException throwables){
            System.out.println("insertion échouée");
        }

    }
}
