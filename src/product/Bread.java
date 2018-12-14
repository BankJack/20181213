package product;

import java.util.Objects;

/**
 * 面包
 */
public class Bread implements Cloneable{
    private String name;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bread bread = (Bread) o;
        return Double.compare(bread.price, price) == 0 &&
                Objects.equals(name, bread.name);
    }

    @Override
    protected Bread clone() throws CloneNotSupportedException {
        Bread bread = (Bread) super.clone();//浅克隆
        bread.setName(new String(bread.getName()));//深克隆
        return bread;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Bread{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Bread() {
    }

    public Bread(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
