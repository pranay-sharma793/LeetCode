class Solution {
    // //Method 1: Using Arrays.
    // public boolean isAnagram(String s, String t) {

    //     //If the lenght doesn't match, the strings can not be anagrams.
    //     if(s.length() != t.length()) return false;

    //     // This is simpler method to use the Arrays library to sort and compare the two strings.
    //     char[] s1 = s.toCharArray();
    //     char[] t1 = t.toCharArray();

    //     Arrays.sort(s1);
    //     Arrays.sort(t1);

    //     if(Arrays.equals(s1, t1)) return true;


    //     return false;
        
    // }

    //This problem uses the method of setting a 26 size array representing all alphabets. Since both the strings contains only lowercase english letters. Storing the freq of each char from the string in an int[] then comparing both the int[] to see if the words are anagrams of each other.
    public boolean isAnagram(String s, String t) {

        //If the lenght doesn't match, the strings can not be anagrams.
        if(s.length() != t.length()) return false;


        if(Arrays.equals(getFreq(s), getFreq(t))) return true;

        return false;
    }

    int[] getFreq(String s){

        int[] count = new int[26];

        for(char c : s.toCharArray())
            count[c - 'a']++;

        return count;
    }

}