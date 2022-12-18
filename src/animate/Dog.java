package animate;

import interfaces.Scary;

import java.util.Objects;

public class Dog implements Scary {
    private class Muzzle{
        private String color;
        public Muzzle(String color){
            this.color = color;
            System.out.println("На собаку "+ Dog.this.name + " надели намордник цвета "+ this.color);
        }
    }
    private Muzzle muzzle;
    private String name;
    public Dog(String name){
        this.name = name;
    }

    public void getMuzzle(){
        this.muzzle = new Muzzle("Красный");
    }

    public String toString(){
        return "Собака "+this.name;
    }
    public void bark(){ System.out.println("Собака " + name + " гавкает");}

    @Override
    public boolean isScary(){
        return this.muzzle == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
