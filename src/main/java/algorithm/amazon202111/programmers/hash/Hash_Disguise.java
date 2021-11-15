package algorithm.amazon202111.programmers.hash;

import util.CheckUtil;
import util.InputSet;

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


        return 0;
    }
}
