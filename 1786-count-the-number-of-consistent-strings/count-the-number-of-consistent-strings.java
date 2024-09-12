class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        Set<Character> set = new HashSet<>();

        for(char c : allowed.toCharArray()){
            set.add(c);
        }
        
        int res = words.length;
        for(String word : words){
            for(char c : word.toCharArray()){
                if(!set.contains(c)){
                    res--;
                    break;
                }
            }
        }


        return res;
    }
}