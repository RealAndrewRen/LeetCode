class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int finish = height.length - 1;
        for (int i = 0; i < height.length && start < finish; i++){
            if ((finish - start) * Math.min(height[finish], height[start]) > max){
                max = (finish - start) * Math.min(height[finish], height[start]);
            }
            if (height[start] < height[finish]) {
                start++;
            } else {
                finish--;
            }
        }
        return max;
    }
}