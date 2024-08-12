class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        String ans = "";

        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int l=0, r=0;
        int minWin = Integer.MAX_VALUE;
        int count = map.size();

        while(r < s.length()){   

            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r), map.get(s.charAt(r)) -1);
                if(map.get(s.charAt(r)) == 0) {
                    count--;
                    }
            }

            if(count > 0) r++;
            else if(count == 0){

                while(!map.containsKey(s.charAt(l)) || map.get(s.charAt(l)) < 0){
                    if(map.containsKey(s.charAt(l))) 
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    l++;
                }

                if((r-l+1) < minWin){
                    ans = s.substring(l, r+1);
                }
                minWin = Math.min(minWin , (r-l+1));

                // System.out.println("window found at: "+l+"-"+r + "::" + s.substring(l, r+1));

                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                count++;
                l++;
                r++;

 
            }

        }
        
        return ans;
    }
}