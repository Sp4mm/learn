package recursion;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

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
