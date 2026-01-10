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

    for (int i = ids.size() - 1; i >= 0 && result.size() < 10; i--) {
        int tweetId = ids.get(i);
        int author = posts.get(tweetId);

        if (following.get(userId).contains(author)) {
            result.add(tweetId); // append in recency order
        }
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