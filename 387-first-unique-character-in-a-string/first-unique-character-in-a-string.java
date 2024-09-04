class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            //check if in map if not check rest of the string
            if(!doesRepeat(s, c, i, map)){
                return i;
            }

            map.put(c, true);
        }

        return -1;
        
    }

    private boolean doesRepeat(String s, char c, int idx, Map<Character, Boolean> map){

        if(map.containsKey(c)){
            return map.get(c);
        }

        for(int i = idx+1; i < s.length(); i++){
            if(s.charAt(i) == c){
                return true;
            }
        }

        return false;
    }
}