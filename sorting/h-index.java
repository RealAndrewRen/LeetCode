class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++){
            if (citations[i] < citations.length && citations[i] <= citations[citations[i]]){
                h = citations[i];
            }
        }
        return h;
    }
}