package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class daily225 {
    public static void main(String[] args) {
        MyStack225 myStack = new MyStack225();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.empty());
    }
}

/**
 * 用队列实现栈
 * 
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyStack225 {
    private Deque<Integer> q1 = new ArrayDeque<>();
    private Deque<Integer> q2 = new ArrayDeque<>();

    public MyStack225() {

    }

    public void push(int x) {
        // 最终操作的是 q1，用 q2 中转
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // 交换 q1 和 q2
        Deque<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
