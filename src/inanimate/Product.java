package inanimate;

import interfaces.Eatable;

import java.util.Objects;

public class Product {
    protected String name;
    protected int price;

    protected Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public static class Food extends Product implements Eatable{
        private int calories;
        public Food(String name, int price, int calories){
            super(name, price);
            this.calories = calories;
        }

        @Override
        public void eated(String name) {
            System.out.println(name+" употребил "+ this.name);
        }

        @Override
        public int getCalories() {
            return this.calories;
        }
    }

    public static class Uneatable extends Product{
        public Uneatable(String name, int price){
            super(name, price);
        }
    }
}
