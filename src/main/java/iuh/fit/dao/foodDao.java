package iuh.fit.dao;

import iuh.fit.entity.Food;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface foodDao extends Remote{
    public boolean addFood(Food food) throws RemoteException;
    public List<Food> getAllFood() throws RemoteException;
    public List<Food> getListServingFood() throws RemoteException;
}
