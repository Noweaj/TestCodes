package algorithm.nhn202106.hackerranks.arrays;

public class MinimumSwaps2 {

    public static void main(String[] args) {
        new MinimumSwaps2().solve();
    }

    private void solve() {
        System.out.println(new MinimumSwaps2().getMinimumSwaps(new int[]{7,1,3,2,4,5,6}));
        System.out.println(new MinimumSwaps2().getMinimumSwaps(new int[]{2,3,4,1,5}));
        System.out.println(new MinimumSwaps2().getMinimumSwaps(new int[]{1,3,5,2,4,6,7}));
    }

    // do selectionSort
    private int getMinimumSwaps(int[] arr){
        int length = arr.length;
        int cnt = 0;
        for(int i=0; i<length-1; i++){
            int curVal = arr[i];
            int minIdx = i;
            for(int j=i+1; j<length; j++){
                int compVal = arr[j];
                if(compVal < curVal && compVal < arr[minIdx]){
                    minIdx = j;
                }
            }
            if(minIdx != i){
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
                cnt++;
            }
        }
        return cnt;
    }
}
