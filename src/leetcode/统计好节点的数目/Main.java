package leetcode.统计好节点的数目;

import java.util.ArrayList;

class Solution {
    static ArrayList<Integer>[] edge;
    static int ret;
    static int[] counts;

    public int count(int r, int p) {
        int n = edge.length+1;
        int ans = 0;
        boolean first = true;
        boolean valid = true;
        int t = 0;
        for (int i : edge[r]) {
            if (i != p) {
                int cur = count(i, r);
                if (first) {
                    first = false;
                    t = cur;
                } else {
                    if (t != cur) {
                        valid = false;
                    }
                }
                ans += cur;
            }
        }
        ans++;
        counts[r] = ans;
        if (valid) ret++;
        return ans;
    }

    public int countGoodNodes(int[][] edges) {
        int n = edges.length+1;
        counts = new int[n];
        ret = 0;
        edge = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edge[i] = new ArrayList<Integer>();
        }
        for (int[] e : edges) {
            edge[e[0]].add(e[1]);
            edge[e[1]].add(e[0]);
        }
        count(0, -1);
        return ret;
    }
}