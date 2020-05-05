package datastructures.advanced.twitter;

import java.util.HashSet;
import java.util.Set;

public class User {
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

    public void post(int tweetId, int timestamp) {
        Tweet tweet = new Tweet(tweetId, timestamp);
//        timestamp++;
        tweet.setNext(head);
        head = tweet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set getFollowed() {
        return followed;
    }

    public void setFollowed(Set followed) {
        this.followed = followed;
    }

    public Tweet getHead() {
        return head;
    }

    public void setHead(Tweet head) {
        this.head = head;
    }
}
