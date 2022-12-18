package animate;

import exceptions.AgeException;
import inanimate.Table;
import inanimate.Tray;
import core.Character;

public class Waiter extends Character {
    private Tray tray;
    public Waiter(String name, int age) throws AgeException {
        super(name, age);
    }
    public void takeTray(Tray tray){
        this.tray = tray;
        System.out.println("Официант "+name+ " взял поднос");
    }
    public void run(){System.out.println("Официант "+name+ " бежит к посетителям");}
    public void unload(Table table){
        table.putFood(tray.removeFood());
    }
}
