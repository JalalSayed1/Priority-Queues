package minPriorityQueue;

/**
 * You are given n ropes of different lengths (expressed as integers), and you
 * are asked to connect them to form a single rope with the minimum cost. The
 * cost of connecting two ropes is equal to the sum of their lengths.
 * 
 */
public class RopeProblem {

    public static int calculateCost(int[] ropes) {
        int cost = 0;

        for (int i = 0; i < ropes.length; i++) {
            cost += ropes[i];
        }

        return cost;
    }

}
