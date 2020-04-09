package task.second;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class FindUniqueName {

    public String getUniqueElement(List<String> names) {

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String name : names) {
            map.putIfAbsent(name, 0);
            map.put(name, map.get(name) + 1);
        }

        return map.entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

}
