package algorithm.hackerranks.nhn202106.warmup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Array_SalesByMatch {

    public static void main(String[] args){
        Array_SalesByMatch mClass = new Array_SalesByMatch();
        int sample1 = mClass.numberOfPairs(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20});
        System.out.println("Result: "+(sample1 == 3)+" / answer: 3 / input: "+sample1);

        int sample2 = mClass.numberOfPairs(10, new int[]{1, 2, 3, 2, 3, 1, 3, 2, 2, 3});
        System.out.println("Result: "+(sample2 == 5)+" / answer: 5 / input: "+sample2);

        int sample3 = mClass.numberOfPairs(11, new int[]{1, 2, 3, 2, 3, 1, 3, 4, 4, 2, 5});
        System.out.println("Result: "+(sample3 == 4)+" / answer: 4 / input: "+sample3);

        int sample4 = mClass.numberOfPairs(5, new int[]{1, 2, 3, 4, 5});
        System.out.println("Result: "+(sample4 == 0)+" / answer: 0 / input: "+sample4);
    }

    private int numberOfPairs(int n, int[] ar){
        Map<Integer, Integer> mMap = new HashMap<>();
        int cnt = 0;
        for(int sock: ar){
            if(!mMap.containsKey(sock)){
                mMap.put(sock, 1);
            } else {
                mMap.remove(sock);
                cnt++;
            }
        }
        return cnt;
    }
}
