package task.second;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FindUniqueName {

    public String getUniqueElement(List<String> names) {

        Map<String, Integer> map = new HashMap<>();

        for (String name : names) {
            map.put(name, 0);
        }

        return map.keySet()
                .stream()
                .max(Comparator.naturalOrder())
                .orElse("something went wrong");
    }

}
