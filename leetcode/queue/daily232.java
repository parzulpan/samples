package queue;

import java.util.Stack;

public class daily232 {
    public static void main(String[] args) {
        MyQueue232 myQueue = new MyQueue232();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
    }
}

/**
 * 用栈实现队列
 * 
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue232 {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public MyQueue232() {

    }

    public void push(int x) {
        // 最终操作的是 s1，用 s2 中转
        s1.push(x);
        while (!s1.empty()) {
            s2.push(s1.pop());
        }

    }

    public int pop() {
        return s2.pop();
    }

    public int peek() {
        return s2.peek();
    }

    public boolean empty() {
        return s2.empty();
    }
}