package core;

import utils.Eatable;
import utils.FoodContainer;

import javax.lang.model.type.NullType;

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

    public String toString() {
        return "Стол";
    }
}
