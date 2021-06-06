package algorithm.nhn202106.hackerranks.dictionariesAndHashmaps;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        new SherlockAndAnagrams().solve();
    }

    private void solve() {
        int result = findAnagrams("mom");
        System.out.println("Result: "+(result == 2)+" / answer: 2 / input: "+result);
        result = findAnagrams("abba");
        System.out.println("Result: "+(result == 4)+" / answer: 4 / input: "+result);
        result = findAnagrams("abcd");
        System.out.println("Result: "+(result == 0)+" / answer: 0 / input: "+result);
        result = findAnagrams("ifailuhkqq");
        System.out.println("Result: "+(result == 3)+" / answer: 3 / input: "+result);
        result = findAnagrams("kkkk");
        System.out.println("Result: "+(result == 10)+" / answer: 10 / input: "+result);
        result = findAnagrams("cdcd");
        System.out.println("Result: "+(result == 5)+" / answer: 5 / input: "+result);
    }

    private int findAnagrams(String s){

        for(int i=0; i<s.length()/2; i++){

        }
        return 0;
    }

    private boolean isAnagram(String str1, String str2){
        return false;
    }
}
