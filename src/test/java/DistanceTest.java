import putcoTicketingSystem.calculateDistance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceTest
{
    @Test
    public void calculateDistance()
    {
        calculateDistance distance = new calculateDistance();
        assertEquals(distance.calculateDistanceBetweenPoints(2,4,2,20), 16);
    }
}
