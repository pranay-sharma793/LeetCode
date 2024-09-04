class Solution {
    public boolean isSubsequence(String s, String t) {

        if(s.equals("")) return true;

        // if(t.equals("")) return false;

        int idx = 0;
        for(int i = 0; i < t.length(); i++){
            char c = s.charAt(idx);

            if(t.charAt(i) == c){
                idx++;
                if(idx == s.length()) return true;
                continue;
            }
        }

        return false;
        
    }
}