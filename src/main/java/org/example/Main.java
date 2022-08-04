package org.example;

import org.example.Models.Game;
import org.example.Models.Reviews;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();


        // Your code here
        Reviews review1 = new Reviews();
        Reviews review2 = new Reviews();
        Reviews review3 = new Reviews();

        review1.setScore(1);
        review2.setScore(2);
        review3.setScore(3);

        review1.setComment("Cool!");
        review2.setComment("Sucks");
        review3.setComment("bad");

        review1.setCreated_at(new Date());
        review2.setCreated_at(new Date());
        review3.setCreated_at(new Date());




        Game newGame = new Game();
        newGame.setCreated_at(new Date());

        newGame.setTitle("The Adventures of Catman");
        newGame.setGenre("Adventure");
        newGame.setPlatform("Gameboy color");
        newGame.setPrice(100);

        // Set Association b/w review to game
        review1.setGame(newGame);
        review2.setGame(newGame);
        review3.setGame(newGame);

        // Transactions
        transaction.begin();
        entityManager.persist(review1);
        entityManager.persist(review2);
        entityManager.persist(review3);

        entityManager.persist(newGame);
        transaction.commit();


        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}