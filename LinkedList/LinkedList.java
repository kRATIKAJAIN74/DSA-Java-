package LinkedList;

public class LinkedList {
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
  public static Node temp;
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
 temp = head;
 if(head == null){
  System.out.print("LL is empty.");
 }
 while(temp!=null){
  System.out.print(temp.data+"->");
  temp = temp.next;
 }
 System.out.println();
  }


  public void midAdd(int idx, int data){
    Node newNode = new Node(data);
    size++;
    temp = head;
    int i=0;
    while(i<idx-1){
      temp = temp.next;
      i++;
    }
    //steps
    newNode.next = temp.next;
    temp.next = newNode;
  }


  public int remFirst(){
    if(size == 0){
      System.out.println("LL is empty");
      return Integer.MIN_VALUE;
    } else if(size == 1){
      int val  = head.data;
      head = tail = null;
      size = 0;
      return val;
    }
    int val = head.data;
    head = head.next;
    size--;
    return val;
  }

  public int remLast(){
    if(size == 0){
      System.out.println("LL is empty");
      return Integer.MIN_VALUE;
    } else if(size == 1){
    int val = head.data;
    head = tail = null;
    size = 0;
    return val;
    }
     temp = head;
     for(int i=0;i<size-2;i++){
      temp = temp.next;
     }
     int val = temp.next.data;
     temp.next = null;
      temp = tail;
      size--;
      return val;
  }
  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
   
    ll.addFirst(2);
  
    ll.addFirst(1);
   
    ll.addLast(4);
   
    ll.addLast(5);
    
    ll.midAdd(2, 3);
    ll.printLL();
    // System.out.println(ll.size);
    ll.remFirst();
    ll.printLL();
    ll.remLast();
    ll.printLL();
    System.out.println( "size " + ll.size);
  }
  
}
