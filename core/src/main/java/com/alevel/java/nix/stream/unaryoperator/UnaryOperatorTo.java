package com.alevel.java.nix.stream.unaryoperator;

import java.util.Collection;
import java.util.function.UnaryOperator;

public class UnaryOperatorTo {

    public <T> UnaryOperator<T> group(Collection<UnaryOperator<T>> unaryOperators) {
        return unaryOperators.stream()
                .reduce((a, b) -> e ->b.apply(a.apply(e)))
                .orElse(UnaryOperator.identity());
    }

}
