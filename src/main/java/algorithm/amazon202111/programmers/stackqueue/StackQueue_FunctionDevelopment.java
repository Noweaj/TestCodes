package algorithm.amazon202111.programmers.stackqueue;

import util.CheckUtil;
import util.PrintUtil;

import java.util.*;

public class StackQueue_FunctionDevelopment {
    public static void main(String[] args){
        StackQueue_FunctionDevelopment mClass = new StackQueue_FunctionDevelopment();
//        int[] result1 = mClass.solve(
//                new int[]{93, 30, 55},
//                new int[]{1, 30, 5}
//        );
//        int[] result2 = mClass.solve(
//                new int[]{95, 90, 99, 99, 80, 99},
//                new int[]{1, 1, 1, 1, 1, 1}
//        );
        int[] result3 = mClass.solve(
                new int[]{96, 94},
                new int[]{3, 3}
        );
//        PrintUtil.println(new CheckUtil().checkAnswerArr(result1, new int[]{2,1}));
//        PrintUtil.println(new CheckUtil().checkAnswerArr(result2, new int[]{1,3,2}));
        PrintUtil.println(new CheckUtil().checkAnswerArr(result3, new int[]{1,1}));
    }

    // solve again. you copied the answer from web!
    private int[] solve(int[] progresses, int[] speeds){
        Queue<Integer> taskQueue = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        for(int i=0; i<progresses.length; i++){
            float curProgress = progresses[i];
            float curSpeed = speeds[i];
            int daysToFinish = (int) Math.ceil((100-curProgress)/curSpeed);
            PrintUtil.println(daysToFinish);
            if(!taskQueue.isEmpty()){
                int previousTask = taskQueue.peek();
                if(previousTask < daysToFinish){
                    resultList.add(taskQueue.size());
                    taskQueue.clear();
                }
            }
            taskQueue.add(daysToFinish);
        }
        resultList.add(taskQueue.size());

        int[] resultArr = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
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