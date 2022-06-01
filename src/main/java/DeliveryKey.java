public class DeliveryKey {

    private final Address address;
    private final Integer productId;

    public DeliveryKey(Address address, Integer productId) {
        this.address = address;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s", productId, address.getStreet(), address.getZipCode());
    }

}
