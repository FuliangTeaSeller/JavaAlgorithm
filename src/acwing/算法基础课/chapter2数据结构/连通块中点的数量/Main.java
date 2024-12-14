package acwing.算法基础课.chapter2数据结构.连通块中点的数量;


import java.io.*;

public class Main {
    static int N = (int) (1e5 + 10);
    static int[] p = new int[N];
    static int[] c = new int[N];

    public static void merge(int a, int b) {
        int x = find(a);
        int y = find(b);
        p[x] = y;
        c[y] += c[x];
    }

    public static int find(int x) {
//        if (x == p[x]) return x;
//        return x = find(p[x]);
        if (p[x] != x) p[x] = find(p[x]);
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
            c[i] = 1;
        }

        while (m-- > 0) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[1]);
            if (s[0].equals("C")) {
                int b = Integer.parseInt(s[2]);
                if (!query(a, b)) {

                    merge(a, b);
                }
            } else if (s[0].equals("Q1")) {
                int b = Integer.parseInt(s[2]);

                String ans;
                if (query(a, b)) {
                    ans = "Yes\n";
                } else {
                    ans = "No\n";
                }
                bw.write(ans);
            } else {
                int ans = c[find(a)];
                bw.write(ans + "\n");
            }
        }
        bw.flush();
    }
}
