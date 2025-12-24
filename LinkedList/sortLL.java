package LinkedList;

public class sortLL {
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

  public Node mergeSort(Node head){
    if(head==null || head.next==null){
      return head;
    }
    // find mid
  Node mid = getMid(head);
    // left & right
  Node rightHead = mid.next;
  mid.next =null;
   Node newLeft = mergeSort(head);
   Node newRight = mergeSort(rightHead); 
    //merge
    return merge(newLeft,newRight);
  }
  public Node getMid(Node head){
    Node slow = head;
    Node fast = head.next;
    while(fast!=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  public Node merge(Node head1, Node head2){
 Node mergeLL = new Node(-1);
 Node temp = mergeLL;
 while(head1!=null && head2!=null){
  if(head1.data<=head2.data){
    temp.next = head1;
    head1 = head1.next;
    temp = temp.next;
  } else {
     temp.next = head2;
    head2 = head2.next;
    temp = temp.next;
  }
 }
 while(head1!=null){
  temp.next = head1;
  head1 = head1.next;
  temp = temp.next;
 }
 while(head2!=null){
  temp.next = head2;
  head2 = head2.next;
  temp = temp.next;
 }
 return mergeLL.next;
  }
  public void addFirst(int data){
    //create new node
    Node newNode = new Node(data);
    if(head == null){
      head = tail = newNode;
      return;
    }
    
    newNode.next = head;
    head = newNode;
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
 System.out.println("null");
  }
  public static void main(String[] args) {
    sortLL ll = new sortLL();
 ll.addFirst(4);
 ll.addFirst(6);
 ll.addFirst(3);
 ll.addFirst(8);
 ll.addFirst(1);
 ll.addFirst(2); // 2-1-8-3-6-4
 ll.printLL();
  ll.head = ll.mergeSort(ll.head);
  ll.printLL();
  }
}
