class Solution {
    public List<String> commonChars(String[] words) {

        int[] min_val = new int[26];
        
        for(int i=0; i <26; i++)
            min_val[i] = Integer.MAX_VALUE;

        for(String s : words){
            int[] curr_cnt = new int[26];
            for(char c : s.toCharArray()){
                curr_cnt[c - 'a']++;
            }
            for(int i=0; i <26; i++)
                min_val[i] = Math.min(min_val[i], curr_cnt[i]);
        }

        List<String> ans = new ArrayList<>();
        
        for(int i=0; i <26; i++)
            while(min_val[i] > 0){
                ans.add(""+(char)(i+'a'));
                min_val[i]--;
            }

        return ans;
    }
}