/**
 * Class:       TestProgram
 * Developer:   Melissa Bakke
 * Date:        01/26/2017
 */

public class TestProgram {
    public static void main(String[] args) {        
        Circle circle1 = new Circle(2.5);
        Circle circle2 = new Circle(4.25);
        Rectangle rec1 = new Rectangle(2, 4);
        Rectangle rec2 = new Rectangle(1, 3);

        System.out.println(circle1.compareTo(circle2));
        System.out.println(rec1.compareTo(rec2));
    }
}
