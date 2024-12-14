package leetcode.统计满足K约束的子字符串数量1;

class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0;
        int l = 0;
        int r = 0;
        int cnt0 = 0;
        int cnt1 = 0;
        while (l < n && r < n) {
            do {
                if (s.charAt(r) == '0') cnt0++;
                else cnt1++;
                r++;
            } while (r < n && (cnt0 <= k || cnt1 <= k));
            System.out.printf("%d %d\n", l, r);
            int len = r - l;
            ans += (1 + len) * (len) / 2;
            l++;
        }
        return ans;
    }
}