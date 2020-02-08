package com.alevel.java.nix.array.tesla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeslaTest {

    @Test
    void ifPriceHistoryIsEmpty_shouldReturnEmpty() {
        assertTrue(Tesla.of().isEmpty());
        assertTrue(Tesla.of(new double[0]).isEmpty());
    }

    @Test
    void ifPriceHistoryHasOneDay_itShouldBeSaleAndPurchase() {
        test(0, 0, 5.6);
        test(0, 0, 3.4);
        test(0, 0, 10.0);
        test(0, 0, -10.0);
        test(0, 0, 0.0);
    }

    @Test
    void shouldFindBestPossiblePurchaseAndSaleDay() {
        test(0, 1, 3.2, 4.3);
        test(0, 0, 3.2, 3.1);
        test(1, 2, 5.2, 5.1, 5.3);
        test(0, 1, 5.0, 7.0, 5.0, 7.0);
        test(2, 5, 4.3, 4.1, 4.0, 4.4, 4.3, 4.5);
        test(2, 5, 4.3, 4.1, 4.0, 4.4, 4.3, 4.5, 4.5);
        test(2, 5, 4.3, 4.1, 4.0, 4.4, 4.3, 4.5, 4.4);
        test(2, 5, 4.3, 4.1, 4.0, 4.4, 4.3, 4.5, 3.1);
        test(5, 6, 4.3, 4.1, 4.0, 4.4, 4.3, 0.5, 3.1);
        test(1, 3, 15.0, 9.4, 9.8, 14.0, 12.3, 10.0, 8.0);
    }

    private static void test(int expectedPurchaseDay, int expectedSaleDay, double... prices) {
        var result = Tesla.of(prices);
        assertTrue(result.isPresent());

        var operationRecord = result.get();
        assertEquals(expectedPurchaseDay, operationRecord.getPurchaseDay());
        assertEquals(expectedSaleDay, operationRecord.getSaleDay());

        double expectedPurchasePrice = prices[expectedPurchaseDay];
        assertEquals(expectedPurchasePrice, operationRecord.getPurchasePrice());

        double expectedSalePrice = prices[expectedSaleDay];
        assertEquals(expectedSalePrice, operationRecord.getSalePrice());

        double expectedProfit = expectedSalePrice - expectedPurchasePrice;
        assertFalse(expectedProfit < 0); // profit should be not be negative
        assertEquals(expectedProfit, operationRecord.getProfit());
    }
}