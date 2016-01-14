package com.example;

class Node<T> {

    Node(T value) {
        this.value = value;
        this.next = null;
    }

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    T value;
    Node<T> next;
}

class CycleDetector<T> {

    Node<T> head, tail;

    boolean addNext(T item) {
        if (head == null) {
            head = tail = new Node<>(item);
            return false;
        }
        tail.next = new Node<>(item);
        tail = tail.next;
        return hasLoop();
    }

    private boolean hasLoop() {
        Node<T> slow, fast;
        slow = fast = head;
        while (true) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return false;

            if (slow == null || fast == null)
                return false;

            if (slow.value.equals(fast.value))
                return true;
        }
    }
}
