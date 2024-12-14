package acwing.算法基础课.chapter2数据结构.数组元素的目标和;

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
        int x = Integer.parseInt(s[2]);
        String[] s1 = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }
        String[] s2 = br.readLine().split(" ");
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(s2[i]);
        }
        int i = 0, j = m-1;
        for(;i<n;i++){
            while(a[i]+b[j]>x){
                j--;
            }
            if(a[i]+b[j]==x)break;
        }
        bw.write(i + " " + j);
        bw.flush();
    }
}
