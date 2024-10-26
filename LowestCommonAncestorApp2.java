import java.util.*;
public class LowestCommonAncestorApp2 {
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
    public static Node LCA2(Node root,int n1,int n2){

        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLCA = LCA2(root.left,n1,n2);
        Node rightLCA = LCA2(root.right,n1,n2);

        if(rightLCA == null){
            return leftLCA;
        }
        if(leftLCA == null){
            return rightLCA;
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 6,n2 = 5;
        System.out.print(LCA2(root,n1,n2).data);


    }
}
