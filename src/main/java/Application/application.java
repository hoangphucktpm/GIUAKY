package Application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLdb");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }
}
