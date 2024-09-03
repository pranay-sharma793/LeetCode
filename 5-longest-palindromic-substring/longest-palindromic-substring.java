class Solution {

    public String longestPalindrome(String s) {

        if(s.length() <= 1) return s;

        String result = "";

        for(int i = 0; i < s.length(); i++){

            String oddS = helper(s, i, i);
            if(oddS.length() > result.length()) result = oddS;

            String evenS = helper(s, i, i+1);
            if(evenS.length() > result.length()) result = evenS;
        }

        return result;

    }

    private String helper(String s, int l, int r){
        String res = "";

        while(l >= 0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)){
            if(r - l + 1 > res.length()){
                res = s.substring(l, r+1);
            }
            l-=1;
            r+=1;
        }

        return res;
    }
}