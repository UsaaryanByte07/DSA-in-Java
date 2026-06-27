import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_Using_Queues_225_M2 {
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
        for(int i = 0; i < size -1 ; i++){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        size--;
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/*
# Method 2
Learning:
unlike Method 1 here all the heavy lifting is done by push() function so only 1 function has O(n) time Complexity.

Summary:
Time Complexity:
push() = O(n)
pop() = O(1)
top() = O(1)
isEmpty() = O(1)
Space Complexity = O(n)
*/