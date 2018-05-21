package Lesson6;

import java.util.Random;

class Animal {
    protected int runLength;
    protected int jumpLength;
    protected int swimLength;
    protected int limitrun;
    protected int limitjump;
    protected int limitswim;

    Animal(int runLength, int jumpLength, int swimLength, int limitrun, int limitjump, int limitswim) {
        this.runLength = runLength;
        this.jumpLength = jumpLength;
        this.swimLength = swimLength;
        this.limitrun = limitrun;
        this.limitjump = limitjump;
        this.limitswim = limitswim;
    }

    boolean Run() {
        return runLength >= limitrun;
    }

    boolean Jump() {
        return jumpLength >= limitjump;
    }

    boolean Swim() {
        return swimLength >= limitswim;
    }

}

class Cat extends Animal {

    Cat(int runLength, int jumpLength, int swimLength, int limitrun, int limitjump, int limitswim) {
        super(runLength, jumpLength, swimLength, limitrun, limitjump, limitswim);
    }
}

class Dog extends Animal {

    Dog(int runLength, int jumpLength, int swimLength, int limitrun, int limitjump, int limitswim) {
        super(runLength, jumpLength, swimLength, limitrun, limitjump, limitswim);
    }
}

class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Cat cat = new Cat(random.nextInt(100),random.nextInt(100),0,
                random.nextInt(100),random.nextInt(100),random.nextInt(100)+1);
        Dog dog = new Dog(random.nextInt(100),random.nextInt(100),random.nextInt(100),
                random.nextInt(100),random.nextInt(100),random.nextInt(100));
        System.out.println(cat.Jump() + " "+cat.jumpLength+" "+cat.limitjump);
        System.out.println(cat.Swim() + " "+cat.swimLength+" "+cat.limitswim);
        System.out.println(cat.Run() + " "+cat.runLength+" "+cat.limitrun);
        System.out.println(dog.Jump() + " "+dog.jumpLength+" "+dog.limitjump);
        System.out.println(dog.Swim() + " "+dog.swimLength+" "+dog.limitswim);
        System.out.println(dog.Run() + " "+dog.runLength+" "+dog.limitrun);
    }
}
