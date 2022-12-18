package animate;

import exceptions.*;
import inanimate.*;
import core.Character;
import interfaces.Eatable;
import interfaces.Scary;
import utils.ReflectionType;
import utils.Sex;

public class Shorty extends Character {
    private static int maxCalories = 600;
    private Table table;
    private Shop shop;
    private boolean isScared = false;
    private int money;
    private int totalCalories = 0;
    private Sex sex; // sex == пол (ламинат, паркет итд)
    private boolean keepsFit = false;
    private boolean isFat = false;


    public Shorty(String name, int age, Sex sex) throws AgeException {
        super(name, age);
        this.sex = sex;
        if (this.sex == Sex.FEMALE) {
            keepsFit = true;
        }
    }

    public Shorty(String name, int age, Sex sex, boolean keepsFit) throws AgeException {
        super(name, age);
        this.sex = sex;
        this.keepsFit = keepsFit;
    }

    public void eat() {
        try {
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
        } catch (EmptyTableException e) {
            System.out.println(e.getMessage());
        }
    }

    public void seat(Table table) {
        System.out.println(name + " садится за стол");
        this.table = table;
    }

    public void dance(Music music) throws FatManException {
        if (music.isPlaying()) {
            if (!isFat) {
                System.out.println(name + " танцует под музыку " + music.toString());
            } else {
                throw new FatManException(name + " очень много весит, поэтому не может танцевать");
            }
        }
    }

    private void laugh() throws SadManException {
        if (!isScared) {
            System.out.println(name + " смеется");
        } else {
            throw new SadManException(name + " испуган и не может ржать");
        }
    }

    public void look(Mirror mirror) throws SadManException {
        ReflectionType reflection = mirror.reflect();
        System.out.println(name + " смотрит в зеркало и видит свое " + reflection.toString() + " отражение");
        if (reflection == ReflectionType.CROOKED) {
            laugh();
        }
    }

    public void getScared(Scary scaryObj) {
        if (scaryObj.isScary()) {
            this.isScared = true;
            System.out.println(name+" испугался "+scaryObj.toString());
        }
    }

    public boolean isScared() {
        return isScared;
    }

    public void takeMoney() {
        class SalaryGenerator{
            public int getMoney(Shorty p){
                return p.age*p.name.length()*5;
            }
        }

        SalaryGenerator salaryGenerator = new SalaryGenerator();
        this.money = salaryGenerator.getMoney(this);
        System.out.println(this.money);
    }

    public void enterShop(Shop shop) {
        this.shop = shop;
        System.out.println(name + " входит в магазин " + shop.toString());
    }

    public void leaveShop() {
        this.shop = null;
    }

    public void buyProduct() throws NotEnoughMoneyException {
        Product p = this.shop.buyProduct();
        if (money >= p.getPrice()) {
            money -= p.getPrice();
            System.out.println(name + " покупает " + p.toString());
        } else {
            throw new NotEnoughMoneyException(name + " не хватает деняк на покупку " + p.toString());
        }
    }

    public void useAmusement(Amusement amusement) {
        if (amusement.makesHappy()) {
            this.isScared = false;
            System.out.println(name + " использует аттракцион " + amusement.toString());
        }
    }


}
