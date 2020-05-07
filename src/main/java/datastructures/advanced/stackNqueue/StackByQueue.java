package datastructures.advanced.stackNqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue {
    public static void main(String[] args) {
        StackByQueue stackByQueue = new StackByQueue();
        stackByQueue.push(1);
        stackByQueue.push(2);
        stackByQueue.push(3);
        System.out.println(stackByQueue.top());
        stackByQueue.pop();
        System.out.println(stackByQueue.top());
        System.out.println(stackByQueue.empty());

        stackByQueue.pop();
        System.out.println(stackByQueue.top());
        System.out.println(stackByQueue.empty());

        stackByQueue.pop();
        System.out.println(stackByQueue.top());
        System.out.println(stackByQueue.empty());
    }

    private Queue<Integer> queue;
    int top = -1;

    public StackByQueue() {
        queue = new LinkedList<>();
    }

    /**
     * 添加元素到栈顶
     */
    public void push(int x) {
        queue.offer(x);
        top = x;
    }

    /**
     * 删除栈顶的元素并返回
     */
    public int pop() {
        for (int i = queue.size(); i > 2; i--) {
            queue.offer(queue.poll());
        }
        top = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    /**
     * 返回栈顶元素
     */
    public int top() {
        return empty() ? -1 : top;
    }

    /**
     * 判断栈是否为空
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
