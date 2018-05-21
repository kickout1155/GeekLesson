package Lesson7;

import java.util.Random;
import java.util.Scanner;

public class Cat {
    private int appetite;
    private String name;
    private boolean satiety = false;

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public Cat(String name, int appetite) {
        this.appetite = appetite;
        this.name = name;
    }

    void eat(Plate p){
        satiety = p.decreaseFood(appetite);
    }
}

class Plate{
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    void info(){
        System.out.println(food);
    }

    boolean decreaseFood(int appetite){
        System.out.println("В миске "+food+" еды");
        System.out.println("Аппетит у кота "+appetite);

        if (food-appetite >= 0){
            food-=appetite;
            return true;
        } else {
            System.out.println("В миске недостаточно еды");
            addFood();
            return false;
        }
    }

    void addFood(){
        System.out.println("Сколько добавить еды в тарелку?");
        Scanner sc = new Scanner(System.in);
        food+=sc.nextInt();
    }


}

class Mainclass {
    public static void main(String[] args) {
        Random random = new Random();
        Cat[] cats = new Cat[10];
        Plate plate = new Plate(100);

        //Для упрощения заполнения +++
        for (int i = 0; i < cats.length; i++) {
            int randomInt = random.nextInt(500);
            cats[i] = new Cat("Васька "+randomInt,randomInt);
        }
        //---

        for (Cat cat:cats){
            do {
                cat.eat(plate);
            } while (!cat.isSatiety());
        }
    }
}