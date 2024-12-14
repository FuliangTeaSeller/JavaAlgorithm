package acwing.算法基础课.chapter2数据结构.模拟堆;

import java.util.Scanner;

public class Main {
    public static int N = (int) (1e5 + 10);
    public static int[] h = new int[N];
    public static int[] kn = new int[N];
    public static int[] nk = new int[N];
    public static int idx = 0;
    public static int size = 0;

    public static void swap(int a, int b) {
        int ka = nk[a];
        int kb = nk[b];
        kn[ka] = b;
        kn[kb] = a;
        nk[a] = kb;
        nk[b] = ka;
        int t = h[b];
        h[b] = h[a];
        h[a] = t;
    }

    public static void up(int i) {
//        int parent = i / 2;
//        if (h[parent] > h[i] && parent > 0) {
//            swap(parent,i);
//            up(parent);
//        }
        while (i / 2 > 0 && h[i / 2] > h[i]) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    public static void down(int i) {
        int l = i * 2;
        int r = i * 2 + 1;
        int tar = 0;
        if (r <= size && l <= size) {
            tar = h[l] < h[r] ? l : r;
        } else if (l <= size) {
            tar = l;
        } else if (r <= size) {
            tar = r;
        }
        if (tar != 0 && h[tar] < h[i]) {
            swap(tar, i);
            down(tar);
        }
    }

    public static void insert(int x) {
        idx++;
        size++;
        kn[idx] = size;
        nk[size] = idx;
        h[size] = x;
        up(size);
        down(size);
    }

    public static void removeTop() {
        swap(1, size); //用堆尾元素覆盖头元素
        size--;
        down(1);
    }

    public static void remove(int k) {
        int tar = kn[k];
        swap(tar, size--);
//        h[tar] = h[idx--];
        up(tar);
        down(tar);
    }

    public static void modify(int k, int x) {
        int tar = kn[k];
        h[tar] = x;
        up(tar);
        down(tar);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n-- > 0) {
            String[] s = scanner.nextLine().split(" ");
            if (s[0].equals("I")) {
                insert(Integer.parseInt(s[1]));
            } else if (s[0].equals("PM")) {
                System.out.println(h[1]);
            } else if (s[0].equals("DM")) {
                removeTop();
//                remove(nk[1]);
            } else if (s[0].equals("D")) {
                remove(Integer.parseInt(s[1]));
            } else if (s[0].equals("C")) {
                modify(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            }
        }

    }
}

