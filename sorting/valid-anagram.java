class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char[] charss = s.toCharArray();
        Arrays.sort(charss);
        char[] charst = t.toCharArray();
        Arrays.sort(charst);
        for (int i = 0; i < charss.length; i++){
            if (charst[i] != charss[i]){
                return false;
            }
        }
        return true;
    }
}