package com.algaworks.sistemausuarios;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class ExportarDDL {

    public static void main(String[] args) {
        Map<String, String> propriedades = new HashMap<>();


        propriedades.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
        propriedades.put("javax.persistence.schema-generation.scripts.create-target", "C:/Users/algaw/Desktop/script-criacao.sql");
        propriedades.put("javax.persistence.schema-generation.scripts.drop-target", "C:/Users/algaw/Desktop/script-remocao.sql");

        propriedades.put("javax.persistence.schema-generation.create-source", "metadata-then-script");
        propriedades.put("javax.persistence.schema-generation.drop-source", "metadata-then-script");
        propriedades.put("javax.persistence.schema-generation.create-script-source", "META-INF/banco-de-dados/script-criacao.sql");
        propriedades.put("javax.persistence.schema-generation.drop-script-source", "META-INF/banco-de-dados/script-remocao.sql");
        propriedades.put("javax.persistence.sql-load-script-source", "META-INF/banco-de-dados/carregar-dados.sql");

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Usuarios-PU", propriedades);

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.close();

        entityManagerFactory.close();
    }
}
