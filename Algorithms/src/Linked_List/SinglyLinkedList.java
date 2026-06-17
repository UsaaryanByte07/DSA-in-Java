package Linked_List;

import java.util.NoSuchElementException;

public class SinglyLinkedList implements LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Time Complexity: O(1)
    @Override
    public void insertAtStart(int val) {
        Node newNode = new Node(val, head);
        if (head == null) {
            head = tail = newNode;
        } else {
            head = newNode;
        }
        size++;
    }

    // Time Complexity: O(1)
    @Override
    public void insertAtEnd(int val) {
        Node newNode = new Node(val, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Time Complexity: O(n)
    @Override
    public void insertAt(int val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Current Size: " + size);
        }
        if (index == 0) {
            insertAtStart(val);
            return;
        }
        if (index == size) {
            insertAtEnd(val);
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        Node newNode = new Node(val, currentNode.next);
        currentNode.next = newNode;
        size++;
    }

    // Time Complexity: O(1)
    @Override
    public int deleteAtStart() {
        if (head == null) {
            throw new NoSuchElementException("The Linked List is Empty");
        }
        int temp = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return temp;
    }

    // Time Complexity: O(n)
    @Override
    public int deleteAtEnd() {
        if (head == null) {
            throw new NoSuchElementException("The Linked List is Empty");
        }
        if (head == tail) {
            int temp = head.data;
            head = tail = null;
            size--;
            return temp;
        }
        Node currentNode = head;
        while (currentNode.next != tail) {
            currentNode = currentNode.next;
        }
        int temp = tail.data;
        currentNode.next = null;
        tail = currentNode;
        size--;
        return temp;
    }

    // Time Complexity: O(n)
    @Override
    public void delete(int val) {
        if (head == null) {
            return;
        }

        if (head.data == val) {
            deleteAtStart();
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null && currentNode.next.data != val) {
            currentNode = currentNode.next;
        }
        if (currentNode.next != null) {
            if (currentNode.next == tail) {
                tail = currentNode;
            }
            currentNode.next = currentNode.next.next;
            size--;
        }
    }

    // Time Complexity: O(n)
    @Override
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}