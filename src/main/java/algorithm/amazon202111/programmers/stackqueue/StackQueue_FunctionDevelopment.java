package algorithm.amazon202111.programmers.stackqueue;

import util.PrintUtil;

import java.util.*;

public class StackQueue_FunctionDevelopment {
    public static void main(String[] args){
        StackQueue_FunctionDevelopment mClass = new StackQueue_FunctionDevelopment();
        int[] result1 = mClass.solve(
                new int[]{93, 30, 55},
                new int[]{1, 30, 5}
        );
        int[] result2 = mClass.solve(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1}
        );
        PrintUtil.println(Arrays.toString(result1));
        PrintUtil.println(Arrays.toString(result2));
    }

    // solve again. you copied the answer from web!
    private int[] solve(int[] progresses, int[] speeds){
        return null;
    }


































    private int[] solve_copied(int[] progresses, int[] speeds){
        Queue<Integer> workQueue = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        for(int i=0; i<speeds.length; i++){
            // get days to finish work of current index
            int dateToFinish = (int) Math.ceil((100-progresses[i]) / speeds[i]);

            // check if queue has higher than this
            if(!workQueue.isEmpty() && workQueue.peek() < dateToFinish){
                resultList.add(workQueue.size());
                workQueue.clear();
            }

            // add current work to queue
            workQueue.offer(dateToFinish);
        }

        resultList.add(workQueue.size());

        int[] ret = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            ret[i] = resultList.get(i);
        }

        return ret;
    }
}