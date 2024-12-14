package acwing.算法基础课.chapter5动态规划.多重背包问题2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> w = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int vi = scanner.nextInt();
            int wi = scanner.nextInt();
            int t = scanner.nextInt();
            int k = 1;
            while (k <= t) {
                v.add(k * vi);
                w.add(k * wi);
                t -= k;
                k *= 2;
            }
            if(t>0){
                v.add(t * vi);
                w.add(t * wi);
            }
        }
        int[] dp = new int[V + 10];
        for (int i = 0; i < v.size(); i++) {
            for (int j = V; j >=0; j--) {
                if (j - v.get(i) >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - v.get(i)] + w.get(i));
                }
            }
        }
        System.out.println(dp[V]);
    }
}