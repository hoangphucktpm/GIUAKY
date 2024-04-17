package iuh.fit.dao;

import iuh.fit.entity.Ingredient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IngredientDao extends Remote {
    public List<Ingredient> findExpireDate() throws RemoteException;
    public boolean deleteIngredient(Ingredient ingredient) throws RemoteException;
}
