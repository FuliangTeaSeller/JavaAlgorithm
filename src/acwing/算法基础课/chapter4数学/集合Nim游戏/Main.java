package acwing.算法基础课.chapter4数学.集合Nim游戏;

import java.util.*;

public class Main {
    static int[] a;
    static int[] s;
    static int[] f = new int[10010];

    static int sg(int x) {
        if (f[x] != -1) return f[x];
        HashSet<Integer> set = new HashSet<>();
        for (int i : s) {
            if (x - i >= 0) {
                set.add(sg(x - i));
            }
        }
        for (int i = 0; ; i++) {
            if (!set.contains(i)) {
                f[x] = i;
                return i;
            }
        }
    }

    public static void main(String[] args) {
        Arrays.fill(f, -1);
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        s = new int[k];
        for (int i = 0; i < k; i++) {
            s[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int res = 0;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            res ^= sg(a[i]);
        }
        System.out.println(res != 0 ? "Yes" : "No");
    }
}
