package robots;

import java.util.Comparator;

public class RobotPowerComparator implements Comparator<Robot> {
    @Override
    public int compare(Robot o1, Robot o2) {
        return o1.getPower() - o2.getPower();
    }
}
