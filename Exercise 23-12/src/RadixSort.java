
import java.util.ArrayList;

/**
 * Class:       RadixSort
 * Developer:   Melissa Bakke
 * Date:        03/28/2017
 * Purpose:     Program that randomly generates 1000000 integers and sorts them 
 *              using a radix sort.
 */
public class RadixSort {
    
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        // Create new list
        int[] newList = new int[1000000];
        
        // Loop through list to add random numbers
        for (int i = 0; i < newList.length; i++) {
            newList[i] = (int)(Math.random() * 1000000);
        }
        
        // Print unsorted list, 15 numbers to a row
        for (int i = 0; i < newList.length; i++) {
            if (i % 15 == 0) {
                System.out.print("\n" + newList[i] + " ");
            }
            else {
                System.out.print(newList[i] + " ");
            }
        }
        
        System.out.println("\n");
        
        // Call radixSort method, passing it the list and number of digits
        radixSort(newList, 7);
        
        // Print sorted list, 15 numbers to a row
        for (int i = 0; i < newList.length; i++) {
            if (i % 15 == 0) {
                System.out.print("\n" + newList[i] + " ");
            }
            else {
                System.out.print(newList[i] + " ");
            }
        }
        
    }
    
    public static void radixSort(int[] list, int digits) {
        // Create arraylist for buckets
        ArrayList<Integer>[] buckets = new ArrayList[10];
        
        // Create an arraylist for each bucket
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        
        for (int n = 0; n <= digits ; n++) {
            // Clear buckets
            for (int i = 0; i < buckets.length; i++) {
                buckets[i].clear();
            }
            
            // Loop through list, adding numbers to appropriate bucket
            for (int i = 0; i < list.length; i++) {
                int key = getKey(list[i], n);
                buckets[key].add(list[i]);
            }
            
            // Loop through buckets, adding numbers back to list in appropriate order
            // index is a counter
            int index = 0;
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    list[index++] = buckets[i].get(j);
                }
            }
        }
    } // End radixSort method
    
    public static int getKey(int number, int position) {
        int result = 1;
        for (int i = 0; i < position; i++) {
            result *= 10;
        }
        
        return (number / result) % 10;
    }
}
