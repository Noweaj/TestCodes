package algorithm.hackerranks.nhn202106.warmup;

import java.util.Stack;

public class Array_JumpingOnTheClouds {

    public static void main(String[] args){
        Array_JumpingOnTheClouds mClass = new Array_JumpingOnTheClouds();
        int sample1 = mClass.getMinimumJumps(7, new int[]{0, 0, 1, 0, 0, 1, 0});
        System.out.println("Result: "+(sample1 == 4)+" / answer: 4 / input: "+sample1);

        int sample2 = mClass.getMinimumJumps(6, new int[]{0, 0, 0, 0, 1, 0});
        System.out.println("Result: "+(sample2 == 3)+" / answer: 3 / input: "+sample2);

        int sample3 = mClass.getMinimumJumps(10, new int[]{0, 0, 0, 1, 0, 0, 0, 0, 0, 0});
        System.out.println("Result: "+(sample3 == 5)+" / answer: 5 / input: "+sample3);

        int sample4 = mClass.getMinimumJumps(10, new int[]{0, 1, 0, 1, 0, 0, 0, 0, 1, 1});
        System.out.println("Result: "+(sample4 == 4)+" / answer: 4 / input: "+sample4);
    }

    private int getMinimumJumps(int n, int[] clouds){
        Stack<Integer> mStack = new Stack<>();
        int result = 0;
        for(int current : clouds){
            if(current != 1){
                if(!mStack.empty() && mStack.peek() == 1){
                    mStack.pop();
                    result++;
                }
            } else {
                if(mStack.empty()) return 0;
                int cnt = 0;
                while(!mStack.empty()){
                    mStack.pop();
                    cnt++;
                }
                result += cnt/2;
            }
            mStack.push(current);
        }
        int cnt = 0;
        if(!mStack.empty()){
            while(!mStack.empty()){
                mStack.pop();
                cnt++;
            }
            result += cnt/2;
        }
        return result;
    }
}
