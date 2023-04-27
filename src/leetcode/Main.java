package leetcode;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        StringBuilder builder = new StringBuilder(s);
        int res = 0;
        while (builder.length() > 0){
            switch (builder.charAt(0)) {
                case 'M' -> {
                    res += 1000;
                    builder.deleteCharAt(0);
                }
                case 'D' -> {
                    res += 500;
                    builder.deleteCharAt(0);
                }
                case 'C' -> {
                    if (builder.length() > 1 && builder.charAt(1) == 'D') {
                        res += 400;
                        builder.delete(0, 2);
                    } else if (builder.length() > 1 && builder.charAt(1) == 'M') {
                        res += 900;
                        builder.delete(0, 2);
                    } else {
                        res += 100;
                        builder.deleteCharAt(0);
                    }
                }
                case 'L' -> {
                    res += 50;
                    builder.deleteCharAt(0);
                }
                case 'X' -> {
                    if (builder.length() > 1 && builder.charAt(1) == 'L') {
                        res += 40;
                        builder.delete(0, 2);
                    } else if (builder.length() > 1 && builder.charAt(1) == 'C') {
                        res += 90;
                        builder.delete(0, 2);
                    } else {
                        res += 10;
                        builder.deleteCharAt(0);
                    }
                }
                case 'V' -> {
                    res += 5;
                    builder.deleteCharAt(0);
                }
                case 'I' -> {
                    if (builder.length() > 1 && builder.charAt(1) == 'V') {
                        res += 4;
                        builder.delete(0, 2);
                    } else if (builder.length() > 1 && builder.charAt(1) == 'X') {
                        res += 9;
                        builder.delete(0, 2);
                    } else {
                        res += 1;
                        builder.deleteCharAt(0);
                    }
                }
                default -> {
                }
            }
        }
        return res;
    }

    // best
    /*public static int romanToInt(String s) {
    char[] chars = s.toCharArray();
    int res = 0;
    int i = 0;
    while (i < chars.length) {
        switch (chars[i]) {
            case 'M':
                res += 1000;
                break;
            case 'D':
                res += 500;
                break;
            case 'C':
                if (i < chars.length - 1 && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                    res -= 100;
                } else {
                    res += 100;
                }
                break;
            case 'L':
                res += 50;
                break;
            case 'X':
                if (i < chars.length - 1 && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                    res -= 10;
                } else {
                    res += 10;
                }
                break;
            case 'V':
                res += 5;
                break;
            case 'I':
                if (i < chars.length - 1 && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                    res -= 1;
                } else {
                    res += 1;
                }
                break;
            default:
                break;
        }
        i++;
    }
    return res;
}*/

    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        StringBuilder reversedCopy = new StringBuilder(str);
        reversedCopy.reverse();
        return str.contentEquals(reversedCopy);
    }

    // my variant
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[2];
    }

    // the best variant
    /*public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }*/
}
