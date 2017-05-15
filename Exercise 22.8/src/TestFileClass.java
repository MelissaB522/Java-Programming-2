import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Class:       TestFileClass
 * Developer:   Melissa Bakke
 * Date:        03/04/2017
 * Purpose:     
 */


public class TestFileClass {
    public static void main(String[] args) throws Exception {
        printFile();
    }
    
    public final static int NUMBERONLINE = 10;
    public static void printFile(){
        // read data
        long count = 0;
        try (DataInputStream dis = new DataInputStream(new FileInputStream("PrimeNumbers.dat"))) {
            long total = 0;
            System.out.println("PrintFile is printing: \n");
            while (dis.available() > 0) {                
                long temp = dis.readLong();
                total += temp;
                count++;
                if ((count % NUMBERONLINE) == 0) {
                    System.out.print("\n" + temp + " ");
                }
                else {
                    System.out.print(temp + " ");
                }
            } // end while
            
            System.out.println("\nCount is " + count);
            System.out.println("Total is " + total);
        } // end try
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    } // end method
} // end class
