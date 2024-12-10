package linkedlists;

public class Main {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirst(66);
        linkList.insertFirst(33);
        linkList.insertLast(44);
        linkList.insertAt(120, 6);
        linkList.deleteLast();
        linkList.show();
        System.out.println(linkList.find(67));
        linkList.deleteAt(4);
        linkList.show();
        System.out.println();
    }
}
