package core;

import utils.Eatable;

import java.util.Objects;

public class Food implements Eatable {
    //    private int calories;
    private String name;

    public Food(String name) {
        this.name = name;
    }

    @Override
    public void eated(String user) {
        System.out.println(user + " поедает " + name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return name.equals(food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
