package Stack;

import java.util.NoSuchElementException;

public class ArrayStack implements Stack {
    private int top;
    private int size;
   private int[] arr;

    public ArrayStack(int size) {
        top = -1;
        this.size = size;
        this.arr = new int[size];
    }

    @Override
    public void push(int value) {
        if (top == size - 1) {
            System.out.println("The Stack is Full");
            return;
        }
        arr[++top] = value;
    }

    @Override
    public int pop() {
        if (top == -1)
            throw new NoSuchElementException("Stack is Empty");
        return arr[top--];
    }

    @Override
    public int peek() {
        if (top == -1) {
            throw new NoSuchElementException("Stack is Empty");
        }
        return arr[top];
    }

    @Override
    public void print() {
        if (top == -1) {
            throw new NoSuchElementException("Stack is Empty");
        }
        for (int num : arr) {
            System.out.println(num + " ");
        }
        System.out.println();
    }

}
