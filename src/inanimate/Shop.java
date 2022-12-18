package inanimate;

import java.util.*;

public class Shop {
    private String name;
    private ArrayList<Product> catalog = new ArrayList<Product>();

    public Shop(String name){
        this.name = name;
    }

    public void addToCatalog(Product[] catalog){
        this.catalog.addAll(Arrays.asList(catalog));
    }

    public Product buyProduct(){
        return this.catalog.get(new Random().nextInt(catalog.size()));
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) && Objects.equals(catalog, shop.catalog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catalog);
    }
}
