package test;

public class Robot {

    private String name;
    private int age;
    private int power;

    public Robot(String name, int age, int power){
        this.name = name;
        this.age = age;
        this.power = power;
    }

    public boolean fight(Robot robot2){
        if (this.power > robot2.power) {
            return true;
        } else
            return false;
    }

}
