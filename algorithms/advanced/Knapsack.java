package advanced;

/** Simple implementation of the 0/1 Knapsack algorithm.
 * Uses bottom-up dynamic programming to solve the problem by iteratively solving a subset.
 * Time complexity: O(m * n), where m is the number of weights/values and n is the size of the capacity.
 * Space complexity: O(n)
 */
public class Knapsack {
    public static int getMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        // Validate the inputs
        if(capacity <= 0 || weights == null || values == null || weights.length != values.length) {
            return 0;
        }

        // Initialize the profit array to hold intermediate results.
        int[] profits = new int[capacity + 1];
        for(int i= 0; i < profits.length; i++) {
            profits[i] = 0;
        }

        // Iterate over the values/weights array and decreasingly over the capacity to calculate the profits.
        for(int i = 0; i < values.length; i++) {
            for(int c = capacity; c >= 0; c--) {
                //Process only if the weight is less than or equal to the capacity
                if(weights[i] <= c) {
                    profits[c] = Math.max(profits[c], profits[c - weights[i]] + values[i]);
                }
            }
        }
        return profits[capacity];
    }

    // Unit test
    public static void main(String[] args) {
        int capacity = 3;
        int[] weights = new int[] {1, 2, 3};
        int[] values = new int[] {3, 5, 4};

        int maxProfit = getMaxKnapsackProfit(capacity, weights, values);

        System.out.print("Expected Knapsack profit: 8; " + "Actual profit: " + maxProfit);
    }
}