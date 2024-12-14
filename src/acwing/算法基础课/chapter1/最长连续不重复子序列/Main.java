package acwing.算法基础课.chapter1.最长连续不重复子序列;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int ans = getAns(n, a);
        bw.write(ans+"");
        bw.flush();
//        System.out.println(ans);
    }

    private static int getAns(int n, int[] a) {
        int i = 0, j = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int ans = 0;
        for (; i < n; i++) {
            Integer res1 = hashMap.get(a[i]);
            res1 = res1 == null ? 1 : res1 + 1;
            hashMap.put(a[i], res1);
//            Integer res2 = hashMap.get(a[j]);
            while (hashMap.get(a[i]) != null && hashMap.get(a[i]) > 1) {
                hashMap.put(a[j], hashMap.get(a[j]) - 1);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
