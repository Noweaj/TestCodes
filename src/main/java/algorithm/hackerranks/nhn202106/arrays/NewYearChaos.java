package algorithm.hackerranks.nhn202106.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NewYearChaos {

    public static void main(String[] args) {
        new NewYearChaos().solve();
    }

    /**
     * Use Bubble Sort
     */
    private void solve() {
        getMinimumBribes(Arrays.asList(2,1,5,3,4));
        getMinimumBribes(Arrays.asList(2,5,1,3,4));

        bubbleSort(Arrays.asList(2,1,5,3,4));
        bubbleSort(Arrays.asList(2,5,1,3,4));
    }

    private void getMinimumBribes(List<Integer> q){

    }

    private void bubbleSort(List<Integer> q){
        LinkedList<Integer> sortList = new LinkedList<>();
        sortList.addAll(q);

        for(int i=0; i<sortList.size()-1; i++){
            for(int j=0; j<sortList.size()-i-1; j++){
                System.out.println("j:"+j+" / "+sortList);
                if(sortList.get(j) > sortList.get(j+1)){
                    int temp = sortList.get(j);
                    sortList.set(j, sortList.get(j+1));
                    sortList.set(j+1, temp);
                    System.out.println("c:"+j+" / "+sortList);
                }
            }
        }

        System.out.println(sortList);
    }
}
