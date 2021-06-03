package algorithm.hackerranks.nhn202106.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeftRotation {

    public static void main(String[] args) {
        new LeftRotation().solve();
    }

    private void solve() {
//        List<Integer> inputList = new ArrayList<Integer>();
//        inputList.add(1);
//        inputList.add(2);
//        inputList.add(3);
//        inputList.add(4);
//        inputList.add(5);
        List<Integer> result = rotateLeft(Arrays.asList(1, 2, 3, 4, 5), 4); // This requires copying the list into another since Arrays.asList has fixed size of list, which cannot be added or removed.
//        List<Integer> result = rotateLeft(inputList, 4);
        System.out.println(result);
    }

    private List<Integer> rotateLeft(List<Integer> a, int d){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addAll(a);
        for(int i=0; i<d; i++){
            int temp = ll.get(0);
            ll.remove(0);
            ll.add(temp);
        }
        return ll;
    }
}
