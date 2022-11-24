// Внизу, вдоль тротуаров, были выставлены кривые зеркала, и каждый мог вдосталь нахохотаться,
// глядя на отражение своей вытянутой, сплюснутой или перекошенной самым неестественным образом физиономии.
// Тут же перед многочисленными столовыми и кафе, прямо на тротуаре, стояли столики.
// Многие коротышки сидели за столиками и ужинали, пили чай, кофе или газированную воду с сиропом,
// ели мороженое или просто закусывали. Некоторые танцевали тут же под музыку, которая гремела со всех сторон.
// Официанты и официантки бегали с подносами между столиками и приносили желающим разные кушанья.

import animate.*;
import inanimate.*;
import interfaces.Eatable;
import utils.*;

public class Main {
    public static void main(String[] args) {
        Shorty pers1 = new Shorty("Паша", 18, Sex.MALE, false);
        Waiter waiter = new Waiter("Дмитрий Лянгузов", 18);
        Shorty pers2 = new Shorty("Женщина1", 54, Sex.FEMALE);
        Mirror mirror = new Mirror();
        Table table1 = new Table();
        Table table2 = new Table();
        Tray tray1 = new Tray();
        Tray tray2 = new Tray();
        Music ostrov = new Music("0стр0в_в0кеане");

        pers1.look(mirror);
        pers1.look(mirror);
        pers1.seat(table1);
        tray1.putFood(new Eatable[]{
                new Food("Чезбарг", 200),
                new Food("Картошечка",150),
                new Food("Ананас",400),
                new Drink("Квас"),
        });
        tray2.putFood(new Eatable[]{
                new Food("Чезбарг", 500),
                new Food("Картошечка", 400),
                new Food("Ананас",200),
                new Drink("Квас"),
        });
        waiter.takeTray(tray1);
        waiter.run();
        waiter.unload(table1);

        pers1.eat();
        pers1.eat();
        pers1.eat();
        pers1.eat();
        pers1.eat();

        pers2.seat(table2);
        waiter.takeTray(tray2);
        waiter.run();
        waiter.unload(table2);

        pers2.eat();
        pers2.eat();
        pers2.eat();
        pers2.eat();

        ostrov.play();
        pers1.dance(ostrov);
        pers2.dance(ostrov);
        ostrov.stop();

    }
}