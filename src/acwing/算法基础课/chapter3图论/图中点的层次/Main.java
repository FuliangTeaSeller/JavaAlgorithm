package acwing.算法基础课.chapter3图论.图中点的层次;

import java.util.*;

public class Main {
    static int n;
    static int N = (int) (1e5 + 10);
    static ArrayList<Integer>[] v = new ArrayList[N];
    static int[] d = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            v[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            boolean flag = false;
            for (Integer x : v[a]) {
                if (x == b) {
                    flag = true;
                    break;
                }
            }
            if (a == b || flag) continue;

            v[a].add(b);
            v[b].add(a);
        }
        Arrays.fill(d, -1);
        d[1] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(1);

        while (!q.isEmpty()) {
            int p = q.getFirst();
            q.removeFirst();
//            if (p == n) break;
            for (Integer i : v[p]) {
                if (d[i] <= 0) {
                    d[i] = d[p] + 1;
                    q.addLast(i);
                }
            }
        }
        System.out.println(d[n]);
    }
}
