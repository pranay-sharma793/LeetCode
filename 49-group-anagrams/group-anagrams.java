class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            String freqStr = getFreqStr(s);

            List<String> tmp = map.getOrDefault(freqStr, new ArrayList());
            tmp.add(s);

            map.put(freqStr, tmp);
        }

        return new ArrayList<>(map.values());
    }

    private String getFreqStr(String s){
        char[] frqChar = new char[26];

        for(char c : s.toCharArray()){
            frqChar[c - 'a']++;
        }

        return new String(frqChar);
    }
}