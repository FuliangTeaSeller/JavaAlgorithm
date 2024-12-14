package acwing.算法基础课.chapter4数学.分解质因数;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //    public static class Cmp implements Comparator<int[]>{
//        @Override
//        public int compare(int[] o1, int[] o2) {
//            return o1[1]-o2[1];
//        }
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        PriorityQueue<int[]> q = new PriorityQueue<>(new Cmp());
        while (n-- > 0) {
            ArrayList<int[]> ans = new ArrayList<>();
            int a = scanner.nextInt();
            int t = a;
            for (int i = 2; i <= a / i; i++) {
                int cnt = 0;
                while (t % i == 0) {
                    t /= i;
                    cnt++;
                }
                if (cnt != 0) {
                    ans.add(new int[]{i, cnt});
                }
            }
            if (t != 1) {
                ans.add(new int[]{t, 1});
            }
            for (int[] i : ans) {
                System.out.printf("%d %d\n", i[0], i[1]);
            }
            System.out.println();
        }
    }
}
