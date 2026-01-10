class MedianFinder {
    private PriorityQueue<Integer> pq1;
    private PriorityQueue<Integer> pq2;

    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (pq1.isEmpty()){
            pq1.add(num);
        }
        else if (pq1.size() <= pq2.size()){
            if (num <= pq2.peek()){
                pq1.add(num);
            }
            else{
                pq1.add(pq2.remove());
                pq2.add(num);
            }
        }
        else{
            if (num >= pq1.peek()){
                pq2.add(num);
            }
            else{
                pq2.add(pq1.remove());
                pq1.add(num);
            }
        }
    }
    
    // 1, 2, 3, 4, 5 pq1 = 3 2 1, pq2 = 4, 5

    public double findMedian() {
        if (pq1.size() > pq2.size()){
            return pq1.peek();
        }
        else{
            return ((double) pq1.peek() + (double) pq2.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */