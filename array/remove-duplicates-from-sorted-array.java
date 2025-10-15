class Solution {
    public int removeDuplicates(int[] nums) {
        int uniques = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[uniques]){
                nums[uniques + 1] = nums[i];
                uniques++;
            }
        }
        return uniques + 1;
    }
}