class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        List<Character> str = new ArrayList<>();

        for(char c : s.toCharArray()){
            if((c >= 97 && c <= 122) || (c >= 48 && c <=57))
                str.add(c);
        }
        
        int n = str.size();
        for(int i=0; i < n/2; i++){
            if(str.get(i) != str.get(n - i - 1))
                return false;
        }

        return true;
        
    }
}