package algorithm.amazon202111.programmers.stackqueue;

import util.CheckUtil;
import util.PrintUtil;

import java.util.Stack;

public class StackQueue_StockPrice {
    public static void main(String[] args){
        StackQueue_StockPrice mClass = new StackQueue_StockPrice();
        PrintUtil.println(new CheckUtil().checkAnswerArr(
                mClass.solve(new int[]{1,2,3,2,3}),
                new int[]{4,3,1,1,0}
        ));
        PrintUtil.println(new CheckUtil().checkAnswerArr(
                mClass.solve(new int[]{1,3,5,2,4,7,6,2}),
                new int[]{7,2,1,4,3,1,1,0}
        ));
    }

    private int[] solve(int[] prices){
        Stack<Integer> mStack = new Stack<>();
        int[] result = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            while(!mStack.isEmpty() && prices[mStack.peek()] > prices[i]){
                int cur = mStack.pop();
                result[cur] = i-cur;
            }
            mStack.push(i);
        }
        while(!mStack.isEmpty()){
            int cur = mStack.pop();
            result[cur] = prices.length-1-cur;
        }
        return result;
    }
}
