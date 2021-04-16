package BloodSugarTracker.lastWeekChartDataTest

import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

fun main(){
    val cal = Calendar.getInstance().clone() as Calendar
    cal.firstDayOfWeek = Calendar.MONDAY
    cal.timeInMillis = cal.timeInMillis - (24 * 7 * 3600000L)
    cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)
    cal.set(Calendar.HOUR_OF_DAY, 1)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.MILLISECOND, 0)

    val resultEntities = ArrayList<EventEntity>()
    val answerEntities = ArrayList<EventEntity>()
    val gen = EventEntityGenerator().generateEntitiesFrom(
        cal.timeInMillis,
        resultEntities,
        answerEntities
    )

//    var resTrue = 0
//    for(i in 0 until 1000) {
//        val result = EventEntityGenerator().isSkip()
//        if (result)
//            resTrue++
//    }
//    println("$resTrue / 1000 ${resTrue/1000 * 100}")
}

class EventEntityGenerator{

    fun generateEntitiesFrom(
        fromTimeInMillis: Long,
        resultEntities: ArrayList<EventEntity>,
        answerEntities: ArrayList<EventEntity>
    ){
        var cnt: Long = 0
        var currentLdt = Timestamp(fromTimeInMillis).toLocalDateTime().plusDays(cnt)
        while(isBeforeNow(currentLdt)){
            // morning
            if(!isSkip()){
                val morningLdt = currentLdt.withHour(getMorningTime())
                resultEntities.add(EventEntity(
                    Timestamp.valueOf(morningLdt).time,
                    "general",
                    getRandomValue(80, 100)
                ))
            }

            // lunch
            val lunchLdt = currentLdt.withHour(getLunchTime())
            val lunchValue = getRandomValue(150, 180)
            for(i in 0 until 2){
                if(!isSkip()){
                    val newLunchLdt = lunchLdt.plusHours(i * 1.toLong())
                    resultEntities.add(
                        EventEntity(
                            Timestamp.valueOf(newLunchLdt).time,
                            "meal",
                            lunchValue - (i * 40)
                    ))
                }
            }

            // dinner
            val dinnerLdt = currentLdt.withHour(getDinnerTime())
            val dinnerValue = getRandomValue(150, 190)
            for(i in 0 until 2){
                if(!isSkip()){
                    val newDinnerLdt = dinnerLdt.plusHours(i * 1.toLong())
                    resultEntities.add(
                        EventEntity(
                            Timestamp.valueOf(newDinnerLdt).time,
                            "meal",
                            dinnerValue - (i * 40)
                        )
                    )
                }
            }

            cnt++
            currentLdt = Timestamp(fromTimeInMillis).toLocalDateTime().plusDays(cnt)
        }

        for(i in resultEntities.indices){

            println("EventEntity(${resultEntities[i].timestamp}, \"${resultEntities[i].event}\", ${resultEntities[i].value}), // ${Timestamp(resultEntities[i].timestamp).toLocalDateTime()}")
//            println("${Timestamp(resultEntities[i].timestamp).toLocalDateTime()} ${resultEntities[i].value}")
        }
    }

    private fun isBeforeNow(from: LocalDateTime) = from.isBefore(LocalDateTime.now())

    private fun getMorningTime() = getRandomValue(8, 12) // include 8 but exclude 12
    private fun getLunchTime() = getRandomValue(12, 16)
    private fun getDinnerTime() = getRandomValue(18, 22)
    private fun getExerciseTime() = getRandomValue(22, 24)

    private fun getRandomValue(min: Int, max: Int) = Random().nextInt(max-min)+min
    fun isSkip() = getRandomValue(0, 4) > 2 // 25%

    fun generate(cnt: Int){
        val cal = Calendar.getInstance().clone() as Calendar
        cal.firstDayOfWeek = Calendar.MONDAY
        cal.timeInMillis = cal.timeInMillis - (24 * 7 * 3600000L)
        cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)
        cal.set(Calendar.HOUR_OF_DAY, 1)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.MILLISECOND, 0)


    }


}