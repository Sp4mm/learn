package Robots;

import java.util.Comparator;

public class RobotNameComparator implements Comparator<Robot> {
    @Override
    public int compare(Robot o1, Robot o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
