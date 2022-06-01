import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DeliveryCache {

    private final Integer capacity;

    private final Map<DeliveryKey, Node> estimates;

    private final EstimateLinkedList estimateLinkedList;

    public DeliveryCache(Integer capacity) {
        this.capacity = capacity;
        this.estimates = new HashMap<DeliveryKey, Node>(capacity);
        this.estimateLinkedList = new EstimateLinkedList();
    }

    public Date lookup(DeliveryKey key) {
        Node node = estimates.get(key);
        if (node == null) return null;
        return node.date;
    }

    public void store(DeliveryKey key, Date date) {
        Node node = estimates.get(key);
        if (node != null) {
            node.date = date;
            estimateLinkedList.remove(node);
        } else {
            node = new Node();
            node.date = date;
            node.key = key;
        }
        createCapacity();
        estimateLinkedList.add(node);
        estimates.put(key, node);
    }

    private void createCapacity() {
        if (estimates.size() == capacity) {
            Node node = estimateLinkedList.tail.previous;
            estimates.remove(node.key);
            estimateLinkedList.remove(node);
        }
    }
}
