package com.alevel.java.nix.stream.primenumbers;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetPrimeNumbers {

    public List<BigInteger> getPrimeNumbers(int limit) {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime)
                .limit(limit)
                .collect(Collectors.toList());
    }

}
