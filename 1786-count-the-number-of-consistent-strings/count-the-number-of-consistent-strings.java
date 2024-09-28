class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        int output = words.length;

        for(String word : words){
            for(int i=0; i < word.length(); i++){
                if(i != 0 && word.charAt(i) == word.charAt(i-1)){
                    continue;
                }
                char c = word.charAt(i);

                if(allowed.indexOf(c) == -1){
                    output--;
                    break;
                }
            }
        }

        return output;
        
    }
}