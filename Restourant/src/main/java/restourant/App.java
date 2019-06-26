package restourant;

public class App {
    public static void main( String[] args ) {
        MenuService menuService = new MenuServiceImpl();

        //add dish to menu
        //menuService.createDish("Black tea", 30, 150, false);
        menuService.viewMenu();


        //delete dish from menu
        //menuService.deleteDish(8);
        menuService.viewMenu();

        //update dish from menu
        menuService.updateDish(10, "Roll green dragon", 215, 250, false);
        menuService.viewMenu();



        menuService.getDishesCostFromTo(100, 180);

        menuService.getDishesWithDiscount();

        menuService.getSetRandomDishesNotMoreOneKilogram();
        menuService.getSetRandomDishesNotMoreOneKilogram();
        menuService.getSetRandomDishesNotMoreOneKilogram();
    }
}
