package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Test {
    public static void main(String[] args) throws IOException {

        List<String> str = arrayInputString();
        doubleValues(str);

        for(String every : str) System.out.println(every);
    }

    public static void doubleValues(List<String> list){
        for (int i = 0; i < list.size(); i++){
            list.set(i, list.get(i) + " " + list.get(i));
        }
    }

    public static void fixArray(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("л") && list.get(i).contains("р")){
                continue;
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

    public static int findUnique(int[] arr) {
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
        return -1; // если уникальный элемент не найден
    }

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



