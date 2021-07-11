package projects;

class CircularLinkedList {
    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.addFirst(1);
        list.addFirst(0);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(-1);
        list.deleteFirst();
        list.display();

    }
}

class Node {
    int data;
    Node next;
}

class CircularList {
    private Node first;
    private Node last;

    CircularList() {
        first = null;// reference to first item in the list
        last = null;// reference to the last item in the list
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void addFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;

        first = newNode;// even if it is empty still the first element should have both the first and
                        // last pointing to it

    }

    public void addLast(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()) {
            first = newNode;
        }
        last.next = newNode;

        last = newNode;// even if it is empty still the first element should have both the first and
                       // last pointing to it
    }

    public Node deleteFirst() {
        Node current = first;
        if (first.next == null) {
            last = null;
        }
        first = first.next;

        return current;
    }

    public void display() {
        Node current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}