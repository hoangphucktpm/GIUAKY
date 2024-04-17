package iuh.fit.dao.impl;

import iuh.fit.dao.itemDao;
import iuh.fit.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class itemImpl extends UnicastRemoteObject implements itemDao {
    private EntityManager em;

    public itemImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLdb").createEntityManager();
    }

    @Override
    public List<Item> listItems(String name) throws RemoteException {
//        @NamedQuery(name = "Item.findItemBySpecialAndSupplierName", query = "SELECT i FROM Item i INNER JOIN i.ingredients ig INNER JOIN ig.suppliers s WHERE i.onSpecial = :onSpecial and s.name = :name"),
        return em.createNamedQuery("Item.findItemBySpecialAndSupplierName", Item.class)
                .setParameter("onSpecial", true)
                .setParameter("name", name)
                .getResultList();
    }
}
