package Server;

import iuh.fit.dao.IngredientDao;
import iuh.fit.dao.foodDao;
import iuh.fit.dao.impl.foodImpl;
import iuh.fit.dao.impl.ingredientImpl;
import iuh.fit.dao.impl.itemImpl;
import iuh.fit.dao.itemDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class server {
    private static final String URL = "rmi://192.168.1.2:2951/";

    public static void main(String[] args) {
        try {
                    Context context = new InitialContext();

                    itemDao a = new itemImpl();
                    foodDao b = new foodImpl();
                    IngredientDao c = new ingredientImpl();
                    LocateRegistry.createRegistry(2951);

                    context.bind(URL + "item", a);
                    context.bind(URL + "food", b);
                    context.bind(URL + "ingredient", c);
                    System.out.println("Server is running...");

                } catch (Exception e) {
                    throw new RuntimeException(e);
        }
    }

}
