package com.alevel.java.nix.data.duration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LongestDuration {

    public Duration getLongestTime(List<LocalDateTime> dataList) {

        Arrays.sort(dataList.toArray());

        return Duration.between(dataList.get(0), dataList.get(dataList.size() - 1));
    }

}
