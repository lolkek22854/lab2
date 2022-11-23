package core;

import utils.Eatable;

public class Drink implements Eatable {
    private String name;
    public Drink(String name){this.name = name;}

    @Override
    public void eated(String user) {
        System.out.println(user+" выпивает "+name);
    }

    public String toString(){return name;}
}
