package Queue;

public interface Queue {
    void enqueue(int value);
    int dequeue();
    int peek();
    void print();
}
