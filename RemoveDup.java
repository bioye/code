import java.util.Set;
import java.util.HashSet;

public class RemoveDup {

  public static void main(String[] args) {
    Node node = new Node(0);
    Node linkedList = new Node(node);
    linkedList.append(new Node(1));
    linkedList.append(new Node(2));
    linkedList.append(new Node(2));
    linkedList.append(new Node(2));
    linkedList.append(new Node(3));
    linkedList.append(new Node(4));
    linkedList.append(new Node(1));
    linkedList.append(new Node(2));
    linkedList.append(new Node(3));
    linkedList.append(new Node(4));
    System.out.println(linkedList);
    System.out.println(removeDuplicates(linkedList));
    //System.out.println(removeDupsNoBuffer(linkedList));
  }

  static Node removeDuplicates(Node head) {
    Node node = head.head;
    // System.out.println("outside" + node);
    Set<Node> set = new HashSet<>();
    while (node.next != null) {
      if(set.contains(node)) {
        //System.out.println("before" + node);
        //System.out.println("set: " + set);
        node = delete(node);
        //System.out.println("after" + node);
      } else {
        set.add(node);
      }
    }
    return node.head;
  }

  // No buffer.
  static Node removeDupsNoBuffer(Node head) {
    Node node = head;
    while (node.next != null) {
      Node next = node.next;
      while (next != null) {
        if (node == next) {
          next = deleteNode(next);
        }
      }
      if (node.next == null) {
        return node;
      } else {
        node = node.next;
      }
    }
    return node;
  }

  static Node delete(Node node){
    if(node==null){
      return null;
    }
    if(node.next==null&&node.previous==null){
      return null; 
    }
    if(node.next!=null){
      node.next.previous = node.previous;
    }
    if(node.previous!=null){
      node.previous.next = node.next;
    }
    return node.next!=null? node.next:node.previous;
  }

  static Node deleteNode(Node node) {
    if (node.next == null)
      return node;
    if (node.previous != null) {
      node.previous.next = node.next;
    }
    node.next.previous = node.previous;
    System.out.println("node: " + node);
    return node.next;
  }

  static class Node {
    int size;
    Node head;
    Node end;
    int data;
    Node next;
    Node previous;

    Node(int data) {
      this.data = data;
    }

    Node(Node head) {
      this.data = head.data;
      this.head = head;
      this.end = head;
      size=1;
    }

    Node append(Node node) {
      node.head = head;
      end.next = node;
      node.previous = end;
      end = node;
      size++;
      return head;
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof Node)) {
        return false;
      }
      Node node = (Node)object;
      return this.data == node.data;
    }

    @Override
    public int hashCode() {
      return data;
    }

    @Override
    public String toString() {
      if (head == null) {
        return "";
      }
      Node node = head;
      StringBuilder builder = new StringBuilder();
      builder.append(node.data);
      while (node.next != null) {
        node = node.next;
        builder.append(", ");
        builder.append(node.data);
      }
      return builder.toString();
    }
  }
  
}
