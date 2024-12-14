package acwing.算法基础课.chapter2数据结构.Trie字符串统计;

import java.util.Scanner;

public class Main {
    public static int[][] t = new int[27][10010];
    public static int[] c = new int[10010];
    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n-- > 0) {
            String[] s = scanner.nextLine().split(" ");
            StringBuilder s1 = new StringBuilder(s[1]);
            char ap = 'z' + 1;
            s1.append(ap);
            if (s[0].equals("I")) {
                int cur = 0;
                for (int i = 0; i < s1.length(); i++) {
                    int idx = s1.charAt(i) - 'a';
                    if (t[idx][cur] <= 0) {
                        t[idx][cur] = ++cnt;
                    }
                    cur = t[idx][cur];
                    c[cur]++;
                }
            } else {
                int ans = 0;
                int cur = 0;
                for (int i = 0; i < s1.length(); i++) {
                    int idx = s1.charAt(i) - 'a';
                    if (t[idx][cur] > 0) {
                        cur = t[idx][cur];
                    } else {
                        ans = 0;
                        break;
                    }
                    if (i + 1 == s1.length()) {
                        ans = c[cur];
                        break;
                    }
                }
//                ans = c[cur];
                System.out.println(ans);
            }
        }
    }

}
