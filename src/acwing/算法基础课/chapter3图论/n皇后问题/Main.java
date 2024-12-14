package acwing.算法基础课.chapter3图论.n皇后问题;

import java.util.Scanner;

public class Main {
    static int n;
    static int N = 20;
    static boolean[] row = new boolean[N];
    static boolean[] col = new boolean[N];
    static boolean[] dia1 = new boolean[N];
    static boolean[] dia2 = new boolean[N];
    static boolean[][] m = new boolean[10][10];

    static void dfs(int cur) {
        if (cur == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%c", m[i][j] ? 'Q' : '.');
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[i + cur] && !dia2[i - cur + n]) {
                col[i]=true;
                dia1[i+cur]=true;
                dia2[i - cur + n]=true;
                m[cur][i]=true;

                dfs(cur+1);

                m[cur][i]=false;
                col[i]=false;
                dia1[i+cur]=false;
                dia2[i - cur + n]=false;

            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(0);
    }
}
