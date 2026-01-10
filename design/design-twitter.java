class Twitter {
    private List<Integer> ids;
    private Map<Integer, Integer> posts;
    private Map<Integer, List<Integer>> following;

    public Twitter() {
        ids = new ArrayList<>();
        posts = new HashMap<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        ensureUser(userId);
        following.get(userId).add(userId); // follow self
        posts.put(tweetId, userId);
        ids.add(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ensureUser(userId);

        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while (i < ids.size()){
            if (following.get(userId).contains(posts.get(ids.get(i)))){
                int tweetId = ids.get(i);
                pq.add(tweetId);
            }
            i++;
        }
        int j = 0;
        while (!pq.isEmpty() && j < 10){
            result.add(pq.poll());
            j++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        ensureUser(followerId);
        ensureUser(followeeId);
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        ensureUser(followerId);
        following.get(followerId).remove(Integer.valueOf(followeeId));
    }
    private void ensureUser(int userId) {
        following.putIfAbsent(userId, new ArrayList<>());
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */