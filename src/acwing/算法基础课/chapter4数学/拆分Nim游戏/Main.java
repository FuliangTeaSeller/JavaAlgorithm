package acwing.算法基础课.chapter4数学.拆分Nim游戏;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int[] a;
    static int[] f = new int[110];

    static int sg(int x) {
        if (f[x] != -1) return f[x];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                set.add(sg(i)^sg(j));
            }
        }
        for (int i = 0; ; i++) {
            if (!set.contains(i)) {
                f[x] = i;
                return i;
            }
        }
    }

    public static void main(String[] args) {
        Arrays.fill(f, -1);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            res ^= sg(a[i]);
        }
        System.out.println(res != 0 ? "Yes" : "No");
    }
}
