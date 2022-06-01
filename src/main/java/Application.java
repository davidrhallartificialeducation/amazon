import java.util.Date;

public class Application {

    private final DeliveryApi deliveryApi;
    private final DeliveryCache deliveryCache;
    private final ProductApi productApi;

    public Application(DeliveryApi deliveryApi, DeliveryCache deliveryCache, ProductApi productApi) {
        this.deliveryApi = deliveryApi;
        this.deliveryCache = deliveryCache;
        this.productApi = productApi;
    }

    public Date displayDeliveryEstimate() {
        Address address = new Address(" 410 Terry Ave N", 98109);
        Product product = this.productApi.getClosestMatchingProduct("Nerf Gun");
        DeliveryKey deliveryKey = new DeliveryKey(address, product.getId());
        Date deliveryEstimate = this.deliveryCache.lookup(deliveryKey);

        if (deliveryEstimate == null) {
            deliveryEstimate = this.deliveryApi.getDeliveryEstimate(deliveryKey);
            this.deliveryCache.store(deliveryKey, deliveryEstimate);
        }

        return deliveryEstimate;
    }

}
