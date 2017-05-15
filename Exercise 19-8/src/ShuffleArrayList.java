
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Me
 */
public class ShuffleArrayList {
    
    public static <E> void shuffle(ArrayList<E> list) {
        E currentItem;
        Random rand = new Random();
        
        for (int i = 0; i < list.size() - 1; i++) {
            // Find minimum in the list
            currentItem = list.get(i);
            int n = rand.nextInt(list.size()); 
            
            // Swap i with random number n
            list.set(i, list.get(n));
            list.set(n, currentItem);
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
        shuffle(list);
        
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(654231);
        list1.add(2314);
        list1.add(546);
        list1.add(89771);
        list1.add(124);
        list1.add(65);
        shuffle(list1);
        
        for (String item: list) {
            System.out.print(item + " ");
        }
        
        System.out.println();
        
        for (int item: list1) {
            System.out.print(item + " ");
        }
    }
    
}
