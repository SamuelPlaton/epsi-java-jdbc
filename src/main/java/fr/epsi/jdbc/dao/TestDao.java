package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entities.Article;
import fr.epsi.jdbc.entities.Fournisseur;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {

        // Test DAO Fournisseur
        /*FournisseurDaoJDBC fournisseur = new FournisseurDaoJDBC();
        List<Fournisseur> liste = fournisseur.extraire();
        System.out.println(liste);
        Fournisseur f1 = new Fournisseur(20, "La maison de la peinture");
        fournisseur.insert(f1);
        //fournisseur.update("Test", "NewTest");
        //fournisseur.delete(f1);*/

        ArticleDaoJDBC articleDAO = new ArticleDaoJDBC();
        // Test DAO Article
        /*
        List<Article> liste = articleDAO.extraire();
        System.out.println(liste);
        Article a1 = new Article(20, "Ref1", "test", 20.00, 2);
        //articleDAO.insert(a1);
        //articleDAO.update("Ref1", "Ref2");
        //articleDAO.delete(a1);*/

        // Insertion de 4 articles
        /*articleDAO.insert(new Article(80, "Ref1", "Peinture blanche 1L", 12.5, 20));
        articleDAO.insert(new Article(81, "Ref2", "Peinture rouge mate 1L", 15.5, 20));
        articleDAO.insert(new Article(82, "Ref3", "Peinture noire laquée 1L", 17.8, 20));
        articleDAO.insert(new Article(30, "Ref4", "Peinture bleue mate 1L", 15.5, 20));*/

        List<Article> liste = articleDAO.extraire();
        // Diminuer prix peinture bleue mate
        /*for(int i = 0; i < liste.size(); i++){
            Article newArticle = liste.get(i);
            if(newArticle.getDesignation().contains("mate")){
                articleDAO.update(newArticle.getRef(), newArticle.getPrix()*0.75);
            }
        }*/

        // Supprimer les éléments contenant 'peinture'
        /*for(int i = 0; i < liste.size(); i++){
            Article newArticle = liste.get(i);
            if(newArticle.getDesignation().toLowerCase().contains("peinture")){
                articleDAO.delete(newArticle);
            }
        }*/

        // Récupérer la moyenne du prix
        /*double moyenne = articleDAO.getMoyennePrix();
        System.out.println(moyenne+"€");*/
    }
}
