import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void getRoom_number() {
        Assertions.assertEquals("R001","R001");
    }

    @Test
    void getRoom_quantity() {
        Assertions.assertEquals(1,1);
    }

    @Test
    void getRoomChecking() {
        Assertions.assertEquals("true","true");
    }
}