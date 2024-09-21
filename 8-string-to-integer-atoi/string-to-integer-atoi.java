/**
Trick: traverse the string,
- skip if ' ' in the start ()
 */

class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        if(n == 0) return 0;

        StringBuilder sb = new StringBuilder();
        int result=0;
        int sign=1;

        for(int i=0; i < n; i++){
            char c = s.charAt(i);

            if(c == ' '){
                if(sb.length() > 0)break;
                else continue;
            }

            if(isNumber(c)){
                int digit = c - '0';
                if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                result = result*10 + digit;
                sb.append(c);
                continue;
            }

            if((c == '-' || c == '+') && sb.length() == 0 && (i+1 < n && isNumber(s.charAt(i+1)))){
                sign = c=='+'?1:-1;
                continue;
            }

            break;
        }

        return sign*result;

        // if(sb.length()==0) return 0;

        // long num = Long.parseLong(sb.toString());
        // if(num == 0) return 0;
        // if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        // if(num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        // return (int) num;
    }

    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
}