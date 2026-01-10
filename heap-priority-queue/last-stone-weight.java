class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int i = stones.length - 1;
        if (stones.length == 1){
            return stones[0];
        }
        while(stones[i - 1] != 0){
            if (stones[i] > stones[i - 1]){
                stones[i] = stones[i] - stones[i - 1];
                stones[i - 1] = 0;
            }
            else{
                stones[i] = 0;
                stones[i - 1] = 0;
            }
            Arrays.sort(stones);
        }
        return stones[i];
    }
}