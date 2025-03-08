package trees;

import java.util.Scanner;

public class BinaryTree {
    private Node root;
    public BinaryTree(){}

    public void populate(Scanner scanner){
        System.out.println("Enter the root node:");
        int val = scanner.nextInt();
        this.root = new Node(val);
        populate(scanner, this.root);
    }

    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of " + node.val);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of " + node.val);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of " + node.val);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of " + node.val);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(this.root, "");
    }

    public void display(Node node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay(){
        prettyDisplay(this.root, 0);
    }

    public void prettyDisplay(Node node, int level){
        if(node == null) return;
        prettyDisplay(node.right, level + 1);

        if(level != 0){
            for(int i = 0; i < level - 1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|---->" + node.val);
        }else{
            System.out.println(node.val);
        }

        prettyDisplay(node.left, level + 1);
    }

    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(new Scanner(System.in));
        binaryTree.prettyDisplay();
    }


}
