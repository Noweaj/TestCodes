package algorithm.amazon202111.programmers;

import util.CheckUtil;
import util.InputSet;

import java.util.HashSet;

public class Hash_Disguise {
    public static void main(String[] args){
        Hash_Disguise mClass = new Hash_Disguise();
        CheckUtil<Integer> mCheck = new CheckUtil<>();
        mCheck.checkAnswer(new InputSet[]{
                new InputSet(mClass.solve(new String[][]{
                        new String[]{"yellowhat", "headgear"},
                        new String[]{"bluesunglasses","eyewear"},
                        new String[]{"green_turban", "headgear"}
                }), 5),
                new InputSet(mClass.solve(new String[][]{
                        new String[]{"crowmask", "face"},
                        new String[]{"bluesunglasses", "face"},
                        new String[]{"smoky_makeup", "face"}
                }), 3),
                new InputSet(mClass.solve(new String[][]{
                        new String[]{"mask1", "face"},
                        new String[]{"hat1", "headgear"},
                        new String[]{"hat2", "headgear"},
                        new String[]{"glasses1", "eyewear"},
                        new String[]{"glasses2", "eyewear"}
                }), 17)
        });
    }

    private int solve(String[][] clothes){
        HashSet<String> mSet = new HashSet<>();
        int cnt = 0;
        for(int i=0; i<clothes.length; i++){
            mSet.clear();
            mSet.add(clothes[i][1]);
            cnt++;
            for(int j=i+1; j<clothes.length; j++){
                if(!mSet.contains(clothes[j][1])){
                    mSet.add(clothes[j][1]);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
