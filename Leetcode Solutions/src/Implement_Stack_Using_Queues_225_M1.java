import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_Using_Queues_225_M1 {
    public static void main(String[] args) {
        
    }
}


class MyStack {
    private int size = 0;
    private Queue<Integer> queue = new LinkedList<>();
    
    public MyStack() {
    }
    
    public void push(int x) {
        queue.offer(x);
        size++;
    }
    
    public int pop() {
        for(int i = 0; i < size -1 ; i++){
            queue.offer(queue.poll());
        }
        size--;
        return queue.poll();
    }
    
    public int top() {
        int temp = 0;
        for(int i = 0; i < size; i++){
            if(i == size -1) temp = queue.peek();
            queue.offer(queue.poll());
        }
        return temp;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/*
# Method 1
Learning:
Though This Code is Correct and Optimal but here 2 methods pop() and top() take O(n) time. This Problem Can be Solved More Elegantly in Method 2.

Summary:
Time Complexity:
push() = O(1)
pop() = O(n)
top() = O(n)
isEmpty() = O(1)
Space Complexity = O(n)
*/