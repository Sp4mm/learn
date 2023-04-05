package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Test {
    public static void main(String[] args) throws IOException {

        arrayTask();
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



