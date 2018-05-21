package Lesson5;

public class Cat1 {

    String name;
    String color;
    int age;

    static String type = "cat";

    public Cat1(String _name, String _color, int _age){
        name = _name;
        color = _color;
        age = _age;

    }
    public Cat1(String _name, String _color){
        name = _name;
        color = _color;
    }

    void Info (){
        System.out.println(name+"   "+color+"   "+age+"     "+type);
    }
}
