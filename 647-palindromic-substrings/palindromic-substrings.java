class Solution {
    public int countSubstrings(String s) {

        if(s.length() <= 1) return 1;
        
        int count = 0;

        for(int i = 0; i < s.length(); i++){

            count += helper(s, i, i);
            count += helper(s, i, i+1);

        }

        return count;

    }

    private int helper(String s, int l, int r){
        int counter = 0;

        while(l >= 0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)){
            // if(r - l + 1 > res.length()){
            //     res = s.substring(l, r+1);
            // }
            counter++;
            l-=1;
            r+=1;

        }

        System.out.println(counter);
        return counter;
    }
}