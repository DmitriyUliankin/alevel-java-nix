package task.second;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindUniqueElementTest {

    private static FindUniqueElement uniqueElement;

    @BeforeEach
    public void setUp() {
        uniqueElement = new FindUniqueElement();
    }

    @Test
    public void testInt() {
        Integer[] values = new Integer[]{5, 5, 3, 3, 8, 8, 9, 9, 10};
        assertEquals(Optional.of(10), uniqueElement.getUniqueElement(values));
    }

    @Test
    public void testDouble() {
        Double[] values = new Double[]{5.0, 5.0, 3.0, 3.0, 8.0, 8.0, 9.0, 9.0, 10.0};
        assertEquals(Optional.of(10.0), uniqueElement.getUniqueElement(values));
    }

    @Test
    public void testNumericString() {
        String[] values = new String[]{"5", "5", "3", "3", "8", "8", "9", "9", "10"};
        assertEquals(Optional.of("10"), uniqueElement.getUniqueElement(values));
    }

    @Test
    public void testString() {
        String[] values = new String[]{"A", "B", "A", "B", "C"};
        assertEquals(Optional.of("C"), uniqueElement.getUniqueElement(values));
    }

    @Test
    public void testNull() {
        assertThrows(NullPointerException.class, () -> Objects.requireNonNull(
                uniqueElement.getUniqueElement(null)).orElseThrow(NullPointerException::new));
    }

    @Test
    public void testZeroLength() {
        String[] values = new String[]{};
        assertThrows(IllegalArgumentException.class, () -> Objects.requireNonNull(
                uniqueElement.getUniqueElement(values)).orElseThrow(IllegalArgumentException::new));
    }

}