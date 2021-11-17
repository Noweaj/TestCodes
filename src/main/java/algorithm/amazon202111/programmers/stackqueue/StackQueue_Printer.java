package algorithm.amazon202111.programmers.stackqueue;

import util.CheckUtil;
import util.PrintUtil;

import java.util.*;

public class StackQueue_Printer {
    public static void main(String[] args){
        StackQueue_Printer mClass = new StackQueue_Printer();
        PrintUtil.println(new CheckUtil().checkAnswer(mClass.solve(new int[]{2,1,3,2}, 2), 1));
        PrintUtil.println(new CheckUtil().checkAnswer(mClass.solve(new int[]{1,1,9,1,1,1}, 0), 5));
    }

    private int solve(int[] priorities, int location){
        Queue<Task> taskQueue = new LinkedList<>();
        PriorityQueue<Integer> taskPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i=0; i<priorities.length; i++){
            taskQueue.add(new Task(priorities[i], i, i));
            taskPriorityQueue.add(priorities[i]);
        }

        int cnt = 0;
        while(!taskQueue.isEmpty()){
            Task curTask = taskQueue.peek();
            if(curTask.priority < taskPriorityQueue.peek()){
                Task goBackTask = taskQueue.poll();
                taskQueue.add(new Task(goBackTask.priority, taskQueue.size()+1, goBackTask.origLocation));
            } else {
                Task finishTask = taskQueue.poll();
                taskPriorityQueue.poll();
                cnt++;
                if(finishTask.origLocation == location){
                    break;
                }
            }
        }

        return cnt;
    }

    class Task{
        private int priority;
        private int location;
        private int origLocation;
        public Task(int priority, int location, int origLocation){
            this.priority = priority;
            this.location = location;
            this.origLocation = origLocation;
        }

        public int getPriority(){
            return this.priority;
        }

        public int getOrigLocation(){
            return this.origLocation;
        }

        public void setLocation(int newLocation){
            this.location = newLocation;
        }

        public int getLocation(){
            return this.location;
        }
    }
}
