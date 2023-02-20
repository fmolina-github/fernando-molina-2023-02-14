package com.ninjarm.exercise;

public class EvaluationController {

    /**
     * 
     * Calculate the maximum value that a thief could carry
     * 
     * @param totalWeight   The total amount of weight you can carry
     * @param weights       An array of the weights of all the items
     * @param values        An array of the values of all of the items
     * @return              Maximum value that a thief could carry
     * @throws Exception    Exception for not valid conditions
     */
    public int knapsack(int totalWeight, int[] weights, int[] values) throws Exception {

        if (totalWeight <= 0) {
            throw new Exception("Total weight is not greater than 0");
        } else if (weights == null || weights.length == 0) {
            throw new Exception("Weights are noot defined");
        } else if (values == null || values.length == 0) {
            throw new Exception("Values are not defined");
        } else if (weights.length != values.length) {
            throw new Exception("Number of weights and values is different");
        }

        int maxIndValue = 0;
        int maxIncValue = 0;
        int currIndWeight = 0;
        int currIncWeight = 0;

        // Check individual weights
        for (int i = 0; i < weights.length; i++) {
            if (i == 0) {
                currIndWeight = weights[i];
                currIncWeight = weights[i];
                maxIndValue = values[i];
                maxIncValue = values[i];
            }
            if (weights[i] <= totalWeight) {
                if ((currIndWeight == weights[i] && values[i] > maxIndValue) || (currIndWeight < weights[i])) {
                    maxIndValue = values[i];
                    currIndWeight = weights[i];
                }
            }
            if ((i < weights.length - 1)) {
                currIncWeight = currIncWeight + weights[i + 1];
                if (currIncWeight <= totalWeight) {
                    maxIncValue = maxIncValue + values[i + 1];
                    if (currIncWeight == totalWeight) {
                        break;
                    }
                }
            }
        }

        return (maxIncValue >= maxIndValue)? maxIncValue : maxIndValue;
    }
}