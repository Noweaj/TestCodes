package algorithm.amazon202111.programmers.stackqueue;

import util.CheckUtil;
import util.PrintUtil;

import java.util.Stack;

public class StackQueue_Tower {
    public static void main(String[] args){
        StackQueue_Tower mClass = new StackQueue_Tower();
        PrintUtil.println(new CheckUtil().checkAnswerArr(
                mClass.solve(new int[]{6,9,5,7,4}),
                new int[]{0,0,2,2,4}
        ));
        PrintUtil.println(new CheckUtil().checkAnswerArr(
                mClass.solve(new int[]{3,9,9,3,5,7,2}),
                new int[]{0,0,0,3,3,3,6}
        ));
        PrintUtil.println(new CheckUtil().checkAnswerArr(
                mClass.solve(new int[]{1,5,3,6,7,6,5}),
                new int[]{0,0,2,0,0,5,6}
        ));
        PrintUtil.println(new CheckUtil().checkAnswerArr(
                mClass.solve(new int[]{1,2,3,4,5,6,7,8,9,10}),
                new int[]{0,0,0,0,0,0,0,0,0,0}
        ));
        PrintUtil.println(new CheckUtil().checkAnswerArr(
                mClass.solve(new int[]{10,9,8,7,6,5,4,3,2,1}),
                new int[]{0,1,2,3,4,5,6,7,8,9}
        ));
    }

    private int[] solve(int[] heights){
        Stack<Integer> mStack = new Stack<>();
        int[] result = new int[heights.length];
        for(int i=heights.length-1; i>-1; i--){
            while(!mStack.isEmpty() && heights[mStack.peek()] < heights[i]){
                int cur = mStack.pop();
                result[cur] = i+1;
            }
            mStack.push(i);
        }

        return result;
    }
}
