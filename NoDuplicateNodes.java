import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class NoDuplicateNodes{

  public static void main(String[] args) {
    Node node0 = new Node(6, null);
    new Node(1, node0);
    new Node(7, node0);
    Node node1 = new Node(2, null);
    new Node(9, node1);
    new Node(5, node1);
    /*
    new Node(6, head);
    new Node(5, head);
    new Node(8, head);
    new Node(5, head);
    new Node(2, head);
    new Node(9, head);
    new Node(8, head);
    */
    //231346585798
    //2->3-6->5->8->5
    System.out.println(node0);
    System.out.println("");
    System.out.println(sumListsAgain(node0, node1));
  }

  static int sumListsAgain(Node n0, Node n1){
    Node resultNode = new Node(0, null);
    Node current = resultNode;
    int size = 0;
    while(n0!=null && n1!=null){
      size++;   
      if(n0!=null){
        current.data+=n0.data;
        n0 = n0.next;
      }
      if(n1!=null){
        current.data+=n1.data;
        n1 = n1.next;
      }
      if((n0!=null)&&(n1!=null)){
        Node node = new Node(0, resultNode);
        current = node;
      }
    }
      
    current = resultNode;
    int sum=0;
    int unit = (int)Math.pow(10, size-1);
    while(current!=null){
      sum+=(current.data*unit);
      unit/=10;
      current = current.next;
    }
    return sum;
  }
  

  static int sumLists(Node n0, Node n1){
    int sum = 0;
    int unit = 1;
    while(!(n0==null && n1==null)){
      if(n0!=null){
        sum+=(n0.data*unit);
        n0 = n0.next;
      }
      if(n1!=null){
        sum+=(n1.data*unit);
        n1 = n1.next;
      }
      unit*=10;
    }  
    return sum;
  }
  

  static Node partition(Node node, int partition){
    Node head = node;
    boolean previousIsGreater = false;
    Node current = node;
    Node prev = null;
    while(current!=null){
      if(current.data<partition){ 
        if(previousIsGreater){
          prev.next = current.next;
          current.next = head;
          head = current;
          head.head = current;
          current = prev.next;
        }
        else{
          prev = current;
          current = current.next;
        }
      }
      else{
        previousIsGreater = true;
        prev = current;
        current = current.next;
      }
    }
    return head;
  }
  

  static void deleteNode(Node node){
    Node current = node.head;
    boolean notFound = true;
    while(notFound){
      if(current.next.data == node.data){
        current.next = node.next;
        notFound=false;
        break;
      }
      current = current.next;
    }
    System.out.println(current.head);
  }
  

  static int calcKthToLast(Node linkedList, int kToLast){
    if(linkedList == null){
      return -1;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    map.put(0, linkedList.data);
    Node current = linkedList;
    while(current.next!=null){
      map.put(++count, current.next.data);
      current = current.next;
    }
    if(kToLast-count>1||kToLast<1){
      return -1;
    }
    return map.get(count+1-kToLast);
  }
  

  static Node removeDuplicateNoBuffer(Node node){
    Node ref = node;
    Node current = node;
    while(ref.next!=null){
      while(current.next!=null){
        if(ref.data==current.next.data){
          current.next = current.next.next;
        }
        else{
          current = current.next;
        }
      }
      if(ref.next==null){
        return ref;
      }
      ref = ref.next;
      current = ref;
    }
    return node;
  }
  

  static Node removeDuplicates(Node n){
      if(n==null){
        return n;
      }
      Node head = n;
      Set<Integer> set = new HashSet<>();
      set.add(n.data);
      Node current = n;
      while(current.next!=null){
        if(set.contains(current.next.data)){
          current.next = current.next.next;
        }
        else{
          set.add(current.next.data);
          current = current.next;
        }
      }
      return head;
  }

  static class Node{
    Node head;
    int data;
    Node next;

    Node(int data, Node head){
      this.data = data;
      if(head==null){
        this.head = this;
        return;
      }
      else{
        this.head = head;
      }
      Node current = head;
      while(current.next!=null){
        current = current.next;
      }
      current.next = this;
    }

    public String toString(){
      if(head==null){
        return "";
      }
      StringBuilder builder = new StringBuilder();
      builder.append(head.data);
      Node current = head;
      while(current.next!=null){
        builder.append(", ");
        builder.append(current.next.data);
        current = current.next;
      }
      return builder.toString();
    }
  }
}