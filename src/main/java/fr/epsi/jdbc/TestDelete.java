package fr.epsi.jdbc;

import java.sql.*;

public class TestDelete {

    public static void main(String[] args) {

        try{
            Connection connection = PersistenceManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("DELETE FROM FOURNISSEUR WHERE id = 10");
            System.out.println("delete réussie");
            rs.close();
            st.close();
            connection.close();

        } catch (SQLException throwables){
            System.out.println("insertion échouée");
        }

    }
}
