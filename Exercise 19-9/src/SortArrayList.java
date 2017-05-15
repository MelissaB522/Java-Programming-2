
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Me
 */
public class SortArrayList {
    
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        E currentMin;
        int currentMinIndex;
        
        for (int i = 0; i < list.size() - 1; i++) {
            // Find minimum in the list
            currentMin = list.get(i);
            currentMinIndex = i;
            
            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin.compareTo(list.get(j)) > 0) {
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }
            
            // Swap i with currentMinIndex if necessary
            if (currentMinIndex != i) {
                list.set(currentMinIndex, list.get(i));
                list.set(i, currentMin);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Alabama");
        list.add("Hawaii");
        list.add("Delaware");
        list.add("Wisconsin");
        list.add("Colorado");
        list.add("Texas");
        list.add("Missouri");
        list.add("Washington");
        sort(list);
        
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(654231);
        list1.add(2314);
        list1.add(546);
        list1.add(89771);
        list1.add(124);
        list1.add(65);
        sort(list1);
        
        for (String item: list) {
            System.out.print(item + " ");
        }
        
        System.out.println();
        
        for (int item: list1) {
            System.out.print(item + " ");
        }
    }
    
}
