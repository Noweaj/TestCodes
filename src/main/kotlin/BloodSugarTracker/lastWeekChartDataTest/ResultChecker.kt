package BloodSugarTracker.lastWeekChartDataTest

import java.util.*
import kotlin.collections.ArrayList

object ResultChecker {
    data class MyResult(
            val pass: Boolean,
            val msg: String
    )

    fun checkAnswer(list: ArrayList<MyData>, answer: ArrayList<Int>): MyResult {
        if(list.size != answer.size){
            return MyResult(false, "Size Error: ${list.size} vs ${answer.size}")
        }
        for(i in list.indices){
            if(list[i].value != answer[i]){
                return MyResult(false, "Error: $i ${list[i].value} vs ${answer[i]}")
            }
        }
        return MyResult(true, "All checked")
    }

    fun eventEntityChecker(
        morningEntities: ArrayList<EventEntity>,
        lunchEntities: ArrayList<EventEntity>,
        dinnerEntities: ArrayList<EventEntity>,
        answerList: ArrayList<EventEntity>
    ): MyResult {
        val entityListSize = morningEntities.size
        if(lunchEntities.size != entityListSize
            || dinnerEntities.size != entityListSize
            || answerList.size != entityListSize * 3){
            return MyResult(false, "ArrayList Size Not Match")
        }

        val cal = Calendar.getInstance().clone() as Calendar
        var cnt = 0
        for(i in 0 until entityListSize){
//            println("${morningEntities[i]} / ${answerList[cnt]}")
            cal.timeInMillis = morningEntities[i].timestamp
            val morningDay = cal.get(Calendar.DAY_OF_MONTH)
            cal.timeInMillis = answerList[cnt].timestamp
            val morningAnswer = cal.get(Calendar.DAY_OF_MONTH)
            if(morningDay != morningDay
                || morningEntities[i].value != answerList[cnt].value){

                println("${morningEntities[i]} / ${answerList[cnt]}")
                return MyResult(false, "invalid data on morning index $i")
            }
            cnt++

            cal.timeInMillis = lunchEntities[i].timestamp
            val lunchDay = cal.get(Calendar.DAY_OF_MONTH)
            cal.timeInMillis = answerList[cnt].timestamp
            val lunchAnswer = cal.get(Calendar.DAY_OF_MONTH)
            if(lunchDay != lunchAnswer
                || lunchEntities[i].value != answerList[cnt].value){

                println("${lunchEntities[i]} / ${answerList[cnt]}")
                return MyResult(false, "invalid data on lunch index $i")
            }
            cnt++

            cal.timeInMillis = dinnerEntities[i].timestamp
            val dinnerDay = cal.get(Calendar.DAY_OF_MONTH)
            cal.timeInMillis = answerList[cnt].timestamp
            val dinnerAnswer = cal.get(Calendar.DAY_OF_MONTH)
            if(dinnerDay != dinnerAnswer
                || dinnerEntities[i].value != answerList[cnt].value){

                println("${dinnerEntities[i]} / ${answerList[cnt]}")
                return MyResult(false, "invalid data on dinner index $i")
            }
            cnt++
        }
        return MyResult(true, "test")
    }
}