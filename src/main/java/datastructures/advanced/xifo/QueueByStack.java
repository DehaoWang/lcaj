package datastructures.advanced.xifo;

import java.util.Stack;

public class QueueByStack {
    public static void main(String[] args) {
        QueueByStack queueByStack = new QueueByStack();
        System.out.println(queueByStack.pop());
        System.out.println(queueByStack.peek());
        queueByStack.push(1);
        queueByStack.push(2);
        queueByStack.push(3);
        System.out.println(queueByStack.peek());
        queueByStack.push(4);
        queueByStack.push(5);
        queueByStack.push(6);
        System.out.println(queueByStack.pop());
        queueByStack.push(7);
        queueByStack.push(8);
        while (!queueByStack.empty()) {
            System.out.println(queueByStack.pop());
        }
    }


    private Stack<Integer> stackI;
    private Stack<Integer> stackO;

    public QueueByStack() {
        this.stackI = new Stack();
        this.stackO = new Stack();
    }

    /**
     * 添加元素到队尾
     */
    public void push(int x) {
        stackI.push(x);
    }

    /**
     * 删除队头的元素并返回
     */
    public int pop() {
        if (stackO.isEmpty()) {
            shift();
        }
        if (stackO.isEmpty()) {
            return -1;
        }
        return stackO.pop();
    }

    /**
     * 返回队头元素
     */
    public int peek() {
        if (stackO.isEmpty()) {
            shift();
        }
        if (stackO.isEmpty()) {
            return -1;
        }
        return stackO.peek();
    }

    /**
     * 判断队列是否为空
     */
    public boolean empty() {
        return stackI.isEmpty() && stackO.isEmpty();
    }

    public void shift() {
        while (!stackI.isEmpty()) {
            stackO.push(stackI.pop());
        }
    }
}
