class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            // List<Integer> sFreq = getFreq(s);
            String sFreq = getFreq(s);
            List<String> tmp = new ArrayList<>();

            if(map.containsKey(sFreq))
                tmp = map.get(sFreq);
            tmp.add(s);
            map.put(sFreq, tmp);
            
        }

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