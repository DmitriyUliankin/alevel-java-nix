package level.first.task.first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueElemTest {

    private UniqueElem elem = new UniqueElem();

    @Test
    public void getUnique() {
        assertEquals(1, elem.getUniqueElements(new int[]{0, 0, 0, 0}));
        assertEquals(4, elem.getUniqueElements(new int[]{1, 4, 5, 1, 1, 3}));
        assertEquals(6, elem.getUniqueElements(new int[]{1, 2, 3, 4, -5, 5}));
    }
}