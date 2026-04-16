package secondweek;

public class AppendLinkedList {
  public static void main(String[] args) {
    LinkedListAppend.Node node = new LinkedListAppend.Node(5);
    System.out.println(node.data + " " + node.next);

    LinkedListAppend.Node nextNode = new LinkedListAppend.Node(3);
    node.next = nextNode;

    LinkedListAppend linkedList = new LinkedListAppend(5);

    System.out.println(linkedList.head.data);
    linkedList.append(12);

    // head
    // [5] -> [12]
    linkedList.append(8);
    linkedList.printAll();
    // [5] -> [12] -> [8]
  }
}
