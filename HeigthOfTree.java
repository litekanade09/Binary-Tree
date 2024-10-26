import java.util.*;
public class HeigthOfTree {
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
    static class Binary{
        static int idx = -1;
        public static Node buildTree(int node[]){
            idx++;
            if(node[idx] == -1){
                return null;
            }
            Node NewNode = new Node(node[idx]);
            NewNode.left = buildTree(node);
            NewNode.right = buildTree(node);
            return NewNode;
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh,rh) + 1;
        }
    }
    public static void main(String[] args) {

        Binary tree = new Binary();


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print(tree.height(root));
    }
}
