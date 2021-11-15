package algorithm.amazon202111.programmers.hash;

import util.CheckUtil;
import util.InputSet;

import java.util.Arrays;

public class Hash_NotFinishedRunner {
    public static void main(String[] args){
        Hash_NotFinishedRunner mClass = new Hash_NotFinishedRunner();
        CheckUtil<String> mCheck = new CheckUtil();
        mCheck.checkAnswer(new InputSet[]{
                new InputSet(mClass.solve(
                        new String[]{"leo", "kiki", "eden"},
                        new String[]{"eden", "kiki"}
                ), "leo"),
                new InputSet(mClass.solve(
                        new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                        new String[]{"josipa", "filipa", "marina", "nikola"}
                ), "vinko"),
                new InputSet(mClass.solve(
                        new String[]{"mislav", "stanko", "mislav", "ana"},
                        new String[]{"stanko", "ana", "mislav"}
                ), "mislav")
        });
    }

    private String solve(String[] participant, String[] completion){
        Arrays.sort(participant); Arrays.sort(completion);
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])) return participant[i];
        }
        return participant[participant.length-1];
    }
}
