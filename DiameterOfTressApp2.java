import java.util.*;
public class DiameterOfTressApp2 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left= null;
            this.right = null;
        }
    }
    public static int Height(Node root){
        if(root == null){
            return 0;
        }
        int lh = Height(root.left);
        int rh = Height(root.right);
        return Math.max(lh,rh) + 1;
    }
    public static int Diameter(Node root){
       if(root == null){
           return 0;
       }
       int leftd = Diameter(root.left);
       int rid= Diameter(root.right);
       int lefth = Height(root.left);
       int rih = Height(root.right);

       int self = lefth + rih + 1;
       return Math.max(self,Math.max(leftd,rid));
    }
    static class Info{
        int Diam;
        int hei;
        public Info(int Diam,int hei){
            this.Diam = Diam;
            this.hei = hei;
        }
    }
    public static Info diamter(Node root){
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diamter(root.left);
        Info RightInfo = diamter(root.right);

        int Diam = Math.max(Math.max(leftInfo.Diam,RightInfo.Diam),leftInfo.hei + RightInfo.hei + 1);
        int hei = Math.max(leftInfo.hei, RightInfo.hei) + 1;

        return new Info(Diam,hei);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print(diamter(root).Diam);
    }
}
