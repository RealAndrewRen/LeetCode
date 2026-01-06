class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim();
        if (s.length() == 0){
            return true;
        }
        int right = s.length() - 1;
        int left =  0;
        while (left <= right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}