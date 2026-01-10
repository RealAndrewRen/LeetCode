import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int s : stones) {
            pq.add(s);
        }
        
        while (pq.size() > 1) {
            int y = pq.poll(); // largest
            int x = pq.poll(); // second largest
            
            if (y != x) {
                pq.add(y - x);
            }
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
