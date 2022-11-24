package core;

import java.util.Objects;

public abstract class Character {
    protected String name;
    protected int age;
    public Character(String name, int age){
        System.out.println("Персонаж "+ name+ " появляется");
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return age == character.age && Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
