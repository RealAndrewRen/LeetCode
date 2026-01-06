class Solution {
    public int rob(int[] nums) {
        int result = 0;
        while (true){
            int max = 0;
            for (int i = 0; i < nums.length; i++){
                if (Math.abs(nums[i]) > nums[max]){
                    max = i;
                }
            }

            if (nums[max] == -1){
                return result;
            }

            if (max - 1 >= 0){
                nums[max - 1] = -1;
            }
            if (max + 1 <= nums.length - 1){
                nums[max + 1] = -1;
            }
            
            result += nums[max];
            nums[max] = -1;

        }
    }
}