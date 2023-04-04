package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Test {
    public static void main(String[] args) throws IOException {

        int[] arr = new int[]{0, 1, 2, 3, 5, 6, 7};

        System.out.println(task2(arr));
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



