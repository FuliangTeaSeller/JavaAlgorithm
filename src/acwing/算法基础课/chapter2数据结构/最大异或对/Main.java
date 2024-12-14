package acwing.算法基础课.chapter2数据结构.最大异或对;

import java.util.Scanner;

public class Main {
    static int N = 100020;
    static int M = 31 * N;
    public static int[] a = new int[N];
    public static int[][] t = new int[M][3];
    public static int idx = 0;

    public static void insert(int x) {
        int cur = 0;
        for (int i = 30; i >= 0; i--) {
            int p = (x >> i) & 1;
            if (t[cur][p] <= 0) {
                t[cur][p] = ++idx;
            }
            cur = t[cur][p];
        }
    }

    public static int not(int a) {
        return a == 0 ? 1 : 0;
    }

    public static int search(int x) {
        int cur = 0;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            int p = x >> i & 1;
            if (t[cur][not(p)] > 0) {
                cur = t[cur][not(p)];
                ans = ans * 2 + 1;
            } else {
                cur = t[cur][p];
                ans *= 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            insert(a[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, search(a[i]));
        }
        System.out.println(ans);
    }
}
