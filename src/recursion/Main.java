package recursion;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

import static test.Test.arrayInputString;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> str = arrayInputString();

        System.out.println(countWords(str));
    }

    public static Map<String, Integer> countWords(List<String> list, Map<String, Integer> map){
        if (list.isEmpty()) return map;
        Map<String, Integer> res = new HashMap<>(map);
        List<String> copy = new ArrayList<>(list);
        int count = 0;

        Iterator<String> iterator = copy.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(list.get(0))){
                iterator.remove();
                count++;
            }
        }
        res.put(list.get(0), count);
        return countWords(copy, res);
    }

    public static Map<String, Integer> countWords(List<String> list){
        Map<String, Integer> res = new HashMap<>();

        return countWords(list, res);
    }

    public static int binarySearch(int[] array, int n, int first, int last){
        int mid = first + (last - first) / 2;
        if (array[mid] == n) return mid;
        if (array[mid] < n) return binarySearch(array, n, mid + 1, last);
        return binarySearch(array, n, first, last - 1);
    }

    public static int binarySearch(int[] array, int n){
        int first = 0;
        int last = array.length - 1;
        return binarySearch(array, n, first, last);
    }

    /*public static int binarySearch(int[] array, int n){
        int first = 0;
        int last = array.length - 1;
        int mid = first + last / 2;

        while (first < last){
            if (array[mid] == n) {
                return mid;
            }else if (array[mid] < n) {
                last = mid - 1;
            }else {
                first = mid + 1;
            }
        }
        return mid;
    }*/

    /*public static BigInteger fibonacci(int n){
        BigInteger res = BigInteger.ZERO;
        BigInteger sum = BigInteger.ONE;
        for (int i = 0; i < n - 1; i++) {
            BigInteger helper = res;
            res = sum.add(res);
            sum = helper;
        }
        return res;
    }*/

    static Map<Integer, BigInteger> cache = new HashMap<>();
    public static BigInteger fibonacci (int n){
        BigInteger res;

        if ((res = cache.get(n)) != null) return res;
        if (n == 1) return BigInteger.ZERO;
        if (n == 2) return BigInteger.ONE;

        res = fibonacci(n - 1).add(fibonacci(n - 2));
        cache.put(n, res);
        return res;
    }
}
