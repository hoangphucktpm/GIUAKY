package iuh.fit.dao.impl;

import iuh.fit.dao.foodDao;
import iuh.fit.entity.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class foodImpl extends UnicastRemoteObject implements foodDao {
    private EntityManager em;

    public foodImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLdb").createEntityManager();
    }
    @Override
    public boolean addFood(Food food) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.persist(food);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<Food> getAllFood() throws RemoteException {
        return em.createNamedQuery("Food.findAll", Food.class).getResultList();
    }

    @Override
    public List<Food> getListServingFood() throws RemoteException {
        return em.createNamedQuery("Food.findFoodWithMaxServingTime", Food.class).getResultList();
    }
}
