class Solution {
    public boolean isSubsequence(String s, String t) {

        if(s.equals("")) return true;

        int idx = 0;
        for(char tc : t.toCharArray()){

            char c = s.charAt(idx);
            if(tc == c){
                idx++;
                if(idx == s.length()) return true;
            }
        }

        return false;
        
    }
}