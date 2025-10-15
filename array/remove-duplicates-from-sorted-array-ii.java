class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int i;
        for (i = 1; i < nums.length - 1; i++){
            if (nums[i] != nums[i - 1]){
                nums[count + 1] = nums[i];
                count++;
            }
            else if (nums[i] == nums[i - 1] && nums[i] != nums[i+1]){
                nums[count + 1] = nums[i];
                count++;
            }
        }
        if (nums[i] != nums[i - 2]){
            nums[count + 1] = nums[i];
            count++;
        }
        return count + 1;
    }
}