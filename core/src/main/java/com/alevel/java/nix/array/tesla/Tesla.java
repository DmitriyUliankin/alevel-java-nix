package com.alevel.java.nix.array.tesla;

import java.util.Optional;

public class Tesla {

    private final double profit;
    private final int purchaseDay;
    private final int saleDay;
    private final double[] priceHistory;

    private Tesla(double profit, int purchaseDay, int saleDay, double[] priceHistory) {
        this.profit = profit;
        this.purchaseDay = purchaseDay;
        this.saleDay = saleDay;
        this.priceHistory = priceHistory;
    }

    public static Optional<Tesla> of(double... priceHistory) {
        int length = priceHistory.length;
        if (length == 0) {
            return Optional.empty();
        }
        int purchaseDay = 0;
        int saleDay = 0;
        double profit = 0.0;
        for (int day = 1, minPriceDay = 0; day < length; day++) {
            double price = priceHistory[day];
            double minPrice = priceHistory[minPriceDay];
            if (price < minPrice) {
                minPriceDay = day;
                continue;
            }
            double difference = price - minPrice;
            if (difference > profit) {
                purchaseDay = minPriceDay;
                saleDay = day;
                profit = difference;
            }
        }
        return Optional.of(new Tesla(profit, purchaseDay, saleDay, priceHistory));
    }

    public double getProfit() {
        return profit;
    }

    public int getPurchaseDay() {
        return purchaseDay;
    }

    public int getSaleDay() {
        return saleDay;
    }

    public double getPurchasePrice() {
        return priceHistory[purchaseDay];
    }

    public double getSalePrice() {
        return priceHistory[saleDay];
    }

}
