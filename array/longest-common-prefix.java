class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        Arrays.sort(strs);
        int i = 0;
        while(i < strs[0].length()){
            for (String str : strs){
                if (str.charAt(i) != strs[0].charAt(i)){
                    return result;
                }
            }
            result += strs[0].charAt(i);
            i++;
        }
        return result;
    }
}