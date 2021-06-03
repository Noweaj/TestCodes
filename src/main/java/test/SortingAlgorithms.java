package test;

import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {
    private static void println(String msg){ System.out.println(msg); }

    public static void main(String[] args){
        runSort(Arrays.asList(9,4,6,2,8,1,5,3,7));
    }

    private static void runSort(List<Integer> list){
        bubbleSort(list);
        insertionSort(list);
    }

    private static void bubbleSort(List<Integer> list){
        println("bubbleSort");
        println("before: "+list);

        for(int i=0; i<list.size()-1; i++){
            for(int j=0; j<list.size()-i-1; j++){
                if(list.get(j) > list.get(j+1)){ // swap
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }

        println("after : "+list);
    }

    private static void insertionSort(List<Integer> list){
        println("insertionSort");
        println("before: "+list);

        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){

            }
        }

        println("after : "+list);
    }
}
