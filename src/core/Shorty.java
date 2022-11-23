package core;

import utils.Character;
import utils.ReflectionType;

public class Shorty extends Character {
    private Table table;

//    private boolean sex; // sex == пол (ламинат, паркет итд)

    public Shorty(String name, int age) {
        super(name, age);
//        this.sex = sex;
    }

    public void eat() {
        if (!table.hasFood()) {
            table.eatFood().eated(name);
        } else {
            System.out.println("Стол пуст, есть нечего!");
        }
    }

    public void seat(Table table) {
        System.out.println(name + " садится за стол");
        this.table = table;
    }

    public void dance(Music music) {
        if (music.isPlaying()) {
            System.out.println(name + " танцует под музыку " + music.toString());
        }
    }

    private void laugh() {
        System.out.println(name + " смеется");
    }

    public void look(Mirror mirror) {
        ReflectionType reflection = mirror.reflect();
        System.out.println(name + " смотрит в зеркало и видит свое " + reflection.toString() + " отражение");
        if (reflection == ReflectionType.CROOKED) {
            laugh();
        }
    }

}
