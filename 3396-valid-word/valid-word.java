class Solution {
    public boolean isValid(String word) {

        int n = word.length();

        if(n < 3) return false;

        boolean hadVowel = false;
        boolean hadConsonant = false;
        int charCount =0;


        for(int i =0; i < n; i++){
            char c = word.charAt(i);

            if(!validChar(c)) return false;

            charCount++;

            if(isEnglishLetter(c)){
                if(isVowel(c)) hadVowel = true;
                else hadConsonant = true;
            }
        }


        return charCount>2 && hadVowel && hadConsonant;
    }

    private boolean validChar(char c){
        return isNumber(c) || isEnglishLetter(c);
    }

    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }

    private boolean isEnglishLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}