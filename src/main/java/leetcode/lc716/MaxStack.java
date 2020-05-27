package leetcode.lc716;


import java.util.Stack;

public class MaxStack {
    public static void main(String[] args) {

        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);
        System.out.println(maxStack.top());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.top());
        System.out.println(maxStack.peekMax());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.top());
    }

    /**
     * initialize your data structure here.
     */
    class ListNodeWithMax {
        int val;
        int max = Integer.MIN_VALUE;
        ListNodeWithMax next;

        public ListNodeWithMax(int x) {
            val = x;
        }
    }


    ListNodeWithMax curr;

    public MaxStack() {
        curr = null;
    }

    public void push(int x) {
        ListNodeWithMax ln = new ListNodeWithMax(x);
        ln.max = curr == null ? x : (x > curr.max ? x : curr.max);
        ln.next = curr;
        curr = ln;
    }

    public int pop() {
        int ans = Integer.MIN_VALUE;
        if (curr != null) {
            ans = curr.val;
            curr = curr.next;
        }
        return ans;
    }

    public int top() {
        return curr == null ? Integer.MIN_VALUE : curr.val;
    }

    public int peekMax() {
        return curr == null ? Integer.MIN_VALUE : curr.max;
    }

    // problem
    public int popMaxProblem() {
        if(curr == null){
            return Integer.MIN_VALUE;
        }

        ListNodeWithMax dummy = new ListNodeWithMax(0);
        dummy.next = curr;
        ListNodeWithMax prev = dummy;
        int max = curr.max;
        while (curr.val != max) {
            prev = prev.next;
            curr = curr.next;
        }

        // concatenate upper & lower
        ListNodeWithMax succ = curr.next;
        prev.next = succ;
        // modify upperList *** problem
        int justVal = succ == null ? Integer.MIN_VALUE: succ.val;
        prev = dummy.next;
        while (prev != null && prev.val != justVal){
            prev.max = prev.val > justVal ? prev.val: justVal;
            prev = prev.next;
        }

        int ans = curr.max;
        curr = dummy.next;
        return ans;
    }

    public int popMax() {
        if(curr == null){
            return Integer.MIN_VALUE;
        }
        int max = curr.max;
        Stack<Integer> stack = new Stack<Integer>();
        while (curr.val != max) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = curr.next;
        while (!stack.isEmpty()){
            push(stack.pop());
        }

        return max;
    }


}
/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */