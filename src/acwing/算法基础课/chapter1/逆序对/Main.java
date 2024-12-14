package acwing.算法基础课.chapter1.逆序对;

import java.util.Scanner;

public class Main {
    static int len = 100000;
    static int[] q = new int[len];
    static int[] tmp = new int[len];

    public static long merge_sort(int l, int r) {
        if(l>=r)return 0;
        int mid = l + r >> 1;
        long ans = merge_sort(l, mid) + merge_sort(mid + 1, r);
        int i = l, j = mid+1, k = 0;
        while (i<=mid&&j<=r){
            if (q[i] <= q[j]) {
                tmp[k++] = q[i++];
            }
            else {
                tmp[k++]=q[j++];
                ans+=mid-i+1;
            }
        }
        while (i<=mid){
            tmp[k++]=q[i++];
        }
        while (j<=r){
            tmp[k++]=q[j++];
        }
        k--;j--;
        for(;k>=0;k--){
            q[j--]=tmp[k];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int[] q = new int[n];
//        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }
        System.out.println(merge_sort(0, n - 1));
    }
}
