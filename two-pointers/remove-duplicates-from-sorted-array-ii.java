class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int i;
        for (i = 0; i < nums.length; i++){
            if (count == 0 || count == 1 || nums[i] != nums[count - 2]){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}