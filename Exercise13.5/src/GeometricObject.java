/**
 * Class:       GeometricObject
 * Developer:   Melissa Bakke
 * Date:        01/26/2017
 */
public abstract class GeometricObject implements Comparable<GeometricObject>{
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() {
    dateCreated = new java.util.Date();
  }

  /** Construct a geometric object with color and filled value
     * @param color
     * @param filled */
  protected GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  /** Return color
     * @return  */
  public String getColor() {
    return color;
  }

  /** Set a new color
     * @param color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean,
   *  the get method is named isFilled
     * @return  */
  public boolean isFilled() {
    return filled;
  }

  /** Set a new filled
     * @param filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /** Get dateCreated
     * @return  */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  @Override
  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color +
      " and filled: " + filled;
  }

  /** Abstract method getArea
     * @return  */
  public abstract double getArea();

  /** Abstract method getPerimeter
     * @return  */
  public abstract double getPerimeter();

    @Override
    public int compareTo(GeometricObject o) {
        return max(this, o);
    }
    
    public static int max (GeometricObject geo1, GeometricObject geo2){
        if (geo1.getArea() > geo2.getArea()){
            System.out.print("The first object is bigger. ");
            return 1;
        } 
        else if (geo1.getArea() < geo2.getArea()){
            System.out.print("The first object is smaller. ");
            return -1;
        }
        else {
            System.out.print("The objects are the same size. ");
            return 0;
        }
    }
}