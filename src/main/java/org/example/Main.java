package org.example;

import org.example.models.Actor;
import org.example.models.Character;
import org.example.models.Network;
import org.example.models.Show;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {


//    An actor has many characters and has many shows through characters.
//    A character belongs to an actor and belongs to a show.
//    A show has many characters and has many actors through characters.
//    A show belongs to a network.
//    A network has many shows.

    //Actor --->* Character  -- OneToMany

    //Character ---> Actor   -- OneToOne
    //Character ---> Show    -- OneToOne

    //Show -->* Character    -- OneToMany

    //show --> Network    -- OneToOne
    //network --->* show  -- OneToMany


    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        Actor actor1 = new Actor();
        actor1.setFirst_name("Matt");
        actor1.setLast_name("Damon");

        Actor actor2 = new Actor();
        actor2.setFirst_name("Will");
        actor2.setLast_name("Smith");

        Character character1 = new Character();
        character1.setName("Jason Bourne");
        character1.setCatchprase("Will kill you all!!");

        Character character2 = new Character();
        character2.setName("Fresh Prince");
        character2.setCatchprase("Keep my wife's name out your freaking mouth!");

        Character character3 = new Character();
        character3.setName("Genie");
        character3.setCatchprase("Tell me your 3 wishes...");

        Character character4 = new Character();
        character4.setName("Mr.Ripley");
        character4.setCatchprase("I always thought it would be better to be a fake somebody than a real nobody");


        Show show1 = new Show();
        show1.setName("Aladdin");
        show1.setShowDay("Monday");


        Show show2 = new Show();
        show2.setName("Fresh Prince of Bel Air");
        show2.setShowDay("Tuesday");

        Show show3 = new Show();
        show3.setName("The Bourne Ultimatum");
        show3.setShowDay("Saturday");

        Network network1 = new Network();
        network1.setChannel(10);
        network1.setCall_letters("NBC");


        Network network2 = new Network();
        network2.setChannel(15);
        network2.setCall_letters("HBO");

        show1.setNetwork(network1);
        show2.setNetwork(network2);
        show3.setNetwork(network1);

        show1.getCharacters().add(character3);
        show2.getCharacters().add(character2);
        show3.getCharacters().add(character1);

        character1.setShow(show3);
        character2.setShow(show2);
        character3.setShow(show1);

        character1.setActor(actor1);
        character2.setActor(actor2);
        character3.setActor(actor2);
        character4.setActor(actor1);

        network1.getShows().add(show1);
        network1.getShows().add(show2);
        network2.getShows().add(show3);


        actor1.getCharacters().add(character1);
        actor1.getCharacters().add(character4);
        actor2.getCharacters().add(character2);
        actor2.getCharacters().add(character3);

        transaction.begin();

        entityManager.persist(actor1);
        entityManager.persist(actor2);

        entityManager.persist(character1);
        entityManager.persist(character2);
        entityManager.persist(character3);
        entityManager.persist(character4);

        entityManager.persist(show1);
        entityManager.persist(show2);
        entityManager.persist(show3);

        entityManager.persist(network1);
        entityManager.persist(network2);


        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}