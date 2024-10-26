import java.util.*;
public class CountandSumOfNodes {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int Count(Node root){
        if(root == null){
            return 0;
        }
        int lh = Count(root.left);
        int rh = Count(root.right);
        return lh+ rh+ 1;
    }

    public static int Sum(Node root){
        if(root == null){
            return 0;
        }

        int lh = Sum(root.left);
        int rh = Sum(root.right);

        return lh + rh + root.data;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The Count of Nodes = " + Count(root));
        System.out.println("The Sum of the Nodes = "+ Sum(root));
    }
}