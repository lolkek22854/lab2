package core;

import utils.Eatable;
import utils.FoodContainer;

//import javax.lang.model.type.NullType;
import java.util.Arrays;
import java.util.Objects;

public class Tray implements FoodContainer {
    private boolean containsFood = false;
    private Eatable[] foodContainer;

    @Override
    public void putFood(Eatable[] food) {
        foodContainer = food;
        containsFood = true;
    }

    @Override
    public Eatable[] removeFood() {
        if (containsFood) {
            return foodContainer;
        } else {
            System.out.println("Поднос пустой!");
            Eatable[] empty = {};
            return empty;
        }
    }
    @Override
    public String toString() {
        return "Стол";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tray tray = (Tray) o;
        return containsFood == tray.containsFood && Arrays.equals(foodContainer, tray.foodContainer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(containsFood);
        result = 31 * result + Arrays.hashCode(foodContainer);
        return result;
    }
}
