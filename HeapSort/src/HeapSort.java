/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Me
 */
public class HeapSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 
        heapSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
    
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap of integers
        Heap<E> heap = new Heap<>();
        
        // Add elements to the heap
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }
        
        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
    
}
