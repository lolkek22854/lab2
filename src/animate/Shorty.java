package animate;

import inanimate.Mirror;
import inanimate.Music;
import inanimate.Table;
import core.Character;
import interfaces.Eatable;
import utils.ReflectionType;
import utils.Sex;

public class Shorty extends Character {
    private static int maxCalories = 600;
    private Table table;
    private int totalCalories = 0;
    private Sex sex; // sex == пол (ламинат, паркет итд)
    private boolean keepsFit = false;
    private boolean isFat = false;

    public Shorty(String name, int age, Sex sex) {
        super(name, age);
        this.sex = sex;
        if (this.sex==Sex.FEMALE){keepsFit = true;}
    }

    public Shorty(String name, int age, Sex sex, boolean keepsFit) {
        super(name, age);
        this.sex = sex;
        this.keepsFit = keepsFit;
    }

    public void eat() {
        if (table.hasFood()) {
            Eatable f = table.eatFood();
            int foodCalories = f.getCalories();
            if (foodCalories > 400 && keepsFit) {
                System.out.println(name + " не может есть высококалорийную пищу, так как держит себя в форме");
            } else {
                if (foodCalories + totalCalories > maxCalories) {
                    isFat = true;
                    String fat = Sex.MALE == sex ? " потолстел" : " потолстела";
                    System.out.println(name + fat);
                }
                f.eated(name);
                totalCalories += f.getCalories();
            }
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
            if (!isFat) {
                System.out.println(name + " танцует под музыку " + music.toString());
            } else {
                System.out.println(name + " очень много весит, поэтому не может танцевать");
            }
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
