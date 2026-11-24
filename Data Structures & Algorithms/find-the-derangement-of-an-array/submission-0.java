class Solution {
    public int findDerangement(int n) {
        long a = 1, b = 0;
        for (int i = 2; i <= n; i++) {
            long c = (i - 1) * (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return (int) b;
    }
}
