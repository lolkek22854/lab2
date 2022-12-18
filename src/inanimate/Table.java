package inanimate;

import exceptions.EmptyTableException;
import interfaces.Eatable;
import interfaces.FoodContainer;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Stack;

public class Table implements FoodContainer {

    //    private Eatable[] food = new Eatable[10];
    private Stack<Eatable> foodContainer = new Stack<>();

    public boolean hasFood(){
        return !foodContainer.isEmpty();
    }

    public Eatable eatFood() throws EmptyTableException{
        try {
            return foodContainer.pop();
        } catch (EmptyStackException e){
            throw new EmptyTableException();
        }
    }

    @Override
    public void putFood(Eatable[] food) {
        System.out.println("На стол ставят: ");
        for (Eatable f : food) {
            foodContainer.push(f);
            System.out.println(f.toString());
        }
    }

    @Override
    public Eatable[] removeFood() {
        System.out.println("Со стола убрали " + foodContainer.pop().toString());
        Eatable[] empty = {};
        return empty;
    }
    @Override
    public String toString() {
        return "Поднос";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(foodContainer, table.foodContainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodContainer);
    }
}
