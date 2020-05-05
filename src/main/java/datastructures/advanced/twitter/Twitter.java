package datastructures.advanced.twitter;

import java.util.*;

public class Twitter {

    /**
     * Data Structures
     */
    private int timestamp = 0;
    private int maxNumNewsFeed = 10;
    private Map<Integer, User> userMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId, timestamp);
        timestamp++;
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> followees = userMap.get(userId).getFollowed();
        PriorityQueue<Tweet> pq = new PriorityQueue<>(followees.size(), Comparator.comparingInt(a -> -a.getTime()));

        // K-Way Merge
        for (Integer followeeId : followees) {
            Tweet tweet = userMap.get(followeeId).getHead();
            if (tweet != null) {
                pq.offer(tweet);
            }
        }
        while (!pq.isEmpty()) {
            if (res.size() == maxNumNewsFeed) {
                break;
            }
            Tweet tweet = pq.poll();
            res.add(tweet.getId());
            if (tweet.getNext() != null) {
                pq.offer(tweet.getNext());
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User follower = userMap.get(followerId);
        follower.follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User follower = userMap.get(followerId);
            follower.unfollow(followeeId);
        }
    }
}
