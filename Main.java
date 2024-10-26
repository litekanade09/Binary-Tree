import java.util.*;
public class Main {
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
    static class BinaryTrees{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node NewNode = new Node(nodes[idx]);
            NewNode.left = buildTree(nodes);
            NewNode.right = buildTree(nodes);

            return NewNode;
        }

        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTrees tree = new BinaryTrees();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.preorder(root);

    }
}
