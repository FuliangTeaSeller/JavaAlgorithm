package acwing.算法基础课.chapter5动态规划.没有上司的舞会;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N = 6001;
    static int n;
    static int[] h = new int[N];
    static int[] p = new int[N];
    static boolean[][] st = new boolean[N][2];
    static int[][] dp = new int[N][2];

    static ArrayList<Integer>[] ch = new ArrayList[N];

    static int solve(int x, int flag) {
        if (st[x][flag]) return dp[x][flag];
        if (ch[x].isEmpty()) {
            dp[x][1] = h[x];
            dp[x][0] = 0;
            st[x][0] = true;
            st[x][1] = true;
            return dp[x][flag];
        }
        int ans = 0;
        if (flag == 0) {
            for (int i : ch[x]) {
                ans += Math.max(solve(i, 0), solve(i, 1));
            }
        } else if (flag == 1) {
            for (int i : ch[x]) {
                ans += solve(i, 0);
            }
            ans += h[x];
        }
        dp[x][flag] = ans;
        st[x][flag] = true;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            h[i] = scanner.nextInt();
            ch[i] = new ArrayList<Integer>();
            Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
        }
        for (int i = 0; i < n - 1; i++) {
            int l = scanner.nextInt();
            int k = scanner.nextInt();
            p[l] = k;
            ch[k].add(l);
        }
        int root = 1;
        while (p[root] != 0) {
            root = p[root];
        }
        int ans = Math.max(solve(root, 0), solve(root, 1));
//        System.out.println(solve(root, 0));
//        System.out.println(solve(root, 1));
        System.out.println(ans);
    }
}
