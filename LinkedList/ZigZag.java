package LinkedList;
//  import java.util.*;
public class ZigZag {
  public static class Node{
    int data;
    Node next;

    public Node(int data){
      this.data = data;
      this.next = next;
    }
  }
  public static Node head;
  public static Node tail;
  public static int size;

  public void addFirst(int data){
    //create new node
    Node newNode = new Node(data);
    size++;
    if(head == null){
      head = tail = newNode;
      return;
    }
    
    newNode.next = head;
    head = newNode;
  }


  public void addLast(int data){
    Node newNode = new Node(data);
    size++;
    if(head == null){
      head = tail = newNode;
      return;
    }
     tail.next = newNode;
     tail = newNode;
  }

  public void printLL(){
  Node temp = head;
 if(head == null){
  System.out.print("LL is empty.");
 }
 while(temp!=null){
  System.out.print(temp.data+"->");
  temp = temp.next;
 }
 System.out.println();
  }

  public void zigZag(){
    //find mid
 Node slow = head;
 Node fast = head.next;
 while(fast!=null && fast.next!=null){
  slow = slow.next;
  fast = fast.next.next;
 }
 Node mid = slow;

 // reverse 2nd half
  Node prev = null;
  Node curr = mid.next;
  mid.next = null;
  Node next;
  while(curr!=null){
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }
  Node left = head;
  Node right = prev;
  Node nextL, nextR;

 // alt merge - zigzag merge
 while(left!=null && right!=null){
  nextL = left.next;
  left.next = right;
  nextR = right.next;
  right.next = nextL;

  right = nextR;
  left = nextL;
 }
  }
  public static void main(String[] args) {
     ZigZag ll = new ZigZag();
     ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.addLast(5);
    ll.printLL();
    ll.zigZag();
    ll.printLL();
  }
}
