package acwing.算法基础课.chapter3图论.二分图的最大匹配;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N = 1000;
    static boolean[] st = new boolean[N];
    static int[] pre = new int[N];
    static ArrayList<Integer>[] v = new ArrayList[N];

    static boolean find(int x) {
        boolean flag = false;
        for (int i : v[x]) {
            if (!st[i]) {
                st[i] = true;
                if (pre[i] == 0 || find(pre[i])) {
                    pre[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            v[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            v[a].add(b);
        }
        int cnt = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (find(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
