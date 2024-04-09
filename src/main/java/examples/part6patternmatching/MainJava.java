package examples.part6patternmatching;

import java.util.List;
import java.util.Random;

public class MainJava {
    public static void main(String[] args) {
        Random random = new Random();
        int x = random.nextInt(10);

        String result;
        switch (x) {
            case 0:
                result = "Zero";
                break;
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            default:
                result = "Other";
        }

        System.out.println(x);
        System.out.println(result);

        // Matching on class

        class Rectangle {
            int a, b;

            Rectangle(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }

        List<Rectangle> rectangles = List.of(new Rectangle(2, 2), new Rectangle(2, 3));

        for (Rectangle rectangle : rectangles) {
            if (rectangle.a == rectangle.b) {
                System.out.println("Square with A: " + rectangle.a);
            } else {
                System.out.println("Rectangle with A: " + rectangle.a + ", B: " + rectangle.b);
            }
        }
    }
}
