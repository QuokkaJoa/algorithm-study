package secondweek;

public class AddNodeLinkedList {
  public static void main(String[] args) {
    LinkedListAppend linkedList = new LinkedListAppend(5);
    linkedList.append(12);
    linkedList.append(8);
    linkedList.printAll();

    // [5]->[12]->[8]
    // head
    // [5]->[6]->[12]->[8]

    //       head
    //  head
    //  head ->prev_head
    //  [7] -> [5]->[6]->[12]->[8]



    linkedList.addNode(1, 6);

    linkedList.addNode(0, 7);
    linkedList.printAll();
    // [7]->[5]->[6]->[12]->[8]
  }
}
