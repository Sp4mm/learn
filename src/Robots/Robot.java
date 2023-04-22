package Robots;

public class Robot {

    private String name;
    private String model;
    private int age;
    private int power;

    public String getName(){
        return name;
    }

    public int getPower(){
        return power;
    }

    public Robot(String name, String model, int age, int power){
        this.name = name;
        this.model = model;
        this.age = age;
        this.power = power;
    }

    public boolean fight(Robot robot2){
        if (this.power > robot2.power) {
            return true;
        } else
            return false;
    }

    @Override
    public String toString(){
        return "Name - " + name +
                ", Model - " + model +
                ", Age - " + age +
                ", Power - " + power;
    }
}
