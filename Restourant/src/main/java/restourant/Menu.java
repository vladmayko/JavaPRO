package restourant;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by MacUser on 18.06.19.
 */

@Entity
@Table(name="Menu")
public class Menu {
    @Id
    private int id;

    @Column(length = 50)
    @NotNull
    private String dishName;

    @NotNull
    private double price;

    @NotNull
    private double weight;

    @NotNull
    private boolean discount;

    public Menu() {
    }

    public Menu(String dishName, double price, double weight, boolean discount) {
        this.dishName = dishName;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Menu[" + "id=" + id + ", dishName='" + dishName + '\'' + ", price=" +
                price + ", weight=" + weight + ", discount=" + discount + ']';
    }
}
