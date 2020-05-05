package com.lcaj.lc355;

import java.util.*;

public class Twitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(twitter.getNewsFeed(1));

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));
    }

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
        user.post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> followees = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(followees.size(), (a, b) -> (b.time - a.time));

        // K-Way Merge
        for (Integer followeeId : followees) {
            Tweet tweet = userMap.get(followeeId).head;
            if (tweet != null) {
                pq.offer(tweet);
            }
        }
        while (!pq.isEmpty()) {
            if (res.size() == maxNumNewsFeed) {
                break;
            }
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (tweet.next != null) {
                pq.offer(tweet.next);
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

    /**
     * Inner Class Tweet
     */
    class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    /**
     * Inner Class User
     */
    class User {
        private int id;
        private Set followed;
        private Tweet head;

        public User(int id) {
            this.id = id;
            followed = new HashSet();
            this.head = null;
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }
    }

    private int timestamp = 0;
    private int maxNumNewsFeed = 10;
    private Map<Integer, User> userMap;
}
