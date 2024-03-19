package common;

/**
 * 单调栈实现
 */
public class MonoStack {
    private int[] arr;
    private int top;

    public MonoStack(int capacity) {
        arr = new int[capacity];
        top = -1;
    }

    public void push(int val) {
        while (top != -1 && arr[top] < val) {
            top--;
        }
        arr[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
