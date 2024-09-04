class Solution {
    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount+1];

        for(int i = 1; i < dp.length; i++)
            dp[i] = amount+1;

        // dp[0] = 0;

        for(int i = 0; i <= amount; i++){
            for(int c : coins){
                if(i - c >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        return dp[amount] == amount + 1? -1:dp[amount];
        
    }
}