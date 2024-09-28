class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        int output = words.length;
        boolean[] freq = new boolean[26];

        for(char c : allowed.toCharArray()){
            freq[c - 'a'] = true;;
        }

        for(String word : words){
            for(int i=0; i < word.length(); i++){
                if(i != 0 && word.charAt(i) == word.charAt(i-1)){
                    continue;
                }
                char c = word.charAt(i);

                if(!freq[c - 'a']){
                    output--;
                    break;
                }
            }
        }

        return output;
        
    }
}