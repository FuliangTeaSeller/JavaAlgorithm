package acwing.算法基础课.chapter6贪心.合并果子;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            q.add(t);
        }
        int ans = 0;
        while (q.size() >= 2) {
            int a = q.poll();
            int b = q.poll();
            q.add(a + b);
            ans += a + b;
        }
        System.out.println(ans);
    }
}
