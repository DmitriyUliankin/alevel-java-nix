package level.first.task.third;

public class TriangleSquare {
    public double square(double x1, double x2, double x3, double y1, double y2, double y3) {
        double square = 0;
        double a = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        double b = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));
        double c = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2));
        if (a + b <= c || a + c <= b || a + c <= b) {
            return 0;
        } else {
            double p = (a + b + c) / 2.0;
            square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return square;
    }
}