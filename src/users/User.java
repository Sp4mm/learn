package users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
    private String name;
    private int age;
    private int salary;

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    private User(String name, int age, int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static User createUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Name: ");
        String name = reader.readLine();
        if (name.isEmpty()) return null;
        System.out.println("Age: ");
        int age = Integer.parseInt(reader.readLine());
        System.out.println("Salary: ");
        int salary = Integer.parseInt(reader.readLine());

        return new User(name, age, salary);
    }

    @Override
    public String toString(){

        return "Name - " + name +
                "; Age - " + age +
                "; Salary - " + salary;
    }
}
