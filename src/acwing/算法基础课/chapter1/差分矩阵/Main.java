package acwing.算法基础课.chapter1.差分矩阵;

import java.io.*;

public class Main {
    static void add(int x1, int y1, int x2, int y2, int c, int[][] b) {
        b[x1][y1] += c;
        b[x2 + 1][y2 + 1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
    }

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int q = Integer.parseInt(s[2]);
        int[][] a = new int[n + 2][m + 2];
        int[][] b = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            String[] s1 = reader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
//                a[i][j] = scanner.nextInt();
                a[i][j]=Integer.parseInt(s1[j-1]);
                add(i, j, i, j, a[i][j], b);
            }
        }
        while (q-- > 0) {
//            int x1 = scanner.nextInt();
//            int y1 = scanner.nextInt();
//            int x2 = scanner.nextInt();
//            int y2 = scanner.nextInt();
//            int c = scanner.nextInt();

            String line = reader.readLine();  // 一次性读取整行输入
            String[] inputs = line.split(" "); // 以空格分割成字符串数组

            int x1 = Integer.parseInt(inputs[0]);
            int y1 = Integer.parseInt(inputs[1]);
            int x2 = Integer.parseInt(inputs[2]);
            int y2 = Integer.parseInt(inputs[3]);
            int c = Integer.parseInt(inputs[4]);

            add(x1, y1, x2, y2, c, b);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i][j - 1] + b[i - 1][j] - b[i - 1][j - 1];
                writer.write(b[i][j] + " ");
            }
            writer.write("\n");
        }
        //所有write下的内容，会先存在writers中，当启用flush以后，会输出存在其中的内容。如果没有调用flush，则不会将writer中的内容进行输出。
        writer.flush();
        reader.close();
        writer.close();
//        scanner.close();
    }
}
