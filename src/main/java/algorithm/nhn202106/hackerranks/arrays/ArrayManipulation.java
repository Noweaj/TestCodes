package algorithm.nhn202106.hackerranks.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayManipulation {

    public static void main(String[] args) {
        new ArrayManipulation().solve();
    }

    private void solve() {
        long result = getLargestValue(10, Arrays.asList(
                Arrays.asList(1,5,3),
                Arrays.asList(4,8,7),
                Arrays.asList(6,9,1)
        ));
        System.out.println("Result: "+(result == 10)+" / Answer: 10 / Input: "+result);
        result = getLargestValue(5, Arrays.asList(
                Arrays.asList(1,2,100),
                Arrays.asList(2,5,100),
                Arrays.asList(3,4,100)
        ));
        System.out.println("Result: "+(result == 200)+" / Answer: 200 / Input: "+result);
    }

    private long getLargestValue(int n, List<List<Integer>> queries){
//        return arrayWay(n, queries);
        return mapWay(n, queries);
    }

    private long mapWay(int n, List<List<Integer>> queries){
        Map<Integer, Long> mMap = new HashMap<>();
        int size = queries.size();
        Long max = 0L;
        for(int i=0; i<size; i++){
            int idxStart = queries.get(i).get(0);
            int idxEnd = queries.get(i).get(1);
            long idxValue = queries.get(i).get(2);
            for(int j=idxStart; j<=idxEnd; j++){
                if(mMap.containsKey(j)){
                    mMap.put(j, mMap.get(j)+idxValue);
                } else {
                    mMap.put(j, idxValue);
                }
                max = Math.max(max, mMap.get(j));
            }
            System.out.println(mMap);
        }
        return max;
    }

    private int arrayWay(int n, List<List<Integer>> queries){
        int[] arr = new int[n];
        int max = 0;
        for(int i=0; i<queries.size(); i++){
            int idxStart = queries.get(i).get(0)-1;
            int idxEnd = queries.get(i).get(1);
            int idxValue = queries.get(i).get(2);
            for(int j=idxStart; j<idxEnd; j++){
                arr[j] += idxValue;
                max = Math.max(max, arr[j]);
            }
        }
        System.out.println(Arrays.toString(arr));
        return max;
    }
}
