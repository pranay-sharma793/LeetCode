/**
Aditya Verma OP:
Soln flow: Create map of pattern char count, save the count of unique chars, 
In loop when u encounter a char from the map decrement the count and if it hits 0 decrement unique char count too.

Check window size, if less then increment right pointer further
If you reach the window size(pat length)  -- 
    1 .check if count is 0 ( meaning all char within the window - anagram::true). Add i to the list.
    2. Sliding window -- check if char at left (l) is from map, if yes then add the count to map and update unique char count too.
        increment right and left pointer both to slide window.

learning: map.get(s.charAt(s) == 0), handling while for string lengths.
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        List<Integer> ans = new ArrayList<>();

        int count = map.size();
        int l=0, r=0;

        while(r < s.length()){
            
            if(map.containsKey(s.charAt(r))){
                int val = map.get(s.charAt(r));
                val = val -1;
                map.put(s.charAt(r), val);
                if(map.get(s.charAt(r)) == 0) count--;

            }
            
            if(r-l+1 < p.length()) r++;
            else if(r-l+1 == p.length()){
                if(count == 0){
                    ans.add(l);
                }
                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l), map.get(s.charAt(l))+1);
                    if(map.get(s.charAt(l))==1) count++;
                }
                l++;
                r++;
            }
        }
        
        return ans;
    }
}