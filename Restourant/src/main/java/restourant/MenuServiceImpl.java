package restourant;

import com.sun.tools.corba.se.idl.ExceptionEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Created by MacUser on 19.06.19.
 */
public class MenuServiceImpl implements MenuService{
    private EntityManager em = Persistence.createEntityManagerFactory("JPATest").createEntityManager();

    public MenuServiceImpl() {
    }

    @Override
    public void viewMenu(){
        Query query = em.createQuery("SELECT m FROM Menu m", Menu.class);
        List<Menu> list = (List<Menu>) query.getResultList();
        for (Menu m : list) System.out.println(m);
        System.out.println();
    }

    @Override
    public void createDish(String name, double price, double weight, boolean discount){
        em.getTransaction().begin();
        try {
            if(!name.equals("")) {
                em.persist(new Menu(name, price, weight, discount));
                em.getTransaction().commit();
            } else throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteDish(int id){
        Menu m = em.find(Menu.class, id);
        if(m == null){
            System.out.println("ERROR: Dish is not exist!");
            return;
        }

        em.getTransaction().begin();
        try{
            em.remove(m);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void updateDish(int id, String newName, double newPrice, double newWeight, boolean newDiscount){
        Menu m = em.find(Menu.class, id);

        if(m == null) {
            System.out.println("ERROR: Dish is not exist!");
            return;
        }

        em.getTransaction().begin();
        try {
            if(!newName.equals("")) {
                m.setDishName(newName);
                m.setPrice(newPrice);
                m.setWeight(newWeight);
                m.setDiscount(newDiscount);
                em.getTransaction().commit();
            } else throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    @Override
    public void getDishesCostFromTo(double priceFrom, double priceTo){
        Query query = em.createQuery("SELECT m FROM Menu m WHERE m.price BETWEEN :priceFrom AND :priceTo", Menu.class);
        query.setParameter("priceFrom", priceFrom);
        query.setParameter("priceTo", priceTo);
        List<Menu> list = (List<Menu>) query.getResultList();
        for (Menu m : list) System.out.println(m);
        System.out.println();
    }

    public void getDishesWithDiscount(){
        Query query = em.createQuery("SELECT m FROM Menu m WHERE m.discount = true");
        List<Menu> list = (List<Menu>) query.getResultList();
        for (Menu m : list) System.out.println(m);
        System.out.println();
    }

    @Override
    public void getSetRandomDishesNotMoreOneKilogram(){
        Query query = em.createQuery("SELECT m FROM Menu m");
        List<Menu> list = (List<Menu>) query.getResultList();
        Random random = new Random();
        List<Menu> resMenu = new ArrayList<>();
        double weight = 0;
        for (;weight <= 1000;) {
            int i = random.nextInt(list.size());
            resMenu.add(list.get(i));
            weight += list.get(i).getWeight();
            if(weight > 1000){
                weight -= resMenu.get(resMenu.size()-1).getWeight();
                resMenu.remove(resMenu.size()-1);
                break;
            }
        }

        for (Menu m : resMenu) System.out.println(m);
        System.out.println("Total weight = " + weight);
        System.out.println();
    }
}
