package level.first.task.first;

import java.util.HashSet;
import java.util.Set;

public class UniqueElem {
    public int getUniqueElements(int[] array) {
        Set<Integer> uniqueEl = new HashSet<>();
        for (int x : array) {
            uniqueEl.add(x);
        }
        return uniqueEl.size();
    }
}
