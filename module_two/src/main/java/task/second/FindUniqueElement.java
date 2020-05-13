package task.second;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public final class FindUniqueElement {

    public <T> Optional<Object> getUniqueElement(T[] values) {

        if (values == null || values.length == 0) {
            return Optional.empty();
        }

        Map<T, Integer> map = new LinkedHashMap<>();

        for (T value : values) {
            map.putIfAbsent(value, 0);
            map.put(value, map.get(value) + 1);
        }

        return Optional.ofNullable(map.entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null));
    }

}
