package test;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private int age;
    private boolean gender;
    private List<Human> children = new ArrayList<>();

    public String getName(){
        return name;
    }

    public void setChildren(Human child){
        children.add(child);
    }

    public Human(String name, int age, boolean gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString(){
        String res = "Имя - " + name + ", пол - " + (gender? "мужчина" : "женщина") + ", возраст - " + age;
        if (children != null && !children.isEmpty()){
            res += ", дети: ";
            for (int i = 0; i < children.size(); i++) {
                res += children.get(i).getName();
                if (i < children.size() - 1) res += ", ";
            }
        }
        return res;
    }
}

