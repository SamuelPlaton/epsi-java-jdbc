package fr.epsi.jdbc;

import java.sql.*;

public class TestConnexionJDBC {

    public static void main(String[] args) {

        try{
            Connection connection = PersistenceManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM article");
            while(rs.next()){
                System.out.println(rs.getString("ref"));
            }
            rs.close();
            st.close();
            connection.close();

        } catch (SQLException throwables){
            System.out.println("Connexion échouée");
        }

    }
}
