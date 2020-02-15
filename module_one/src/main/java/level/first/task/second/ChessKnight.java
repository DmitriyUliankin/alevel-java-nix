package level.first.task.second;

import java.util.Scanner;

public class ChessKnight {
    public boolean isMove(int xStart, int xEnd, int yStart, int yEnd) {
        int size = 8;
        Scanner scanner = new Scanner(System.in);
        boolean move = false;
        for (int i = 0; i < size; i++) {
            if (xStart == xEnd + i && yStart == yEnd + i)
                move = true;
            if (xStart == xEnd - i && yStart == yEnd - i)
                move = true;
        }
        return move;
    }
}
