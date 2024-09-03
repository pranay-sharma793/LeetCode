/**

Code similar to longest palindrome used here. For evert char match during center expansion we increase a counter. We sum all the counter returns. (There are basically all the palindrome possible from that letter (i)) we do it for odd and even centers and sum it all togther and return the final value.

Time: O(n^2)
Space: O(1)
 */

class Solution {
    public int countSubstrings(String s) {

        if(s.length() <= 1) return 1;

        int count = 0;

        for(int i = 0; i < s.length(); i++){

            count += helper(s, i, i);
            count += helper(s, i, i+1);

        }

        return count;

    }

    private int helper(String s, int l, int r){
        int counter = 0;

        while(l >= 0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)){
            counter++;
            l-=1;
            r+=1;
        }

        return counter;
    }
}