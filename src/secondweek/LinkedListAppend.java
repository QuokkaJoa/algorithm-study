package secondweek;

public class LinkedListAppend {

  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node head;

  public LinkedListAppend(int value) {
    this.head = new Node(value);
  }

  public void append(int value) {
    Node cur = this.head;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = new Node(value);
  }

  public void printAll() {
    Node cur = this.head;
    while (cur != null) {
      System.out.println(cur.data);
      cur = cur.next;
    }
  }

  public Node getNode(int index) {
    Node cur = this.head;
    int curIndex = 0;

    while (curIndex != index) {
      cur = cur.next;
      curIndex += 1;
    }

    return cur;
  }

  public void addNode(int index, int value) {
    Node newNode = new Node(value);
    if (index == 0) {
      newNode.next = this.head;
      this.head = newNode;
      return;
    }

    Node prevNode = this.getNode(index - 1);
    Node nextNode = prevNode.next;
    prevNode.next = newNode;
    newNode.next = nextNode;
  }
}
