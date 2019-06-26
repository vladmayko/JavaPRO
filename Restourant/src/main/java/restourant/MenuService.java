package restourant;

/**
 * Created by MacUser on 19.06.19.
 */
public interface MenuService {
    void viewMenu();

    void createDish(String name, double price, double weight, boolean discount);

    void deleteDish(int id);

    void updateDish(int id, String newName, double newPrice, double newWeight, boolean newDiscount);

    void getDishesCostFromTo(double priceFrom, double priceTo);

    void getDishesWithDiscount();

    void getSetRandomDishesNotMoreOneKilogram();

}
