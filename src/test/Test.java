package test;

import Users.User;
import Users.UserAgeCompare;
import Users.UserNameCompare;
import Users.UserSalaryCompare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class Test {
    public static void main(String[] args) throws IOException {
        usersTask();
    }

    public static void usersTask() throws IOException {
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

        Set<User> boss = new TreeSet<>();

        System.out.println(map);

    }
    public static void taskRobots(){
        Comparator<Robot> compareModel = new RobotModelComparator();
        Comparator<Robot> comparePower = new RobotPowerComparator();

        Map<Robot, Integer> robots = new TreeMap<>(compareModel.thenComparing(comparePower));
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
    public static Map<Character, Integer> countOfLetters(String entryString){
        Map<Character, Integer> result = new HashMap<>();
        char[] list = entryString.toCharArray();
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            int counter = 0;
            for (int j = 0; j < list.length; j++) {
                if (list[i] == list[j]){
                    counter++;
                }
            }
            i += counter - 1;
            result.put(list[i], counter);
        }

        return result;
    }

    public static void deleteSameNames(Map<String, String> map){
        Map<String, String> copy = new HashMap<>(map);
        for (String value : copy.values()) {
            int count = 0;
            for (String s : copy.values()) {
                if (value.equals(s)){
                    count++;
                }
                if (count > 1){
                    for (Map.Entry<String, String> stringStringEntry : copy.entrySet()) {
                        if (stringStringEntry.getValue().equals(value)) {
                            map.remove(stringStringEntry.getKey());
                        }
                    }
                }
            }
        }
    }

    public static void removeAllNumbersMoreThan10(Set<Integer> set){
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() > 10) iterator.remove();
        }
    }

    public static void task4WithMap(){
        Map<String, LocalDate> map = new HashMap<>();
        map.put("Adam", LocalDate.of(1993, Month.DECEMBER, 7));
        map.put("Den", LocalDate.of(2003, Month.SEPTEMBER, 14));
        map.put("Phil", LocalDate.of(2012, Month.AUGUST, 17));
        map.put("Jon", LocalDate.of(1972, Month.JULY, 27));
        map.put("Mark", LocalDate.of(1983, Month.OCTOBER, 8));

        Iterator<LocalDate> iterator = map.values().iterator();
        while (iterator.hasNext()){
            LocalDate date = iterator.next();
            if (date.getMonthValue() > 5 && date.getMonthValue() < 9){
                iterator.remove();
            }
        }
        for (Map.Entry<String, LocalDate> s : map.entrySet()) {
            System.out.println("Name: " + s.getKey() + "\nDate of birth is: " + s.getValue());
        }
    }

    public static void task3WithMap(){
        Map<String, String> map = new HashMap<>();
        map.put("First", "John");
        map.put("First1", "Jack");
        map.put("First2", "Nick");
        map.put("First3", "Vlad");
        map.put("First4", "Nick");

        System.out.println(getCountTheSameFirstName(map, "Nick"));
        System.out.println(getCountTheSameLastName(map, "First"));

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name){
        int res = 0;
        for (String value : map.values()) {
            if (value.equals(name)) res++;
        }
        return res;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName){
        int res = 0;
        for (String s : map.keySet()) {
            if (s.equals(lastName)) res++;
        }
        return res;
    }

    public static void task2WithMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();

        while (true){
            String str = reader.readLine();
            if (str.isEmpty()) break;
            map.put(str, reader.readLine());
        }
        for (String s : map.keySet()) System.out.println(s);
    }

    public static void taskWithMap(){
        Map<String, String> map = new HashMap<>();
        map.put("abc", "ff");
        map.put("asd", "vfe");
        map.put("wed", "fe");
        map.put("vt", "vrsd");

        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " - " + s.getValue());
        }
    }

    public static void stringSort(List<String> list){
        Collections.sort(list);
    }

    public static void largestNums() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res = new ArrayList<>();

        while (true){
            String str = reader.readLine();
            if (str.isEmpty()) break;
            res.add(Integer.parseInt(str));
        }
        Collections.sort(res);
        List<Integer> largestNums = res.subList(res.size() - 4, res.size());

        for (Integer largestNum : largestNums) System.out.println(largestNum);

    }

    public static int revesedNum(int num){
        boolean isNegative = false;
        if (num < 0){
            isNegative = true;
            num = -num;
        }

        StringBuilder stringBuilder = new StringBuilder(Integer.toString(num));
        stringBuilder.reverse();

        int res = Integer.parseInt(stringBuilder.toString());
        return isNegative? -res : res;
    }

    public static void task4() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> array = new ArrayList<>();

        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) array.add(reader.readLine());
        for (String s : array) System.out.println(s);
        for (int i = 0; i < m; i++) array.add(array.remove(0));

        for (String s : array) System.out.println(s);
    }

    public static List<String> arrayDoubler(List<String> list){
        List<String> res = new ArrayList<>(list);

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).length() % 2 == 0) res.set(i, res.get(i) + " " + res.get(i));
            else res.set(i, res.get(i) + " " + res.get(i) + " " + res.get(i));
        }

        return res;
    }

    public static void doubleValues(List<String> list){
        for (int i = 0; i < list.size(); i++){
            list.set(i, list.get(i) + " " + list.get(i));
        }
    }

    public static void fixArray(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("л") && list.get(i).contains("р")){

            } else if (list.get(i).contains("л")){
                list.add(i,list.get(i));
                i++;
            } else if (list.get(i).contains("р")) {
                list.remove(i);
                i--;
            }
        }
    }

    public static <T> List<T> refreshArray(List<T> list){
        List<T> res = new ArrayList<>(list);
        for (int i = 0; i < res.size(); i++){
            T m = res.remove(res.size() - 1);
            res.add(0, m);
        }
        return res;
    }

    public static List<List<Integer>> arrayThreeSort(List<Integer> list){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> thired = new ArrayList<>();

        for (int m : list){
            if(m % 3 == 0){
                first.add(m);
            }
            if (m % 2 == 0) {
                second.add(m);
            } else if (m % 3 != 0) thired.add(m);

        }

        res.add(first);
        res.add(second);
        res.add(thired);
        return res;
    }

    public static List<String> maxSymbols(List<String> list){
        List<String> res = new ArrayList<>();
        int longest = 0;

        for (String every : list){
            int m = every.length();
            if (longest < m){
                longest = m;
                res.clear();
                res.add(every);
            } else if (longest == m) res.add(every);
        }

        return res;
    }

    public static List<List<Integer>> arraySplit(List<Integer> list) throws IOException {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            int elem = list.get(i);
            if (elem % 2 == 0){
                first.add(elem);
            } else {
                second.add(elem);
            }
        }
        res.add(first);
        res.add(second);
        return res;
    }

    public static List<Integer> arrayInputNums() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        String str;

        while (true) {
            str = reader.readLine();
            if (str.isEmpty()) break;
            list.add(Integer.parseInt(str));
        }
        return list;
    }

    public static List<String> arrayInputString() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        String str;

        while (true) {
            str = reader.readLine();
            if (str.isEmpty()) break;
            list.add(str);
        }
        return list;
    }


    public static List<Integer> arrayLess5(List<Integer> list) throws IOException{

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 5){
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public static void arraySort() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        String str;

        while (true){
            str = reader.readLine();
            if (str.isEmpty()) break;
            int res = Integer.parseInt(str);

            if (res % 2 == 1){
                list.add(0, res);

            } else list.add(res);
        }
        for (int res : list) System.out.print(res + " ");
    }

    public static void arrayTask() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <Integer> list = new ArrayList<>();

        String str = reader.readLine();

        while (!str.equals("")){
            list.add(Integer.parseInt(str));
            str = reader.readLine();
        }

        for (int res : list) System.out.print(res + " ");
    }

    public static int task3(int[] array){

        for (int i = 0; i < array.length - 1; i++) {


            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]){
                    array[i] = -1;
                    array[j] = -1;


                }
            }

        }

        for (int res : array) {
            if (res != -1){
                return res;
            }
        }
        return -1;
    }

    /*public static int findUnique(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : arr) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
            for (int i : arr) {
                if (map.get(i) == 1) {
                    return i;
                }
            }
            return -1;
        }*/

        public static int task2(int[] array){
            int left = 0;
            int right = array.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if (array[mid] == mid){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void task1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] res = new int[5];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(res);

        for (int i = 4; i >= 0; i--) {
            System.out.println(res[i]);
        }

    }

}



