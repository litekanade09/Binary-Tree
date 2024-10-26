import java.util.*;
public class MinDistanceBetNodes {
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
    public static Node MinLCA(Node root,int n1,int n2){
        if(root == null|| root.data == n1 || root.data == n2){
            return root;
        }
        Node LeftLCA = MinLCA(root.left,n1,n2);
        Node RightLCA = MinLCA(root.right,n1,n2);

        if(LeftLCA == null){
            return RightLCA;
        }
        if(RightLCA == null){
            return LeftLCA;
        }
        return root;
    }

    public static int LCAdDist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int laftDist = LCAdDist(root.left,n);
        int RightDist = LCAdDist(root.right,n);

        if(laftDist == -1 && RightDist == -1){
            return -1;
        }else if(laftDist == -1){
            return RightDist + 1;
        }else{
            return laftDist+1;
        }
    }
    public static int MinDist(Node root,int n1,int n2){
        Node LCA = MinLCA(root,n1,n2);
        int dist1 = LCAdDist(LCA,n1);
        int dist2 = LCAdDist(LCA,n2);
        return dist1 + dist2;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4,n2 = 6;
        System.out.print(MinDist(root,n1,n2));
    }
}
