public class EstimateLinkedList {

    public Node head;
    public Node tail;

    public EstimateLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.previous = head;
    }

    public void add(Node node) {
        node.next = head.next;
        head.next = node;
        node.previous = head;
    }

    public void remove(Node node) {
        Node next = node.next;
        Node previous = node.previous;
        next.previous = previous;
        previous.next = next;
    }

}
