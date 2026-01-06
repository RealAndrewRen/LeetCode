class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (num)
        }
    }

    public boolean twoSum(int[] arr, int target){

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            int complement = target - arr[i];

            if (set.contains(complement)) {
                return true;
            }

            set.add(arr[i]);
        }
        
        return false;
    }
}