package users;

import java.util.Comparator;

public class UserSalaryCompare implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}
