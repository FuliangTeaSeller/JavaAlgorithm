package acwing.算法基础课.chapter2数据结构.堆排序;

import java.util.Scanner;

public class Main {
    public static int N = (int) (1e5 + 10);
    public static int[] h = new int[N];
    public static int idx = 0;

    public static void up(int i) {
        int parent = i / 2;
        if (h[parent] > h[i] && parent > 0) {
            int t = h[parent];
            h[parent] = h[i];
            h[i] = t;
            up(parent);
        }
    }

    public static void down(int i) {
        int l = i * 2;
        int r = i * 2 + 1;
        int tar = 0;
        if (r <= idx && l <= idx) {
            tar = h[l] < h[r] ? l : r;
        } else if (l <= idx) {
            tar = l;
        } else if (r <= idx) {
            tar=r;
        }
        if(tar!=0&&h[tar]<h[i]){
            int t = h[tar];
            h[tar] = h[i];
            h[i] = t;
            down(tar);
        }
    }

    public static void insert(int x) {
        h[++idx] = x;
        up(idx);
        down(idx);
    }

    public static void removeTop() {
        h[1] = h[idx--];
        up(1);
        down(1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            insert(t);
        }
        for(int i=0;i<m;i++){
            System.out.printf("%d ", h[1]);
            removeTop();
        }
    }
}
