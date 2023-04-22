package Robots;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Comparator<Robot> compareName = new RobotNameComparator();
        Comparator<Robot> comparePower = new RobotPowerComparator();

        Map<Robot, Integer> robots = new TreeMap<>(compareName.thenComparing(comparePower));
        Robot robot0 = new Robot("Alex", "AG-44", 2, 1);
        Robot robot1 = new Robot("Nick", "B99", 5, 3);
        Robot robot2 = new Robot("Bender", "AB08", 12, 6);
        Robot robot3 = new Robot("Nick", "AG-44", 24, 4);

        robots.put(robot0, 0);
        robots.put(robot1, 1);
        robots.put(robot2, 2);
        robots.put(robot3, 3);

        for (Map.Entry<Robot, Integer> integerRobotEntry : robots.entrySet()) {
            System.out.println("Index: " + integerRobotEntry.getValue() + ". Robot - " + integerRobotEntry.getKey());
        }
    }
}
