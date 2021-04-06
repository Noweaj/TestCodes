package BloodSugarTracker.lastWeekChartDataTest

import java.util.*
import kotlin.collections.ArrayList

fun main(){
//    val data = arrayListOf(
//            MyData(0, 2),
//            MyData(0, 3),
//            MyData(0, 1),
//            MyData(1, 6),
//            MyData(1, 5),
//            MyData(1, 7),
//            MyData(2, 2),
//            MyData(2, 1),
//            MyData(3, 5),
//            MyData(3, 4),
//            MyData(3, 6),
//            MyData(4, 3),
//            MyData(6, 7),
//            MyData(6, 8),
//            MyData(7, 3),
//            MyData(8, 6),
//            MyData(8, 5),
//            MyData(8, 9),
//            MyData(11, 9),
//            MyData(11, 5),
//            MyData(11, 4),
//            MyData(11, 7),
//            MyData(12, 2),
//            MyData(12, 5)
//    )
//    val answerList = arrayListOf(3, 7, 2, 6, 3, 0, 8, 3, 9, 0, 0, 9, 5)

    val data = arrayListOf(
        MyData(2, 5),
        MyData(3, 8),
        MyData(4, 2),
        MyData(4, 5),
        MyData(4, 2),
        MyData(4, 5),
        MyData(4, 7),
        MyData(4, 3),
        MyData(4, 1)
    )
    val answerList = arrayListOf(0, 0, 5, 8, 7, 0)

    val processedData = EventEntityStack().stackAlgorithm(data, answerList.size)
    println("MyData: $processedData")

    val result = ResultChecker.checkAnswer(processedData, answerList)
    println(result)
}

class EventEntityStack {
    /**
     * This algorithm
     */
    fun stackAlgorithm(data: ArrayList<MyData>, resultSize: Int): ArrayList<MyData>{
        val processedData = arrayListOf<MyData>()
        var mStack = Stack<MyData>()
        var cnt = 0
        for(i in data.indices){
            // if start index is not 0, fill 0 until the start of data
            if(i == 0 && data[i].time != 0){
                for(j in 0 until data[i].time){
                    processedData.add(MyData(j, 0))
                }
            }

            // first data
            if(mStack.isEmpty()){
                mStack.push(data[i])
                continue
            }

            val curData = mStack.peek()

            if(data[i].time != curData.time){
                // new time starts
                if(data[i].time - curData.time > 1){
                    // if gap exists between current time and next time, fill gap with 0
                    processedData.add(curData)
                    for(j in curData.time+1 until data[i].time){
                        processedData.add(MyData(j, 0))
                    }
                    // clear stack and push new one
                    mStack.clear()
                    mStack.push(MyData(data[i].time, data[i].value))
                } else {
                    // if next time is incremented by 1, add the one in the stack into the result, since it is the largest one, and push a new one
                    processedData.add(mStack.pop())
                    mStack.push(data[i])
                }
            } else {
                // same time
                if(data[i].value != curData.value){
                    // if value is different, compare and push larger one
                    val popedData = mStack.pop()
                    mStack.push(MyData(data[i].time, Math.max(data[i].value, popedData.value)))
                }
            }
//            println(processedData)
        }

        // add the last item into the result array
        processedData.add(mStack.pop())

        // if size is larger than current result, fill remaining items with 0
        if(processedData.size < resultSize){
            for(i in processedData.size-1 until resultSize-1){
                processedData.add(MyData(i, 0))
            }
        }

        return processedData
    }
}