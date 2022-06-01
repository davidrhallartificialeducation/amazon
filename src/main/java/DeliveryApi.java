import java.util.Date;

public interface DeliveryApi {
    Date getDeliveryEstimate(DeliveryKey deliveryKey);
}
