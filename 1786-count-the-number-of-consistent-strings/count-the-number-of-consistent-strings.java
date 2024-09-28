class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        int output = words.length;

        Map<Character, Integer> map = new HashMap<>();

        for(char c : allowed.toCharArray()){
            map.put(c , map.getOrDefault(c, 0)+1);
        }

        for(String word : words){
            for(int i=0; i < word.length(); i++){
                if(i != 0 && word.charAt(i) == word.charAt(i-1)){
                    continue;
                }
                char c = word.charAt(i);

                if(!map.containsKey(c)){
                    output--;
                    break;
                }
            }
        }

        return output;
        
    }
}