package BloodSugarTracker.lastWeekChartDataTest

import java.util.*

fun main(){
    val flag = false

    if(flag){
        test()
    } else {
        for (i in 0 until 100) {
            val result = test()
            if (!result) {
                println("$i ERROR")
                break
            }
        }
        println("TEST DONE")
    }

}

fun test(): Boolean{
    val answerList = ArrayList<EventEntity>()
    val eventEntities = generateEventEntities(answerList)

    for(i in eventEntities.indices){
        val cal  = Calendar.getInstance().clone() as Calendar
        cal.timeInMillis = eventEntities[i].timestamp
//        println("${cal.time} / ${eventEntities[i].value}")
        println("EventEntity(${eventEntities[i].timestamp}, \"${eventEntities[i].event}\", ${eventEntities[i].value}),")
    }
    println("--------")
    for(i in eventEntities.indices){
        val cal  = Calendar.getInstance().clone() as Calendar
        cal.timeInMillis = eventEntities[i].timestamp
        println("${cal.time} / ${eventEntities[i].value}")
//        println("EventEntity(${eventEntities[i].timestamp}, \"${eventEntities[i].event}\", ${eventEntities[i].value}),")
    }

    println(" ANSWER =========")
    for(i in answerList.indices){
        val cal = Calendar.getInstance().clone() as Calendar
        cal.timeInMillis = answerList[i].timestamp
        println("${cal.time} / ${answerList[i].value}")
    }

    println(" PROCESSING ========")

    val (morningEntities, lunchEntities, dinnerEntities) = mutableListOf(
        ArrayList<EventEntity>(), ArrayList<EventEntity>(), ArrayList<EventEntity>()
    )
    val algorithm = TimestampStack()
    algorithm.stackAlgorithm(
        eventEntities,
        morningEntities,
        lunchEntities,
        dinnerEntities
    )

    val result = ResultChecker.eventEntityChecker(
        morningEntities, lunchEntities, dinnerEntities, answerList
    )

    println("Result: ${result.pass} / ${result.msg}")
    return result.pass
}

fun generateEventEntities(answerList: ArrayList<EventEntity>): ArrayList<EventEntity> {
//    checkIsSkip(10000)

    val eventEntities = ArrayList<EventEntity>()
    val cal = Calendar.getInstance().clone() as Calendar
    cal.firstDayOfWeek = Calendar.MONDAY
    cal.timeInMillis = cal.timeInMillis - (24 * 7 * 3600000L)
    cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)

    var currentDay = cal.timeInMillis
    var currentHour = cal.get(Calendar.HOUR_OF_DAY)
//    var maxEntity: EventEntity? = null

    for(i in 0 until 7){
        var maxEntity: EventEntity?
        // morning (< 12)
        // set to morning time
        maxEntity = null
        cal.set(Calendar.HOUR_OF_DAY, 10)
        currentHour = cal.get(Calendar.HOUR_OF_DAY)
        for(j in 0 until 2){
            currentHour += j
            cal.set(Calendar.HOUR_OF_DAY, currentHour)
            if(!isSkip()){
                val newEntity = EventEntity(cal.timeInMillis, "general", getRandomValue(80, 100))
                eventEntities.add(newEntity)

                if(maxEntity == null){
                    maxEntity = newEntity
                } else {
                    if(maxEntity.value < newEntity.value){
                        maxEntity = newEntity
                    }
                }
            }
        }
        if(maxEntity == null){
            maxEntity = EventEntity(cal.timeInMillis, "general", 0)
        }
        answerList.add(maxEntity)
        // lunch (12 < x < 16)
        // set to lunch time
        maxEntity = null
        cal.set(Calendar.HOUR_OF_DAY, 14)
        currentHour = cal.get(Calendar.HOUR_OF_DAY)
        for(j in 0 until 2){
            currentHour += j
            cal.set(Calendar.HOUR_OF_DAY, currentHour)
            if(!isSkip()){
                val newEntity = EventEntity(cal.timeInMillis, "meal", getRandomValue(150, 180)-(j*40))
                eventEntities.add(newEntity)

                if(maxEntity == null){
                    maxEntity = newEntity
                } else {
                    if(maxEntity.value < newEntity.value){
                        maxEntity = newEntity
                    }
                }
            }
        }
        if(maxEntity == null){
            maxEntity = EventEntity(cal.timeInMillis, "meal", 0)
        }
        answerList.add(maxEntity)
        // dinner (18 < x < 22)
        // set to dinner time
        maxEntity = null
        cal.set(Calendar.HOUR_OF_DAY, 19)
        currentHour = cal.get(Calendar.HOUR_OF_DAY)
        for(j in 0 until 2){
            currentHour += j
            cal.set(Calendar.HOUR_OF_DAY, currentHour)
            if(!isSkip()){
                val newEntity = EventEntity(cal.timeInMillis, "meal", getRandomValue(150, 190)-(j*40))
                eventEntities.add(newEntity)

                if(maxEntity == null){
                    maxEntity = newEntity
                } else {
                    if(maxEntity.value < newEntity.value){
                        maxEntity = newEntity
                    }
                }
            }
        }
        if(maxEntity == null){
            maxEntity = EventEntity(cal.timeInMillis, "meal", 0)
        }
        answerList.add(maxEntity)
        // exercise (22 < x < 24)
        // set to exercise time
        maxEntity = null
        cal.set(Calendar.HOUR_OF_DAY, 23)
        currentHour = cal.get(Calendar.HOUR_OF_DAY)
        for(j in 0 until 1){
            currentHour += j
            cal.set(Calendar.HOUR_OF_DAY, currentHour)
            if(!isSkip()){
                val newEntity = EventEntity(cal.timeInMillis, "exercise", getRandomValue(120, 140))
//                eventEntities.add(newEntity)

                if(maxEntity == null){
                    maxEntity = newEntity
                } else {
                    if(maxEntity.value < newEntity.value){
                        maxEntity = newEntity
                    }
                }
            }
        }
        if(maxEntity == null){
            maxEntity = EventEntity(cal.timeInMillis, "general", 0)
        }
        // no need to add exercise at this moment
//        answerList.add(maxEntity)

        // add day + 1
        cal.timeInMillis += 24*3600000L
    }

    return eventEntities
}

private fun isSkip(): Boolean {
//    return false
    return getRandom(0, 2) > 0 // 50%
}

private fun checkIsSkip(num: Int){
    var cnt = 0
    for(i in 0 until num){
        if(isSkip())
            cnt++
    }
    println("cnt: $cnt / perc: ${cnt.toDouble()/num.toDouble()*100}")
}

private fun getRandom(min: Int, max: Int): Int {
    return Random().nextInt(max-min)+min
}