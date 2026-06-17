package Linked_List;

public interface LinkedList {
    void insertAtStart(int val);
    void insertAtEnd(int val);
    void insertAt(int val, int index);
    int deleteAtStart();
    int deleteAtEnd();
    void delete(int val);
    void printList();
}
