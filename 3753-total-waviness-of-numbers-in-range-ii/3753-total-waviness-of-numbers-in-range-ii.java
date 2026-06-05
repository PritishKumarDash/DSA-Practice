// class Solution {
//     public long totalWaviness(long num1, long num2) {
//         long ans = 0;
//         for(long i = num1; i <= num2; i++){
//             ans += waviness(i);
//         }
//         return ans;
//     }
//     long waviness(long num){
//         char[] ch = String.valueOf(num).toCharArray();

//         int count = 0;
//         for(int i = 1; i < ch.length - 1; i++){
//             if(ch[i] > ch[i-1] && ch[i] > ch[i+1] ||
//             ch[i] < ch[i-1] && ch[i] < ch[i+1]){
//                 count++;
//             }
        
//         }
//         return count;
//     }
// }

class Solution {

    static class Pair {
        long ways;
        long waviness;

        Pair(long ways, long waviness) {
            this.ways = ways;
            this.waviness = waviness;
        }
    }

    String s;
    Pair[][][][][] dp;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        s = String.valueOf(x);
        int n = s.length();

        dp = new Pair[n][11][11][2][2];

        Pair res = dfs(0, 10, 10, 1, 0);
        return res.waviness;
    }

    private Pair dfs(int pos, int prev1, int prev2, int tight, int started) {

        if (pos == s.length()) {
            return new Pair(1, 0);
        }

        if (dp[pos][prev1][prev2][tight][started] != null) {
            return dp[pos][prev1][prev2][tight][started];
        }

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;

        long totalWays = 0;
        long totalWave = 0;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Pair nxt = dfs(pos + 1, 10, 10, ntight, 0);

                totalWays += nxt.ways;
                totalWave += nxt.waviness;

            } else {

                int nstarted = 1;

                Pair nxt = dfs(pos + 1, d, prev1, ntight, nstarted);

                long add = 0;

                if (prev1 != 10 && prev2 != 10) {

                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = nxt.ways;
                    }
                }

                totalWays += nxt.ways;
                totalWave += nxt.waviness + add;
            }
        }

        return dp[pos][prev1][prev2][tight][started]
                = new Pair(totalWays, totalWave);
    }
}