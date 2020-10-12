import java.util.Set;
import java.util.HashSet;

public class LinkedList {

  Node head;

  LinkedList(int data) {
    head = new Node(data);
  }

  void append(int data) {
    Node current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new Node(data);
  }

  public String toString() {
    Node current = head;
    StringBuilder stringValue = new StringBuilder(head.data + ", ");
    while (current.next != null) {
      stringValue.append(current.next.data + ", ");
      current = current.next;
    }
    return stringValue.toString();
  }

  public static void main(String[] args) {
    LinkedList testList = new LinkedList(1);
    testList.append(2);
    testList.append(2);
    testList.append(1);
    testList.append(2);
    testList.append(1);
    testList.append(1);
    testList.append(1);
    testList.append(2);
    testList.append(1);
    testList.append(1);
    testList.append(1);
    testList.append(1);
    LinkedList noDuplicates = removeDuplicates(testList);
    System.out.println(noDuplicates);
  }

  static LinkedList removeDuplicates(LinkedList listWithDuplicates) {
    // create a set
    // loop through and search set
    // if exists, delete node
    // if not exist, insert node in set
    Set<Integer> dupSet = new HashSet<>();
    Node current = listWithDuplicates.head;
    if (current == null) {
      return null;
    }
    dupSet.add(current.data);
    while (current != null) {
      if (current.next == null)
        return listWithDuplicates;
      if (dupSet.contains(current.next.data)) {
        current.next = current.next.next;
      } else {
        dupSet.add(current.next.data);
        current = current.next;
      }
    }
    return listWithDuplicates;
  }
}

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
  }
}
