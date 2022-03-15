package minPriorityQueue;

/**
 * You are given n ropes of different lengths (expressed as integers), and you
 * are asked to connect them to form a single rope with the minimum cost. The
 * cost of connecting two ropes is equal to the sum of their lengths.
 * 
 */
public class RopeProblem {

    public static int calculateCost(int[] ropes) {
        MinPriorityQueueUsingArrays mpq = new MinPriorityQueueUsingArrays(ropes);

        int cost = 0;
        int joinedRope;

        // until we have one rope in the queue, means all the ropes have been joined:
        while (mpq.size() > 1) { // O(n log n)
            // extract the smallest 2 ropes:
            joinedRope = mpq.extractMin() + mpq.extractMin(); // O(n log n)
            cost += joinedRope;
            // insert the new joined rope back to be re considered with the other ropes:
            mpq.insert(joinedRope); // O(n log n)
        }

        return cost;
    }

}
