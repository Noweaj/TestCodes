package BloodSugarTracker.lastWeekChartDataTest

import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val dataList = ArrayList<MyData>()
    val answerList = ArrayList<Int>()

    generateTestData(dataList, answerList)

    val testStack = EventEntityStack()
    val testSet = EventEntitySet()

    val testStackStart = System.currentTimeMillis()
    val stackResult = testStack.stackAlgorithm(dataList, answerList.size)
    val testStackEnd = System.currentTimeMillis()

    val testSetStart = System.currentTimeMillis()
    val setResult = testSet.setAlgorithm(dataList, answerList.size)
    val testSetEnd = System.currentTimeMillis()

    println("testStack: ${testStackEnd - testStackStart} / $testStackStart $testStackEnd")
    println("testSet: ${testSetEnd - testSetStart} / $testSetStart $testSetEnd")

//    println("stackResult: $stackResult")
//    println("setResult: $setResult")
    println(ResultChecker.checkAnswer(stackResult, answerList))
    println(ResultChecker.checkAnswer(setResult, answerList))
}

private fun generateTestData(dataList: ArrayList<MyData>, answerList: ArrayList<Int>){
    val testCaseNum = 10000
//    var trueCnt = 0
//    var falseCnt = 0
//    for(i in 0 until 10000){
//        val res = increaseTime()
//        println(res)
//        if(res)
//            trueCnt++
//        else
//            falseCnt++
//    }
//    println("true: $trueCnt false: $falseCnt")

    var time = 0
    var max = 0
    for(i in 0 until testCaseNum){
//        println("$dataList")
//        println("$answerList")
        val increase = increaseTime()
        val skip = isSkip()
//        println("$increase, $skip")
        if(increase){
            time++
            answerList.add(max)
            max = 0
            if(skip){
                time++
                answerList.add(0)
                continue
            } else {
                val value = getRandom(0, 10)
                dataList.add(MyData(time, value))
                max = Math.max(value, max)
            }
        } else {
            val value = getRandom(0, 10)
            dataList.add(MyData(time, value))
            max = Math.max(value, max)
        }
    }
    answerList.add(max)

//    println(dataList)
//    println(answerList)
}

private fun increaseTime(): Boolean{
    return getRandom(0, 4) > 2
}

private fun isSkip(): Boolean{
    return getRandom(0, 2) > 0 // 50%
}

private fun getRandom(min: Int, max: Int): Int {
    val random = Random()
    return random.nextInt(max - min) + min
}