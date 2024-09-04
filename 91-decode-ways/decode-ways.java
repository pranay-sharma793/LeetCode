class Solution {
    public int numDecodings(String s) {

        int backTwice = 1;
        int backOnce = s.charAt(0) == '0' ? 0:1;
        int curr;

        for(int i = 2; i <= s.length(); i++){

            int singleVal = Integer.valueOf(s.substring(i-1, i));

            curr = 0;

            if(singleVal >= 1 && singleVal <= 9 ){
                curr = backOnce;
            }

            int doubleVal = Integer.valueOf(s.substring(i-2, i));

            if(doubleVal >= 10 && doubleVal <= 26){
                curr += backTwice;
            }

            int tmp = backOnce;
            backOnce = curr;
            backTwice = tmp;
        }

        return backOnce;
    }

    public int numDecodings1(String s) {

        // int[] dp = new int[s.length() + 1];
        // dp[0] = 1;
        // dp[1] = s.charAt(0) == '0'? 0 : 1;

        int back = 1;
        int prev = s.charAt(0) == '0'? 0 : 1;
        int curr;

        for(int i = 2; i <= s.length(); i++){

            curr = 0;

            int val = Integer.parseInt(s.substring(i-1, i));

            if(val >= 1 && val <=9){
                // dp[i] = dp[i-1];

                curr = prev;
            }

            int valTwo = Integer.parseInt(s.substring(i-2, i));

            if(valTwo >= 10 && valTwo <= 26){
                // dp[i] += dp[i-2];

                curr += back;
            }

            int tmp = prev;
            prev = curr;
            back = tmp;
        }
        
        return prev;
        // return dp[s.length()];
    }
}