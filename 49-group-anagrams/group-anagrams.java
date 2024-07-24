class Solution {
    /*
    In this solution we use the string frequency function to check anagrams,
    Map w/ key string and list of string is set. 
    We have a function (since all lower case) using 26 len int array to change the value of char value in the string each char. Then that is changed into a single string using StringBuilder (eg.: a1b2t1) which is used as the Key value. 
    For each string the function get the freq and check if such key exist if not it defaults to a empty list.

    Learning: map.getOrDefault, String as key better than List<String>, StringBuiler
    */

    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            String sFreq = getFreq(s);
            List<String> tmp = map.getOrDefault(sFreq, new ArrayList<>());

            // if(map.containsKey(sFreq))
            //     tmp = map.get(sFreq);
            tmp.add(s);
            map.put(sFreq, tmp);
            
        }

        System.gc();

        return new ArrayList<>(map.values());

    }

    public String getFreq(String s){

    // List<Integer> freq = new ArrayList<>(26);
    int[] freq = new int[26];

    for(char c : s.toCharArray()){
        freq[c - 'a']++;
    }

    StringBuilder freqString = new StringBuilder();
    char c = 'a';

    for(int i : freq){
        freqString.append(c);
        freqString.append(i);
        c++;
    }

    return freqString.toString();
    }
}