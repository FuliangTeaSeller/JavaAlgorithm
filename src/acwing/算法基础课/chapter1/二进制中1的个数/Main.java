package acwing.算法基础课.chapter1.二进制中1的个数;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static int lowbit(int x) {
        return x & -x;
    }

    public static int cac1s(int a) {
        int ans = 0;
        while (a > 0) {
            a -= lowbit(a);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            bw.write(cac1s(Integer.parseInt(s[i]))+" ");
        }
        bw.flush();
    }
}
