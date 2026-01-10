class Twitter {

    private static class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private int time = 0;
    private Map<Integer, Set<Integer>> following = new HashMap<>();
    private Map<Integer, List<Tweet>> tweets = new HashMap<>();

    public Twitter() {}

    private void ensureUser(int userId) {
        following.putIfAbsent(userId, new HashSet<>());
        following.get(userId).add(userId); // self-follow
        tweets.putIfAbsent(userId, new ArrayList<>());
    }

    public void postTweet(int userId, int tweetId) {
        ensureUser(userId);
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        ensureUser(userId);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0] // max-heap by time
        );

        // initialize heap with most recent tweet of each followed user
        for (int followee : following.get(userId)) {
            List<Tweet> list = tweets.get(followee);
            if (!list.isEmpty()) {
                int idx = list.size() - 1;
                Tweet t = list.get(idx);
                pq.offer(new int[]{t.time, t.id, followee, idx});
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && res.size() < 10) {
            int[] cur = pq.poll();
            res.add(cur[1]);

            int followee = cur[2];
            int idx = cur[3] - 1;
            if (idx >= 0) {
                Tweet t = tweets.get(followee).get(idx);
                pq.offer(new int[]{t.time, t.id, followee, idx});
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        ensureUser(followerId);
        ensureUser(followeeId);
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
