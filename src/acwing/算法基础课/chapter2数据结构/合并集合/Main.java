package acwing.算法基础课.chapter2数据结构.合并集合;

import java.io.*;

public class Main {
    static int N = (int) (1e5 + 10);
    static int[] p = new int[N];

    public static void merge(int a, int b) {
        p[find(a)] = find(b);
    }

    public static int find(int x) {
//        if (x == p[x]) return x;
//        return x = find(p[x]);
        if(p[x]!=x) p[x]=find(p[x]);
        return p[x];
    }

    public static boolean query(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        while (m-- > 0) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            if (s[0].equals("M")) {
                merge(a, b);
            } else {
                String ans;
                if (query(a, b)) {
                    ans = "Yes\n";
                } else {
                    ans = "No\n";
                }
                bw.write(ans);
            }
        }
        bw.flush();
    }
}
