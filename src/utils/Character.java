package utils;

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
}
