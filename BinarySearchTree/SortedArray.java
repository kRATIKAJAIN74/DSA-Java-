import java.util.*;
public class SortedArray {
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
  public static Node isBalanced(int arr[],int st,int end){
    if(st>end){
      return null;
    }
      int mid = (st+end)/2;
      Node root = new Node(arr[mid]);
      root.left = isBalanced(arr, st, mid-1);
      root.right = isBalanced(arr, mid+1, end);
      return root;
    
  }

   public static void preOrder(Node root){
    if(root==null){
      return ;
    }
    System.out.print(root.data+" ");
    preOrder(root.left);
    preOrder(root.right);
   
  }
  public static Node balanceBST(Node root){
    //inorder
   ArrayList<Integer> inorder = new ArrayList<>();
   getInOrder(root, inorder);
    //balance bst
    root = createBST(inorder, 0, inorder.size()-1);
    return root;
  }

  public static void getInOrder(Node root, ArrayList<Integer> inorder){
    if(root==null) return;
    getInOrder(root.left,inorder);
    inorder.add(root.data);
    getInOrder(root.right,inorder);
  }

  public static Node createBST(ArrayList<Integer> inorder, int st, int end){
    if(st>end){
      return null;
    }
      int mid = (st+end)/2;
      Node root = new Node(inorder.get(mid));
      root.left = createBST(inorder, st, mid-1);
      root.right = createBST(inorder, mid+1, end);
      return root;
  }
  public static void main(String[] args) {
    // int arr[] = {3,5,6,8,10,11,12};
    // Node root = isBalanced(arr, 0, arr.length-1);
    // preOrder(root);
     Node root = new Node(8);
    root.left = new Node(6);
    root.left.left = new Node(5);
     root.left.left.left = new Node(3);

      root.right = new Node(10);
    root.right.right = new Node(11);
    root.right.right.right = new Node(12);
   root = balanceBST(root);
   preOrder(root);
  }
}
