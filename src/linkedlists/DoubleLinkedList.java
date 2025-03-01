package linkedlists;

public class DoubleLinkedList {
    Node head;
    Node tail;
    int size;


    public void insertFirst(int val){
        Node node = new Node(val);
        node.prev = null;
        node.next = this.head;
        if(this.head != null){
            this.head.prev = node;
        }
        this.head = node;

        if(this.tail == null){
            this.tail = this.head;
        }

        size++;
    }

    public void insertLast(int val){
        if(this.size <= 1){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        node.prev = this.tail;
        this.tail.next = node;
        this.tail = node;
        size++;
    }

    public void deleteFirst(){
        this.head.next.prev = null;
        this.head = this.head.next;
    }

    public void deleteLast(){
        if(this.size <= 1){
            deleteFirst();
            return;
        }

        this.tail.prev.next = null;
        this.tail = this.tail.prev;
    }

    public void delete(int idx){
        if(idx == 0){
            deleteFirst();
            return;
        }

        if(idx == this.size - 1){
            deleteLast();
            return;
        }


        Node temp = this.head;
        for(int i = 0; i < idx - 1; i++){
            temp = temp.next;
        }
        temp.next.next.prev = temp;
        temp.next = temp.next.next;
    }

    public void insert(int val, int idx){
        if(idx == 0){
            insertFirst(val);
            return;
        }

        if(idx == this.size - 1){
            insertLast(val);
            return;
        }

        Node temp = this.head;

        for(int i = 1; i < idx; i++){
            temp = temp.next;
        }

        Node node = new Node(val, temp.next, temp);
        temp.next.prev = node;
        temp.next = node;

        size++;
    }

    public void display(){
      Node node = this.head;
      while (node != null){
          System.out.print(node.val + " -> ");
          node = node.next;
      }
        System.out.println("END");
    }

    public void displayReverse(){
        Node node = this.tail;
        while (node != null){
            System.out.print(node.val + " -> ");
            node = node.prev;
        }
        System.out.print("END");
    }

    public DoubleLinkedList(){
        this.size = 0;
    }

    class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this(val);
            this.next = next;
        }

        public Node(int val, Node next, Node prev){
            this(val, next);
            this.prev = prev;
        }


    }

    public static void main(String[] args){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insertFirst(5);
        doubleLinkedList.insertFirst(8);
        doubleLinkedList.insertFirst(12);
        doubleLinkedList.insertFirst(4);
        doubleLinkedList.insertLast(33);
        doubleLinkedList.insert(3, 3);
        doubleLinkedList.delete(3);
        doubleLinkedList.display();
        doubleLinkedList.displayReverse();
    }
}
