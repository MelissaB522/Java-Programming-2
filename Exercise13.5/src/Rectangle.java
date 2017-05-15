/**
 * Class:       Rectangle
 * Developer:   Melissa Bakke
 * Date:        01/28/2017
 */
public class Rectangle extends GeometricObject{
    private double length;
    private double width;
    
    public Rectangle (double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }    
    
    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
    
}
