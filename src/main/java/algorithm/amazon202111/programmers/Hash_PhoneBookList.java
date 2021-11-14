package algorithm.amazon202111.programmers;

import util.CheckUtil;
import util.CheckUtil.*;
import util.InputSet;
import util.PrintUtil;

import java.util.*;

public class Hash_PhoneBookList {
    public static void main(String[] args){
        Hash_PhoneBookList mClass = new Hash_PhoneBookList();
        CheckUtil<Boolean> mUtil = new CheckUtil();
        mUtil.checkAnswer(new InputSet[]{
                new InputSet(false, mClass.solve(new String[]{"119", "97674223", "1195524421"})),
                new InputSet(true, mClass.solve(new String[]{"123","456","789"})),
                new InputSet(false, mClass.solve(new String[]{"12","123","1235","567","88"}))
        });
    }

    // this one passed the efficiency test
    private boolean solve(String[] phone_book){
        Map<String, String> mMap = new HashMap<>();
        for(String str : phone_book){
            mMap.put(str, str);
        }

        for(String str: phone_book){
            for(int i=0; i<str.length(); i++){
                if(mMap.containsKey(str.substring(0, i)))
                    return false;
            }
        }
        return true;
    }

    private boolean solve_didntPassEfficiencyTest(String[] phone_book){
        List mList = Arrays.asList(phone_book);
        mList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        for(int i=0; i<mList.size()-1; i++){
            for(int j=i+1; j<mList.size(); j++){
                if(((String)mList.get(j)).startsWith((String)mList.get(i)))
                    return false;
            }
        }
        return true;
    }
}
