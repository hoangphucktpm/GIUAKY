package iuh.fit.dao.impl;

import iuh.fit.dao.IngredientDao;
import iuh.fit.entity.Food;
import iuh.fit.entity.Ingredient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

public class ingredientImpl extends UnicastRemoteObject implements IngredientDao {
    private EntityManager em;

    public ingredientImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLdb").createEntityManager();
    }
    @Override
    public List<Ingredient> findExpireDate() throws RemoteException {
        List<Ingredient> expiredIngredients = em.createNamedQuery("Ingredient.findByExpiryDate", Ingredient.class)
                .setParameter("currentDate", LocalDate.now())
                .getResultList();
        return expiredIngredients;
    }

    public boolean deleteIngredient(Ingredient ingredient) throws RemoteException {
        try {
            // Begin transaction
            em.getTransaction().begin();

            // Find and remove all references in the 'Food' table
            List<Food> foods = em.createQuery("SELECT f FROM Food f JOIN f.ingredients i WHERE i.id = :ingredientId", Food.class)
                    .setParameter("ingredientId", ingredient.getId())
                    .getResultList();
            for (Food food : foods) {
                food.getIngredients().remove(ingredient);
                em.merge(food);
            }

            // Remove the ingredient
            em.remove(em.contains(ingredient) ? ingredient : em.merge(ingredient));

            // Commit transaction
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            // Rollback transaction in case of an error
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }


}
