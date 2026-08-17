public class MaximumProfitAnalyzer {

    public static int maximumProfit(int[] profit) {

        int currentSum = profit[0];
        int maxSum = profit[0];

        for (int i = 1; i < profit.length; i++) {

            currentSum = Math.max(profit[i],
                                  currentSum + profit[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] profit = {-2, 3, -1, 5, -6, 4};

        int result = maximumProfit(profit);

        System.out.println("Maximum Profit = " + result);
    }
}