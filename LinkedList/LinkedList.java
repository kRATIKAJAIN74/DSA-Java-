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

  public int iteSearch(int key){//O(n)
    temp = head;
    int i=0;
    while(temp!=null){
      if(temp.data == key){
        return i;
      }
      temp = temp.next;
      i++;
    }
    // not found
    return -1;
  }


  public void reverse(){ //O(n)
    Node prev = null;
    Node curr = tail = head;
    Node next;

    while(curr!= null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
  }

  public void deleteNthfromEnd(int n){
    int size = 0;
    temp = head;
    while(temp!= null){
      temp = temp.next;
      size++;
    }
    if(n == size){
      head = head.next;// removeFirst
      return;
    }

    //size-n
    int i=1;
    int iToFind = size-n;
    Node prev = head;
    while(i< iToFind){
    prev = prev.next;
    i++;

    }
    prev.next = prev.next.next;
    return;

  }


  public Node findMid(Node head){ //helper
  Node slow = head;
  Node fast = head;
  while(fast!=null && fast.next!=null){
    slow = slow.next;//+1
    fast = fast.next.next;//+2
  }
  return slow;// slow midnode
  }

  public boolean isPalindrome(){
    if(head==null || head.next==null){
      return true;
    }
    //step 1 - find mid
  Node midNode = findMid(head);
    //step 2 - 2nd half reverse
  Node prev = null;
  Node curr = midNode;
  Node next;
  while(curr!=null){
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }
  Node right = prev;//right half head
  Node left  = head;//left half head

    //step 3 - check 1st half == 2nd half
    while(right!=null){
      if(left.data!= right.data){
        return false;
      }
      left = left.next;
      right = right.next;
    }
    return true;
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
   
    // ll.addFirst(2);
  
    // ll.addFirst(1);
   
    ll.addLast(1);
    ll.addLast(2);
     ll.addLast(5);
    ll.addLast(1);
    
    // ll.midAdd(2, 3);
    // ll.printLL();
    // ll.reverse();
    // ll.printLL();
    // ll.deleteNthfromEnd(3);

    ll.printLL();//1->2->2->1
    System.out.println(ll.isPalindrome());
    
  }
  
}
