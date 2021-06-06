package algorithm.nhn202106.inflearn.stringArray2;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        new GroupAnagrams().solve();
    }

    private void solve() {
        System.out.println(findGroupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private List<List<String>> findGroupAnagrams(String[] strs){

        Map<String, List<String>> mMap = new HashMap<>();
        for(String str: strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String toStr = String.valueOf(charArr).toLowerCase();
            if(mMap.containsKey(toStr)){
                List<String> curList = mMap.get(toStr);
                curList.add(str);
                mMap.put(toStr, curList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                mMap.put(toStr, newList);
            }
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(mMap.values());
        return result;
    }
}
