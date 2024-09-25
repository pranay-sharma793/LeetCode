class Solution {
    public int myAtoi(String s) {

        int n = s.length();

        int i = 0;
        int sign = 1;
        int res = 0;
        boolean flag = true;

        while(i < n && isSpace(s.charAt(i))){
            i++;
        }

        if(i < n && s.charAt(i)=='+'){
            sign = 1;
            i++;
        } else if(i < n && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }

        while(i < n && isNumber(s.charAt(i))){
            char c = s.charAt(i);

            if(notInRange(res, c)){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res * 10 + (c - '0');
            i++;
        }

        return sign*res;
        
    }
    
    private boolean isSpace(char c){
        return c == ' ';
    }

    private boolean isSign(char c){
        return c == '-' || c == '+';
    }

    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }

    private boolean notInRange(int res, char c){
        return res > (Integer.MAX_VALUE/10) || (res == (Integer.MAX_VALUE/10) && (c - '0') > Integer.MAX_VALUE%10);
    }
}