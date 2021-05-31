package General

import BloodSugarTracker.lastWeekChartDataTest.EventEntity
import java.util.*

fun main(){
    val cal  = Calendar.getInstance().clone() as Calendar

    println(cal.timeInMillis)
    println(Calendar.getInstance().timeInMillis)

//    val data = arrayOf(
//            EventEntity(1617098581001, "meal", 141),
//            EventEntity(1617102181001, "meal", 117),
//            EventEntity(1617108361001, "meal", 172), //
//            EventEntity(1617154141001, "meal", 160),
//            EventEntity(1617165601001, "meal", 117),
//            EventEntity(1617169201001, "meal", 159),
//            EventEntity(1617185881001, "meal", 174),
//            EventEntity(1617189481001, "meal", 120),
//            EventEntity(1617194161001, "meal", 123),
//            EventEntity(1617238081001, "meal", 142),
//            EventEntity(1617253021001, "meal", 176),
//            EventEntity(1617256621001, "meal", 179)
//    )
//
//    for(i in data.indices){
//        cal.timeInMillis = data[i].timestamp
//        println("${cal.time} / ${data[i].value}")
//    }


//    cal.set(Calendar.DAY_OF_MONTH, 5)
//    println(cal.timeInMillis)
//    cal.set(Calendar.DAY_OF_MONTH, 6)
//    println(cal.timeInMillis)
//    cal.set(Calendar.DAY_OF_MONTH, 10)
//    println(cal.timeInMillis)
//    cal.set(Calendar.DAY_OF_MONTH, 11)
//    println(cal.timeInMillis)
//    cal.set(Calendar.DAY_OF_MONTH, 12)
//    println(cal.timeInMillis)

//    cal.set(Calendar.DAY_OF_MONTH, 3)
//    val before = cal.timeInMillis
//    cal.set(Calendar.DAY_OF_MONTH, 6)
//    val after = cal.timeInMillis
//
//    println((after-before)/(24*3600000L))

    // DAY_OF_WEEK gives Monday, Tuesday, etc...
    // DATE and DAY_OF_MONTH gives actual day of the month, 1st, 2nd, 30th, 31st, etc...

//    cal.firstDayOfWeek = Calendar.MONDAY
//    cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)
//    val timeMonday = cal.timeInMillis
//    cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY)
//    val timeWednesday = cal.timeInMillis
//
//    println((timeWednesday - timeMonday)/(24*3600000L))

    val timeNow = cal.timeInMillis
    val startOfDay = getStartOfday(timeNow)
    val endOfDay = getEndOfDay(timeNow)

    cal.timeInMillis = startOfDay
    println(cal.timeInMillis)
    println(cal.time)

    cal.timeInMillis = endOfDay
    println(cal.timeInMillis)
    println(cal.time)


}

private fun getStartOfday(time: Long): Long {
    val cal = Calendar.getInstance().clone() as Calendar
    cal.timeInMillis = time
    with(cal){
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }
    return cal.timeInMillis
}

private fun getEndOfDay(time: Long): Long {
    val cal = Calendar.getInstance().clone() as Calendar
    cal.timeInMillis = time
    with(cal){
        set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+1)
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }
    return cal.timeInMillis-1
}