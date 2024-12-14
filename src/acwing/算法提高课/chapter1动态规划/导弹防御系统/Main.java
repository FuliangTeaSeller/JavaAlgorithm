package acwing.算法提高课.chapter1动态规划.导弹防御系统;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int ans;
    static int[] a;
    static int n;
    static int N = 100;
    static int[] up;
    static int[] down;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0) break;
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            up = new int[N];
            down = new int[N];

            ans = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            System.out.println(ans);
        }
    }

    static void dfs(int t, int u, int d) {
        if (u + d >= ans) return;
        if (t == n) {
            ans = Math.min(ans, u + d);
            return;
        }
        int i;
        for (i = 1; i <= u; i++) {
            if (a[t] > up[i]) {
                break;
            }
        }
        int temp = up[i];
        up[i] = a[t];
        dfs(t + 1, Math.max(u, i), d);
        up[i] = temp;

        for (i = 1; i <= d; i++) {
            if (a[t] < down[i]) {
                break;
            }
        }
        int tdown = down[i];
        down[i] = a[t];
        dfs(t + 1, u, Math.max(d, i));
        down[i] = tdown;


    }
}