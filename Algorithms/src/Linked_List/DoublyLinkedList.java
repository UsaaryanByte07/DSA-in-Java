package Linked_List;

import java.util.NoSuchElementException;

public class DoublyLinkedList implements LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Time Complexity: O(1)
    @Override
    public void insertAtStart(int val) {
        Node newNode = new Node(val, head, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Time Complexity: O(1)
    @Override
    public void insertAtEnd(int val) {
        Node newNode = new Node(val, null, tail);
        if (tail == null) {
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

        Node newNode = new Node(val, currentNode.next, currentNode);
        currentNode.next.prev = newNode;
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
        } else {
            head.prev = null;
        }
        size--;
        return temp;
    }

    // Time Complexity: O(1) — improved from O(n) in SinglyLinkedList thanks to prev pointer
    @Override
    public int deleteAtEnd() {
        if (tail == null) {
            throw new NoSuchElementException("The Linked List is Empty");
        }
        int temp = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
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
        while (currentNode != null && currentNode.data != val) {
            currentNode = currentNode.next;
        }
        if (currentNode != null) {
            if (currentNode == tail) {
                deleteAtEnd();
            } else {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                size--;
            }
        }
    }

    // Time Complexity: O(n)
    @Override
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Time Complexity: O(n) — prints the list from tail to head
    public void printReverse() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
}
