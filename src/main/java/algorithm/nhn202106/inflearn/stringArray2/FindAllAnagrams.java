package algorithm.nhn202106.inflearn.stringArray2;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        new FindAllAnagrams().solve();
    }

    private void solve() {
        System.out.println(findAllAnagrams("BACDGABCDA", "ABCD"));
    }

    private List<Integer> findAllAnagrams(String text, String pattern){

        List<Integer> result = new ArrayList<>();

        int[] patArr = new int[256];

        for(int i=0; i<pattern.length(); i++){
            patArr[pattern.charAt(i)]++;
        }

        for(int i=0; i<text.length()-pattern.length()+1; i++){
            int[] textArr = new int[256];
            for(int j=0; j<pattern.length(); j++){
                textArr[text.charAt(i+j)]++;
            }

            if(check(patArr, textArr)){
                result.add(i);
            }
        }

        return result;
    }

    private boolean check(int[] patArr, int[] textArr){
        for(int i=0; i<patArr.length; i++){
            if(patArr[i] != textArr[i]){
                return false;
            }
        }
        return true;
    }
}
