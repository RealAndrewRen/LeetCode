class Solution {
    public boolean isValid(String s) {
        String par = "({[";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (par.indexOf(s.charAt(i)) >= 0){
                stack.push(s.charAt(i));
            }
            else {
                if (stack.isEmpty()){
                return false;
                }
                char top = stack.pop();
                char ch = s.charAt(i);
                    if (ch == ')' && top != '(') {
                        return false;
                    }
                    if (ch == ']' && top != '[') {
                        return false;
                    }
                    if (ch == '}' && top != '{') {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
    