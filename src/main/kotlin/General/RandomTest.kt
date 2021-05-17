package General

import java.util.*

fun main(){
    getRandomByBound()
//    getRandomByPercentage()
}

private fun getRandomByPercentage(){
    val cnt = 10000
    val perc = 10
    var trueFlag = 0
    for( i in 0 until cnt){
        val value = Random().nextInt(100)
        val flag = value <= perc
        if(flag) trueFlag++
        println(value)
    }

    println("true: $trueFlag")
}

private fun getRandomByBound(){
    val max = 1000
    val cnt = 3
    var sum = 0
    for(i in 0 until max){
        val cur = Random().nextInt(cnt)
        sum += cur
        println(cur)
    }

    println("avg: ${sum/cnt}")
}