class Solution {
    public boolean isAnagram(String s, String t) {

        //If the lenght doesn't match, the strings can not be anagrams.
        if(s.length() != t.length()) return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        if(Arrays.equals(s1, t1)) return true;


        return false;
        
    }
}