package acwing.算法基础课.chapter1.判断子序列;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] s1 = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }

        String[] s2 = br.readLine().split(" ");
        int[] b = new int[m];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(s2[i]);
        }

        String ans = "Yes";

        for (int i = 0, j = 0; i < n; i++) {
            while (j < m && a[i] != b[j]) j++;
            if(j>=m){
                ans="No";
                break;
            }
            j++;
        }

        bw.write(ans);
        bw.flush();
    }
}
