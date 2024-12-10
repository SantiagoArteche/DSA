package linkedlists;


public class LinkList {
    private Node head;
    private Node tail;

    private int size;

    public LinkList() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val, this.head);
        node.next = this.head;
        this.head = node;

        if (this.tail == null) {
            this.tail = this.head;
        }

        this.size += 1;
    }

    public void insertLast(int val) {
        Node node = new Node(val);

        if (this.tail == null) {
            insertFirst(val);
            return;
        }

        this.tail.next = node;
        this.tail = node;

        this.size += 1;
    }

    public void insertAt(int val, int idx) {
        if (idx == 0) {
            insertFirst(val);
            return;
        }

        if (idx >= size) {
            insertLast(val);
            return;
        }

        Node temp = this.head;
        for (int i = 1; i < idx; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        this.size += 1;
    }

    public int deleteFirst() {
        int val = this.head.val;
        this.head = this.head.next;

        if (this.head == null) this.tail = null;

        size -= 1;
        return val;
    }

    public void deleteLast() {
        if (this.head == null) return;

        Node temp = this.head;
        while (temp.next != this.tail) {
            temp = temp.next;
        }

        this.tail = temp;
        this.tail.next = null;
    }

    public void deleteAt(int idx) {
        if (idx == 0) {
            deleteFirst();
            return;
        }

        if (idx >= this.size) {
            deleteLast();
            return;
        }

        Node temp = this.head;
        for (int i = 1; i < idx - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    public Node find(int val) {
        Node node = this.head;
        while (node != null) {
            if (node.val == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


    public void show() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int value) {
            this.val = value;
        }

        public Node(int value, Node next) {
            this(value);
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
