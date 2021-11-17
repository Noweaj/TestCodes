package algorithm.amazon202111.programmers.stackqueue;

import util.CheckUtil;
import util.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue_TrucksCrossingTheBridge {
    public static void main(String[] args){
        StackQueue_TrucksCrossingTheBridge mClass = new StackQueue_TrucksCrossingTheBridge();
        PrintUtil.println(new CheckUtil().checkAnswer(
                mClass.solve(2, 10, new int[]{7,4,5,6}),
                8
        ));
        PrintUtil.println(new CheckUtil().checkAnswer(
                mClass.solve(100, 100, new int[]{10}),
                101
        ));
        PrintUtil.println(new CheckUtil().checkAnswer(
                mClass.solve(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}),
                110
        ));
    }

    // solve again. you copied the answer from web!
    private int solve(int bridge_length, int weight, int[] truck_weights){
        return 0;
    }























    private int solve_copied(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> truckQueue = new LinkedList<>();
        int netWeight = 0;
        int tick = 0;

        for(int i=0; i<truck_weights.length; i++){
            while(true){
                if(truckQueue.isEmpty()){
                    truckQueue.add(truck_weights[i]);
                    netWeight += truckQueue.peek();
                    tick++;
                    break;
                } else if (truckQueue.size() == bridge_length) {
                    netWeight -= truckQueue.poll();
                } else {
                    if(netWeight+truck_weights[i] <= weight){
                        truckQueue.add(truck_weights[i]);
                        netWeight += truckQueue.peek();
                        tick++;
                        break;
                    } else {
                        truckQueue.add(0);
                        tick++;
                    }
                }
            }
        }
        return tick+bridge_length;
    }
}
