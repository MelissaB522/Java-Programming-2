
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author mb0242181
 */
public class Exercise172 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_02.dat", true))) {
            for (int i = 0; i < 100; i++) {
                output.writeInt((int) (Math.random() * 100000));
            }
        } // end try
        System.out.println("Done");
    }
}
