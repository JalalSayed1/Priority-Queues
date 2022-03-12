package minPriorityQueue;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class RopeProblemTest {

    @Test
    public void testCalculateCostUnordered() {
        int[] ropes = { 4, 8, 3, 1, 6, 9, 12, 7, 2 };
        assertEquals(52, RopeProblem.calculateCost(ropes));
    }

    @Test
    public void testCalculateCostOrdered() {
        int[] ropes = { 4, 8, 3, 1, 6, 9, 12, 7, 2 };
        Arrays.sort(ropes);
        System.out.println(Arrays.toString(ropes));
        assertEquals(52, RopeProblem.calculateCost(ropes));
    }
}
