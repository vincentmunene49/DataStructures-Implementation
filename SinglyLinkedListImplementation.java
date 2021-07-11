package projects;

class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyList list = new SinglyList();
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(2);
        list.addLast(9);
        list.addLast(10);
        list.deleteFirst();

        list.display();

    }
}

class Node {
    int data;
    Node next;
}

class SinglyList {
    private Node first;

    SinglyList() {
        first = null;

    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void addFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;
    }

    public void addLast(int data) {
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;

    }

    public Node deleteFirst() {
        Node current = first;
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