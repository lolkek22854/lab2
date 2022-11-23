package core;

import utils.Eatable;

public class Food implements Eatable {
//    private int calories;
    private String name;
    public Food(String name){this.name = name;}

    @Override
    public void eated(String user) {
        System.out.println(user+" поедает "+name);
    }

    public String toString(){return name;}
}
