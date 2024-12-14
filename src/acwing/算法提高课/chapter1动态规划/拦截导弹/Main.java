package acwing.算法提高课.chapter1动态规划.拦截导弹;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        String s = scanner.nextLine();
        String[] sp = s.split(" ");
        for (String t : sp) {
            a.add(Integer.valueOf(t));
        }
        int n = a.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a.get(j) >= a.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans= Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);

        List<Integer> l = new ArrayList<>();
        for (int current : a) {
            int pos = -1;
            for (int j = 0; j < l.size(); j++) {
                if (current <= l.get(j)) {
                    pos = j;
                    l.set(j, current);
                    break;
                }
            }
            if (pos == -1) {
                l.add(current);
            }
        }
        System.out.println(l.size());
    }
}