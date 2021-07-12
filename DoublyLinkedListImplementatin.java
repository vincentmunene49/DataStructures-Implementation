package projects;

class DoublyLinkedListImplementation {
    public static void main(String[] args) {

        DoubleImplementation list = new DoubleImplementation();
        list.addFirst(0);
        // list.insertAfter(1, 2);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.addLast(5);
        list.deleteFirst();
        list.deleteLast();
        list.insertAfter(2, 7);
        list.deleteKey(1);

        list.display();

    }
}

class Node {
    int data;
    Node next;
    Node previous;
}

class DoubleImplementation {
    private Node first;
    private Node last;

    DoubleImplementation() {
        first = null;
        last = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            last = newNode;
        } else {
            first.previous = newNode;
        }

        newNode.next = first;
        first = newNode;

    }

    public void addLast(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }

        last = newNode;
    }

    public Node deleteFirst() {
        Node current = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return current;

    }

    public Node deleteLast() {
        Node currentLast = last;
        if (last == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;

        return currentLast;
    }

    public boolean insertAfter(int value, int data) {
        Node current = first;

        while (current.data != value) {
            current = current.next;

            if (current == null) {
                return false;
            }
        }
        Node newNode = new Node();
        newNode.data = data;

        if (current == last) {
            current.next = null;
            last = newNode;
        } else {
            current.next.previous = newNode;
            newNode.next = current.next;

        }
        newNode.previous = current;
        current.next = newNode;
        return true;

    }

    public Node deleteKey(int key) {
        Node current = first;

        while (current.data != key) {
            current = current.next;
            if (current == null) {
                return null;
            }

        }
        // check if it is the last
        if (current == last) {
            current.previous.next = null;
            last = current.previous;
        } else if (current == first) {
            current.next.previous = null;
            first = current.next;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        return current;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void display() {
        Node current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}