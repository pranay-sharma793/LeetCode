class Solution {
    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        String tmp = "0123456";

        for(int i = 2; i < dp.length; i++){
            int val = Integer.parseInt(s.substring(i-1, i));

            if(val >= 1 && val <=9){
                dp[i] += dp[i-1];
            }

            int valTwo = Integer.parseInt(s.substring(i-2, i));

            if(valTwo >= 10 && valTwo <= 26){
                    dp[i] += dp[i-2];
            }
        }
        
        return dp[s.length()];
    }
}