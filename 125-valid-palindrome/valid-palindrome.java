/**
Trick: Storing each char which is a alphanumeric value in the char[]. Traverse the array half and compare with the other half. If value mismatch return false else return true.

Alternative: Using a boolean flag.

Learnings: toLowerCase, a - 97
z - 122
A - 67
Z - 93
0 - 48
9 - 57
 */


class Solution {
    public boolean isPalindrome(String s) {

        String str = s.toLowerCase();
        List<Character> list = new ArrayList<>();

        for(char c: str.toCharArray()){
            if((c >=97 && c <= 122) || (c >= 48 && c <= 57))
                list.add(c);
        }
        int n = list.size();
        for(int i =0; i < n/2; i++){
            if(list.get(i) != list.get(n - i -1))
                return false;
        }
        
        return true;
    }
}