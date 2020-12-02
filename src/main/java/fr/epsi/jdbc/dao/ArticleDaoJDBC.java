package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.PersistenceManager;
import fr.epsi.jdbc.entities.Article;
import fr.epsi.jdbc.entities.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoJDBC implements ArticleDao{
    public List<Article> extraire() {
        try{
            Connection connection = PersistenceManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM article");
            List<Article> list = new ArrayList<>();
            while(rs.next()){
                list.add(new Article(
                        rs.getInt("id"),
                        rs.getString("ref"),
                        rs.getString("designation"),
                        rs.getFloat("prix"),
                        rs.getInt("id_fou")
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

    public void insert(Article article) {
        try{
            Connection connection = PersistenceManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ARTICLE (ID, REF, DESIGNATION, PRIX, ID_FOU) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, article.getId());
            preparedStatement.setString(2, article.getRef());
            preparedStatement.setString(3, article.getDesignation());
            preparedStatement.setDouble(4, article.getPrix());
            preparedStatement.setInt(5, article.getId_fou());
            preparedStatement.executeQuery();
            System.out.println("insertion réussie");
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables){
            System.out.println("insertion échouée");
        }
    }

    public int update(String ref, double prix) {
        try{
            Connection connection = PersistenceManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ARTICLE SET prix = ? WHERE ref = ?");
            preparedStatement.setDouble(1, prix);
            preparedStatement.setString(2, ref);
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

    public boolean delete(Article article) {
        try{
            Connection connection = PersistenceManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ARTICLE WHERE id = ?");
            preparedStatement.setInt(1, article.getId());
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

    public Double getMoyennePrix(){
        try{
            Connection connection = PersistenceManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT AVG(PRIX) as moyenne FROM ARTICLE");
            while(rs.next()){
                return rs.getDouble("moyenne");
            }
            st.close();
            connection.close();
            return null;
        } catch (SQLException throwables){
            System.out.println("get moyenne échouée");
            return null;
        }
    }
}
