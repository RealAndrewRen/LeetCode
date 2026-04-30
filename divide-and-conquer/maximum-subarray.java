class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        else if (nums.length == 1){
            return nums[0];
        }
        int best_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        for (int i = 0; i < nums.length; i++){
            curr_sum = Math.max(nums[i], curr_sum + nums[i]);
            best_sum = Math.max(best_sum, curr_sum);
        }
        return best_sum;
    }
}