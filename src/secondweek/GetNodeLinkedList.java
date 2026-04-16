package secondweek;

public class GetNodeLinkedList {

  public static void main(String[] args) {
    LinkedListAppend linkedList = new LinkedListAppend(5);
    linkedList.append(12);

    System.out.println(linkedList.getNode(1).data);

  }

}
