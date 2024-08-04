/**
Trick: This is sliding window problem where we are using two pointers and a set to focus on a long string sequence. As it requires no repetition we update the size of window and update the pointer accordingly.

Learning: sliding window, set usage for substring, charAt
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int l =0;
        int r = 0;
        
        while(r < s.length()){
            if(set.add(s.charAt(r))){
                //can check if !contains to
                // set.add(s.charAt(r));
                r++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(l));
                l++;
            }

        }

        return max;
    }
}