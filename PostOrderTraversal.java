import java.util.*;
public class PostOrderTraversal {
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
        public static Node buildTrees(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node NewNode = new Node(nodes[idx]);
            NewNode.left = buildTrees(nodes);
            NewNode.right = buildTrees(nodes);

            return NewNode;
        }
        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTrees tree = new BinaryTrees();
        Node root = tree.buildTrees(nodes);
        tree.postOrder(root);
    }
}
