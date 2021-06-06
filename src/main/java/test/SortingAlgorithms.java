package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {
    private static void println(String msg){ System.out.println(msg); }

    private static List<List<Integer>> sampleList = new ArrayList<>();

    public static void main(String[] args){
//        bubbleSort(Arrays.asList(9,4,6,2,8,1,5,3,7));
        sampleList.add(Arrays.asList(9,4,6,2,8,1,5,3,7));
        sampleList.add(Arrays.asList(2,5,3,1,4,7,6,9,8));
        sampleList.add(Arrays.asList(1,2,3,4,5,6,7,8,9));
        sampleList.add(Arrays.asList(9,8,7,6,5,4,3,2,1));
        sampleList.add(Arrays.asList(1,9,2,8,3,7,4,6,5));
        for(List<Integer> curList : sampleList){
            runSort(curList);
        }
    }

    private static void runSort(List<Integer> list){
//        bubbleSort(new ArrayList<>(list));
        insertionSort(new ArrayList<>(list));
//        selectionSort(new ArrayList<>(list));
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
        println("test result: "+test(list));
    }

    private static void insertionSort(List<Integer> list){
        println("insertionSort");
        println("before: "+list);

        int listSize = list.size();
        for(int i=1; i<listSize; i++){
            int key = list.get(i);
            int j = i-1;
            while(j >= 0 && list.get(j) > key){

                j--;
            }
        }

        println("after : "+list);
        println("test result: "+test(list));
    }

    private static void selectionSort(List<Integer> list){
        println("selectionSort");
        println("before: "+list);

        int sizeOfList = list.size();
        for(int i=0; i<sizeOfList-1; i++){
            int curNum = list.get(i);
            int minIdx = i;
            for(int j=i+1; j<sizeOfList; j++){
                int compNum = list.get(j);
                if(compNum < curNum && compNum < list.get(minIdx)){
                    minIdx = j;
                }
            }
            if(minIdx != i){
                int temp = list.get(i);
                list.set(i, list.get(minIdx));
                list.set(minIdx, temp);
            }
        }

        println("after : "+list);
        println("test result: "+test(list));
    }

    private static void mergeSort(List<Integer> list){

    }

    private static boolean test(List<Integer> list) {
        int oldNum = 0;
        int curNum = 0;
        for(int i=0; i<list.size(); i++){
            curNum = list.get(i);
            if(curNum != oldNum+1){
                return false;
            }
            // passed
            oldNum = list.get(i);
        }
        return true;
    }
}
