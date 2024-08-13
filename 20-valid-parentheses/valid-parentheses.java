class Solution {
    public boolean isValid(String str) {

        if(str.length() % 2 != 0) return false;

        Stack<Character> s = new Stack<>();

        for(char b : str.toCharArray()){

            if(b == '(' || b == '{' || b == '['){
                s.push(b);
            } else{
                if(s.size() == 0) return false;
                char out = s.pop();
                if(b == ')' && out!= '(') return false;
                if(b == '}' && out != '{') return false;
                if(b == ']' && out != '[') return false;
            }
        }


        return s.size()>0?false:true;
        
    }
}