class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] sArr = getFreq(s);
        int[] tArr = getFreq(t);

        return Arrays.equals(sArr, tArr);

    }

    private int[] getFreq(String s){
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        return freq;
    }
}