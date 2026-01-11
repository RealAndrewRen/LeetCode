class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            result = expand(s, i, i, result);

            // Even-length palindrome
            result = expand(s, i, i + 1, result);
        }

        return result;
    }

    private String expand(String s, int left, int right, String best) {
        while (left >= 0 && right < s.length()
               && s.charAt(left) == s.charAt(right)) {

            if (right - left + 1 > best.length()) {
                best = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
        return best;
    }
}
