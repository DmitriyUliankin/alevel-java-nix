package com.alevel.java.nix.data.duration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LongestDuration {

    public Duration getLongestTime(List<LocalDateTime> dataList) {

        var max = dataList.get(0);
        var min = dataList.get(1);

        for (LocalDateTime element : dataList) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }

        Arrays.sort(dataList.toArray());

        return Duration.between(dataList.get(0), dataList.get(dataList.size() - 1));
    }

}
