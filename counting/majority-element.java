class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int j = 0; j < n; j++){
            int count = 0;
            for (int i = j; i < n; i++){
                if (nums[i] == nums[j]){
                    count++;
                }
                if (count > n / 2){
                    return nums[i];
                }
            }            
        }
        return 0;
    }
}