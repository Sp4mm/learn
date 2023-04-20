package Users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<User, String> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            User user = User.createUser();
            if (user == null) break;
            System.out.println("Position: ");
            String pos = reader.readLine();
            map.put(user, pos);
        }

        Comparator<User> userNameCompare = new UserNameCompare();
        Comparator<User> userAgeCompare = new UserAgeCompare();
        Comparator<User> userSalaryCompare = new UserSalaryCompare();

        Set<User> boss = new TreeSet<>(userSalaryCompare);
        Set<User> worker = new TreeSet<>(userAgeCompare);
        Set<User> other = new TreeSet<>(userNameCompare);

        for (Map.Entry<User, String> userStringEntry : map.entrySet()) {
            if (userStringEntry.getValue().equals("boss")){
                boss.add(userStringEntry.getKey());
            }else if (userStringEntry.getValue().equals("worker")){
                worker.add(userStringEntry.getKey());
            }else other.add(userStringEntry.getKey());
        }

        System.out.println("Boss list:");
        for (User user : boss) {
            System.out.println(user);
        }

        System.out.println("Worker list:");
        for (User user : worker) {
            System.out.println(user);
        }

        System.out.println("Other list:");
        for (User user : other) {
            System.out.println(user);
        }

    }
}
