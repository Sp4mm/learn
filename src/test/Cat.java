package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cat {
    private String name;
    private int age;
    private int tail;
    private int weight;

    public static List<Cat> createCat() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> res = new ArrayList<>();

        while (true) {
            System.out.print("Введите кличку вашего кота: ");
            String name = reader.readLine();
            if (name.isEmpty()) break;
            System.out.print("Введите возраст вашего кота: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.print("Введите длинну вашего кота: ");
            int tail = Integer.parseInt(reader.readLine());
            System.out.print("Введите вес вашего кота: ");
            int weight = Integer.parseInt(reader.readLine());
            res.add(new Cat(name, age, tail, weight));
            System.out.println("/-----------------------------------/");
        }
        return res;
    }
    private Cat(String name, int age, int tail, int weight){
        this.name = name;
        this.age = age;
        this.tail = tail;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Cat name is " + name +
                ", age is " + age +
                ", weight is " + weight +
                ", tail = " + tail;

    }
}
