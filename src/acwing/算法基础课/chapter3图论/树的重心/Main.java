package acwing.算法基础课.chapter3图论.树的重心;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N = (int) (1e5 + 10);
    static int n;
    static ArrayList<Integer>[] v = new ArrayList[N];
    static boolean[] vis = new boolean[N];
    static int ans=N;

    static int dfs(int r) {
        int res=0;
        int sum = 1;
        vis[r]=true;
        for (Integer i : v[r]) {
            if (!vis[i]) {
                int s = dfs(i);
                res=Math.max(res,s);
                sum+=s;
            }
        }
        res=Math.max(res,n-sum);
        ans=Math.min(ans,res);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            v[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            v[a].add(b);
            v[b].add(a);
        }
        dfs(1);
        System.out.println(ans);
    }
}
