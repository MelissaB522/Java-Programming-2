/**
 * Class:       Circle
 * Developer:   Melissa Bakke
 * Date:        01/28/2017
 */
public class Circle extends GeometricObject{
    private double radius;
    
    public Circle (double radius){
        this.radius = radius;
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
        
    @Override
    public double getArea() {
        return 3.14 * (getRadius() * getRadius());
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * getRadius();
    }
}
