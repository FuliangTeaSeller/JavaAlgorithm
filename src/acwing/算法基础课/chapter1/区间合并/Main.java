package acwing.算法基础课.chapter1.区间合并;


import java.util.*;

public class Main {

    public static int unique(int[][] range) {
        int n = range.length;
        int ans = 1;
        int l = (int) -2e9, r = (int) -2e9;
        for (int i = 0; i < n; i++) {
            int a = range[i][0], b = range[i][1];
            if (a <= r || r == (int) -2e9) {
                r = Math.max(r, b);
            } else {
                l = a;
                r = b;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] range = new int[n][2];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            range[i][0] = l;
            range[i][1] = r;
        }
        Arrays.sort(range, (a, b) -> {
            int primary = Integer.compare(a[0], b[0]);
            return primary != 0 ? primary : Integer.compare(a[1], b[1]);
        });
        System.out.println(unique(range));
    }
}
