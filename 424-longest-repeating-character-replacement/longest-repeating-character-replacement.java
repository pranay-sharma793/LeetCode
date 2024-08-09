class Solution {
    public int characterReplacement(String s, int k) {

        int maxChar = 0;
        int maxStr = 0;
        int l=0;

        //using the for loop as the right marker
        //int r=0;

        //Better to use a char counter array than a hashmap.
        //Map<Character, Integer> map = new HashMap<>();

        int[] charCount = new int[26];

        for(int r=0; r<s.length(); r++){
            charCount[s.charAt(r) - 'A']++;
            maxChar = Math.max(maxChar, charCount[s.charAt(r) - 'A']);

            while(r-l+1 - maxChar > k){
                charCount[s.charAt(l) - 'A']--;
                l++;
            }

            maxStr = Math.max(maxStr , r-l+1);

        }


        // for(char c: s.toCharArray()){
        //     map.put(c, map.getOrDefault(c, 0)+1);
        //     maxChar = Math.max(maxChar, map.get(c));
            
        //     if((r-l+1) - maxChar <= k){
        //         maxStr = Math.max(maxStr, (r-l+1));
        //         r++;
        //     } else {
        //         map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
        //         l++;
        //         r++;
        //     }
        // }
        
        return maxStr;
    }
}