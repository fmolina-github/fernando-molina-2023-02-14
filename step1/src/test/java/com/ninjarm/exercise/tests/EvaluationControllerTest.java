package com.ninjarm.exercise.tests;

import com.ninjarm.exercise.EvaluationController;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluationControllerTest {

    private EvaluationController sut;

    @Test
    public void testKnapsackHappyPathDiverseWeights() throws Exception {

        sut = new EvaluationController();

        int totalWeight = 10;
        int[] weights = {3, 6, 8};
        int[] values = {50, 60, 100};
        
        int maxValue = sut.knapsack(totalWeight, weights, values);

        assertEquals(110, maxValue);
    }

    @Test
    public void testKnapsackHappyPathSameWeights() throws Exception {

        sut = new EvaluationController();

        int totalWeight = 3;
        int[] weights = {3, 3, 3};
        int[] values = {50, 60, 100};
        
        int maxValue = sut.knapsack(totalWeight, weights, values);

        assertEquals(100, maxValue);
    }

    @Test
    public void testKnapsackHappyPathSameWeightsHighTotalWeight() throws Exception {

        sut = new EvaluationController();

        int totalWeight = 10;
        int[] weights = {3, 3, 3};
        int[] values = {50, 60, 100};
        
        int maxValue = sut.knapsack(totalWeight, weights, values);

        assertEquals(210, maxValue);
    }

    @Test
    public void testKnapsackHappyPathOneWeightAndValue() throws Exception {

        sut = new EvaluationController();

        int totalWeight = 10;
        int[] weights = {3};
        int[] values = {50};
        
        int maxValue = sut.knapsack(totalWeight, weights, values);

        assertEquals(50, maxValue);
    }

    @Test
    public void testKnapsackErrorZeroTotalWeight() {

        sut = new EvaluationController();

        int totalWeight = 0;
        int[] weights = {3, 3, 3};
        int[] values = {50, 60, 100};
        
        assertThrows(Exception.class, () -> sut.knapsack(totalWeight, weights, values));
    }

    @Test
    public void testKnapsackErrorWeightsGreaterValues() {

        sut = new EvaluationController();

        int totalWeight = 10;
        int[] weights = {3, 3, 3};
        int[] values = {50, 60};
        
        assertThrows(Exception.class, () -> sut.knapsack(totalWeight, weights, values));
    }

    @Test
    public void testKnapsackErrorValuesGreaterWeights() {

        sut = new EvaluationController();

        int totalWeight = 10;
        int[] weights = {3, 3};
        int[] values = {50, 60, 100};
        
        assertThrows(Exception.class, () -> sut.knapsack(totalWeight, weights, values));
    }

}