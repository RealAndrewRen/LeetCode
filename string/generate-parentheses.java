class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        helper(list, "", n, n);
        return list;
    }

    public void helper(List<String> list, String curr, int open, int close){
        if (open == 0 && close == 0){
            list.add(curr);
            return;
        }
        if (open > 0){
            helper(list, curr + '(', open - 1, close);
        }
        if (close > open){
            helper(list, curr + ')', open, close - 1);
        }
    }
}