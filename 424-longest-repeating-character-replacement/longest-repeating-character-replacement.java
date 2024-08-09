class Solution {
    public int characterReplacement(String s, int k) {

        int maxChar = 0;
        int maxStr = 0;
        int l=0, r=0;
        Map<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
            maxChar = Math.max(maxChar, map.get(c));
            
            if((r-l+1) - maxChar <= k){
                maxStr = Math.max(maxStr, (r-l+1));
                r++;
            } else {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
                r++;
            }



        }
        
        return maxStr;
    }
}