class Solution {
    public int lastStoneWeightII(int[] A) {
        for(int n : A){
        System.out.print(n+",");
        }

        int totalSum = 0;

        // Calculate total sum of the array
        for (int num : A) {
            totalSum += num;
        }

        // DP array to track possible sums
        boolean[] dp = new boolean[totalSum / 2 + 1];
        dp[0] = true; // Base case: sum 0 is always achievable

        // Populate the DP table
        for (int num : A) {
            // Traverse dp array backwards to avoid overwriting previous results
            for (int j = totalSum / 2; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // Find the largest sum that's <= totalSum / 2
        int subsetSum = 0;
        for (int i = totalSum / 2; i >= 0; i--) {
            if (dp[i]) {
                subsetSum = i;
                break;
            }
        }

        // The minimum difference will be totalSum - 2 * subsetSum
        return totalSum - 2 * subsetSum;
    }
}