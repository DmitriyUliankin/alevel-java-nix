package level.first.task.third;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleSquareTest {

    private TriangleSquare triangle = new TriangleSquare();

    @Test
    public void square() {
        assertEquals(6.0, triangle.square(0, 3, 0, 0, 0, 4));
        assertEquals(0, triangle.square(0, 0, 0, 0, 0, 0));
        assertEquals(0, triangle.square(1, 1, 1, 1, 1, 1));
    }
}