package com.alevel.java.nix.stream.doublearray;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class FindElements {

    public DoubleSummaryStatistics findElements(double[] array) {

        return Arrays.stream(array)
                .summaryStatistics();
    }

}
