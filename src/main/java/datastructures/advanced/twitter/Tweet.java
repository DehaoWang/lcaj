package datastructures.advanced.twitter;

public class Tweet {
    private int id;
    private int time;
    private Tweet next;

    public Tweet(int id, int time) {
        this.id = id;
        this.time = time;
        this.next = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Tweet getNext() {
        return next;
    }

    public void setNext(Tweet next) {
        this.next = next;
    }
}
