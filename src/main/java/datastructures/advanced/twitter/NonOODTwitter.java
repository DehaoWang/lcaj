package datastructures.advanced.twitter;

import java.util.*;

public class NonOODTwitter {
    public static void main(String[] args) {
        NonOODTwitter twitter = new NonOODTwitter();

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

        twitter.postTweet(3, 8);
        twitter.postTweet(3, 4);
        twitter.follow(1, 3);

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));

        System.out.println(twitter.user2Tweets);
        System.out.println(twitter.user2Followees);

    }

    /**
     * data structures.
     */
    private int timestamp = 0;
    private int maxNumTweetsInNewsFeed = 10;
    private Map<Integer, List<Integer>> user2Tweets;
    private Map<Integer, Map<Integer, Boolean>> user2Followees;

    /**
     * Initialize your data structure here.
     */
    public NonOODTwitter() {
        user2Tweets = new HashMap<>();
        user2Followees = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
//        List<Integer> tweets = user2Tweets.getOrDefault(userId, new ArrayList<>());
        List<Integer> tweets = user2Tweets.get(userId);
        if (tweets == null) {
            tweets = new ArrayList<>();
            user2Tweets.put(userId, tweets);
        }
        tweets.add(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        // K-way Merge
        List<Integer> newsFeed = new ArrayList<>();
        Map<Integer, Boolean> followees = user2Followees.getOrDefault(userId, new HashMap<>());
        followees.put(userId, true);
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (Integer followeeId : followees.keySet()) {
            List<Integer> tweets = user2Tweets.getOrDefault(followeeId, new ArrayList<>());
            // TODO: 2020-05-05 impls not K-way Merge & should use timestamp instead
            addElement(pq, tweets);
        }
        while (!pq.isEmpty()) {
            newsFeed.add(pq.poll());
        }
        return newsFeed;
    }

    public void addElement(PriorityQueue pq, List<Integer> tweets) {
        for (Integer tweetId : tweets) {
            if (pq.size() == maxNumTweetsInNewsFeed) {
                pq.poll();
            }
            pq.offer(tweetId);
        }
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
//        List<Integer> followers = user2Followers.getOrDefault(followeeId, new ArrayList<>());
        Map<Integer, Boolean> followees = user2Followees.get(followerId);
        if (followees == null) {
            followees = new HashMap<>();
            user2Followees.put(followerId, followees);
        }
        followees.put(followeeId, true);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Map<Integer, Boolean> followees = user2Followees.getOrDefault(followerId, new HashMap<>());
        followees.remove(followeeId);
    }
}
