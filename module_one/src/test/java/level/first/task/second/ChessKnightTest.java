package level.first.task.second;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessKnightTest {

    private ChessKnight knight = new ChessKnight();

    @Test
    public void getKnight() {
        assertTrue(knight.isMove(0, 2, 0, 2));
        assertTrue(knight.isMove(0, 0, 0, 0));
        assertTrue(knight.isMove(-1, -1, 1, 1));

        assertFalse(knight.isMove(0, 1, 1, 0));
        assertFalse(knight.isMove(1, 2, 3, 2));
    }
}
