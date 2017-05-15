
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 *
 * @author mb0242181
 */
public class Exercise173 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int count = 0;
        try (DataInputStream dis = new DataInputStream(new FileInputStream("Exercise17_03.dat"))) {
            int total = 0;
            while (dis.available() > 0) {                
                int temp = dis.readInt();
                total += temp;
                count++;
                System.out.print(temp + " ");
            } // end while
            
            System.out.println("\nCount is " + count);
            System.out.println("Total is " + total);
        } // end try
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } // end catch
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        } // end catch
    }    
}
