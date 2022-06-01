import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class DeliveryCacheTest {

    private static final Integer CAPACITY = 2;

    DeliveryCache deliveryCache;

    @BeforeEach
    void setup() {
        deliveryCache = new DeliveryCache(CAPACITY);
    }

    @Test
    void testCache() {
        Date date = new Date();
        DeliveryKey key = mock(DeliveryKey.class);
        deliveryCache.store(key, date);
        Date retrievedDate = deliveryCache.lookup(key);
        assertEquals(date, retrievedDate);
    }

    @Test
    void testCapacity() {
        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();

        DeliveryKey key1 = mock(DeliveryKey.class);
        DeliveryKey key2 = mock(DeliveryKey.class);
        DeliveryKey key3 = mock(DeliveryKey.class);

        deliveryCache.store(key1, date1);
        deliveryCache.store(key2, date2);
        deliveryCache.store(key3, date3);

        Date actual = deliveryCache.lookup(key1);

        assertNull(actual);
    }

}
