package Stack;

import java.util.NoSuchElementException;
import Linked_List.Node;

public class LinkedListStack implements Stack{

    private Node top;

    public LinkedListStack(){
        this.top = null;
    }

    @Override
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    @Override
    public int pop() {
        if(top == null){
            throw new NoSuchElementException("Stack is Empty");
        }
        int temp = top.data;
        top = top.next;
        return temp;
    }

    @Override
    public int peek() {
        if(top == null){
            throw new NoSuchElementException("Stack is Empty");
        }
        return top.data;
    }

    @Override
    public void print() {
        if(top == null){
            throw new NoSuchElementException("Stack is Empty");
        }
        Node curr = top;
        while(curr != null){
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
