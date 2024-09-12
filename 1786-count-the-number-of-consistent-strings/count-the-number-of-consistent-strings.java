class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        int[] freq = new int[26];

        for(int i =0; i< allowed.length();i++){
            if(i !=0 && allowed.charAt(i)==allowed.charAt(i-1)){
                continue;
            } else {
                freq[allowed.charAt(i) - 'a']++;
            }
        }

        for(int i=0; i<26;i++){
            System.out.print(freq[i]);
        }

        // Set<Character> set = new HashSet<>();

        // for(char c : allowed.toCharArray()){
        //     set.add(c);
        // }
        
        int res = words.length;

        for(String word : words){
            for(int i =0; i< word.length();i++){
                if(i !=0 && word.charAt(i)==word.charAt(i-1)){
                    continue;
                }
                if(freq[word.charAt(i) - 'a'] == 0){
                    res--;
                    break;
                }
            }
        }


        return res;
    }
}