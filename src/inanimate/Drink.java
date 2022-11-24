package inanimate;

import interfaces.Eatable;

import java.util.Objects;

public class Drink implements Eatable {
    private String name;
    public Drink(String name){this.name = name;}
    @Override
    public int getCalories(){return 0;}

    @Override
    public void eated(String user) {
        System.out.println(user+" выпивает "+name);
    }

    @Override
    public String toString(){return name;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Objects.equals(name, drink.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
