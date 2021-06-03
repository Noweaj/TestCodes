package algorithm.hackerranks.nhn202106.arrays;

import algorithm.util.Constants;
import algorithm.util.DataFileReader;

import java.io.File;
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
//        getMinimumBribes(Arrays.asList(2,1,5,3,4)); // answer: 3
//        getMinimumBribes(Arrays.asList(2,5,1,3,4)); // Too chaotic
//        getMinimumBribes(Arrays.asList(5,1,2,3,7,8,6,4)); // Too chaotic
//        getMinimumBribes(Arrays.asList(1,2,5,3,7,8,6,4)); // 7
//        getMinimumBribes(Arrays.asList(1,2,5,3,4,7,8,6)); // 4

        List<String> data = DataFileReader.ReadFileToList(
                new File(Constants.PROJECT_DIR
                        + Constants.ALGORITHM_SUB_DIR
                        + "\\hackerranks\\nhn202106\\arrays\\data\\NewYearChaosData.txt"));
        int dataCnt = Integer.parseInt(data.get(0));

        for(int i=0; i<dataCnt; i++){

        }
    }

    private String getMinimumBribes(List<Integer> q){
        return useBubbleSort(q);
    }

    private String useBubbleSort(List<Integer> q){
        LinkedList<Integer> sortList = new LinkedList<>();
        sortList.addAll(q);

        int currentCnt = 0;
        int totalCnt = 0;
        for(int i=0; i<sortList.size()-1; i++){
            int current = sortList.get(0);
            for(int j=0; j<sortList.size()-i-1; j++){
                if(sortList.get(j) > sortList.get(j+1)){
                    swap(sortList, j);
                    currentCnt++;
                } else {
                    current = sortList.get(j+1);
                    totalCnt += currentCnt;
                    if(currentCnt > 2){
                        return "Too chaotic";
                    }
                    currentCnt = 0;
                }
            }
        }
        return String.valueOf(totalCnt);
    }

    private void swap(LinkedList<Integer> list, int j){
        int temp = list.get(j);
        list.set(j, list.get(j+1));
        list.set(j+1, temp);
    }
}
