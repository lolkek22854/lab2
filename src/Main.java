// Внизу, вдоль тротуаров, были выставлены кривые зеркала, и каждый мог вдосталь нахохотаться,
// глядя на отражение своей вытянутой, сплюснутой или перекошенной самым неестественным образом физиономии.
// Тут же перед многочисленными столовыми и кафе, прямо на тротуаре, стояли столики.
// Многие коротышки сидели за столиками и ужинали, пили чай, кофе или газированную воду с сиропом,
// ели мороженое или просто закусывали. Некоторые танцевали тут же под музыку, которая гремела со всех сторон.
// Официанты и официантки бегали с подносами между столиками и приносили желающим разные кушанья.

import animate.*;
import exceptions.AgeException;
import exceptions.FatManException;
import exceptions.NotEnoughMoneyException;
import exceptions.SadManException;
import inanimate.*;
import interfaces.Eatable;
import interfaces.Scary;
import utils.*;

public class Main {
    public static void main(String[] args) throws AgeException {
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
                new Food("Картошечка", 150),
                new Food("Ананас", 400),
                new Drink("Пивной напиток")
        });
        tray2.putFood(new Eatable[]{
                new Food("Чезбарг", 500),
                new Food("Картошечка", 400),
                new Food("Ананас", 200),
                new Drink("Квас") {
                    @Override
                    public int getCalories() {
                        return 20;
                    }
                },
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
        try {
            pers1.dance(ostrov);
        } catch (FatManException e) {
            System.out.println(e.getMessage());
        }
        try {
            pers2.dance(ostrov);
        } catch (FatManException e) {
            System.out.println(e.getMessage());
        }
        ostrov.stop();

        // тут вот начинается лаба4 (основная часть, тк чуть выше на 41 строке я как бы создал анонимный класс)
//        Shorty pers3 = new Shorty("Пукич", -1, Sex.MALE);
        Dog dog1 = new Dog("Бобик");
        Amusement rollerCoaster = new Amusement("качели", true);
        Shop lenta = new Shop("Гипер Лента");
        lenta.addToCatalog(new Product[]{
                new Product.Food("Чипсеки", 89, 400),
                new Product.Food("Сухареки", 29, 400),
                new Product.Food("Чоколадка", 189, 500),
                new Product.Uneatable("Новый МакБук 16 M1", 100000),
        });
        dog1.bark();
        dog1.getMuzzle();
        pers1.getScared(dog1);
        pers1.useAmusement(rollerCoaster);
        pers1.takeMoney();
        pers1.enterShop(lenta);
        for (int i = 0; i < 3; i++) {
            try {
                pers1.buyProduct();
            } catch (NotEnoughMoneyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}