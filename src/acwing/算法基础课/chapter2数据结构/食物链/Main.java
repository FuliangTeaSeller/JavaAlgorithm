package acwing.算法基础课.chapter2数据结构.食物链;

import java.io.*;
import java.util.Scanner;

public class Main {
    static int N = (int) (50000 + 10);
    static int[] p = new int[N];
    static int[] d = new int[N];


    public static int find(int x) {
        if (p[x] != x) {
            int tmp = find(p[x]);
            d[x] += d[p[x]];
            p[x] = tmp;
        }
        return p[x];
    }

    public static boolean query(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while (k-- > 0) {
            int op = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x > n || y > n) {
                ans++;
                continue;
            }
            int px = find(x);
            int py = find(y);
            if (op == 1) {
                if (px == py && (d[x] - d[y]) % 3 != 0) {
                    ans++;
                    continue;
                }
                if (px != py) {
                    p[px] = py;
                    d[px] = d[y] - d[x];
                }

            } else {
                if (px == py && (d[x] - d[y] - 1) % 3 != 0) {
                    ans++;
                    continue;
                }
                if (px != py) {
                    p[px] = py;
                    d[px] = d[y] + 1 - d[x];
                }
            }
        }
        System.out.println(ans);
    }
}
