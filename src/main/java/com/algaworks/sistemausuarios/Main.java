package com.algaworks.sistemausuarios;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Usuarios-PU");

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.close();

        entityManagerFactory.close();
    }
}
