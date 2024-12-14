package acwing.算法基础课.chapter4数学.求组合数1v2;

import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    //    static int N = 2010;
//    static long[][] dp = new long[N][N];
    static HashMap<Integer, HashMap<Integer, Long>> dp=new HashMap<>();

    static long get(int a, int b) {
        HashMap<Integer, Long> map = dp.get(a);
        if (map == null) return 0;
        Long l = map.get(b);
        if (l == null) return 0;
        return l;
    }

    static void set(int a, int b, long val) {
        HashMap<Integer, Long> map = dp.get(a);
        if (map == null) {
            map = new HashMap<>();
            dp.put(a, map);
        }
        map.put(b, val);
    }

    static long c(int a, int b) {
//        System.out.printf("caculate c %d %d\n", a, b);
        if (a == b || b == 0) return 1;
        if (get(a, b) != 0) {
//            System.out.printf("found\n");
            return get(a, b);
        }
        set(a, b, c(a - 1, b - 1) + c(a - 1, b));
        set(a, b, get(a, b) % mod);
//        System.out.println();
        return get(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int p= scanner.nextInt();
            System.out.println(c(a, b));
        }
    }
}