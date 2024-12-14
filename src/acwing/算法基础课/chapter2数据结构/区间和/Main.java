package acwing.算法基础课.chapter2数据结构.区间和;

import java.util.*;

public class Main {
    public static int find(int x, int[] sorted) {
        int l = 0, r = sorted.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (sorted[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
//        ArrayList<Integer> alls = new ArrayList<Integer>();
        HashSet<Integer> alls = new HashSet<>();
        int[][] add = new int[n][2];
        int[][] query = new int[m][2];
        for (int i = 0; i < n; i++) {
            add[i][0] = scanner.nextInt();
            add[i][1] = scanner.nextInt();
            alls.add(add[i][0]);
        }
        for (int i = 0; i < m; i++) {
            query[i][0] = scanner.nextInt();
            query[i][1] = scanner.nextInt();
            alls.add(query[i][0]);
            alls.add(query[i][1]);
        }
        int[] sorted = new int[alls.size()];
        int si = 0;
        for (Integer i : alls) {
            sorted[si++] = i;
        }
        Arrays.sort(sorted);
        int[] a = new int[alls.size() + 1];
        for (int i = 0; i < n; i++) {
            int index = find(add[i][0], sorted);
            int c = add[i][1];
            a[index] += c;
        }
        for (int i = 1; i <= alls.size(); i++) {
            a[i] += a[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int l = find(query[i][0], sorted);
            int r = find(query[i][1], sorted);
            System.out.printf("%d\n", a[r] - a[l - 1]);
        }
    }
}
