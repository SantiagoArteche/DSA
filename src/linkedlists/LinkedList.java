package linkedlists;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;


    public LinkedList(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = this.head;
        this.head = node;

        if(this.tail == null){
            this.tail = this.head;
        }

        size++;
    }

    public void insertLast(int val){
        if(this.tail == null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        this.tail.next = node;
        this.tail = node;

        size++;
    }


    public void insert(int val, int idx){
        if(idx == 0){
            insertFirst(val);
            return;
        }


        Node temp = this.head;
        for(int i = 1; i < idx; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;

    }

    public Node find(int val){
        Node node = head;
        while (node != null){
            if(node.val == val){
                return node;
            }

            node = node.next;
        }
        return null;
    }
    public void deleteFirst(){
        this.head = this.head.next;
    }

    public void delete(int idx){
        if(idx == 0){
            deleteFirst();
            return;
        }

        if(idx == size - 1){
            deleteLast();
        }

        Node temp = this.head;
        for(int i = 0; i < idx - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void deleteB(int idx){
        if(idx == 0){
            deleteFirst();
            return;
        }

        if(idx == size - 1){
            deleteLast();
        }

        Node prev = getNode(idx - 1);
        prev.next = prev.next.next;
        size--;
    }

    public void deleteLast(){
        if(this.size <= 1){
            deleteFirst();
            return;
        }

        Node temp = this.head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        this.tail = temp;

        size--;
    }

    public void deleteLastB(){
        if(this.size <= 1){
            deleteFirst();
            return;
        }

        Node secondLast = getNode(this.size - 2);
        this.tail = secondLast;
        this.tail.next = null;
        size--;
    }

    public Node getNode(int idx){
        Node temp = this.head;
        for(int i = 0; i < idx; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void display(){
        Node temp = this.head;

        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

        private class Node{
        private int val;
        private Node next;

        private Node(int val){
            this.val = val;
        }

        private Node(int val, Node next){
            this.val = val;
            this.next = next;
        }


    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(7);
        linkedList.insertFirst(9);
        linkedList.insertLast(33);
        linkedList.insertLast(63);
        linkedList.delete(2);
        System.out.println(linkedList.find(555));
        linkedList.display();
    }
}