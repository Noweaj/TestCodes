package BloodSugarTracker.lastWeekChartDataTest

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main(){
//    val data = arrayListOf(
//        1616976121001,
//        1616990821001,
//        1616994421001,
//        1617013261001,
//        1617016861001,
//        1617020461001,
//        1617062821001,
//        1617077161001,
//        1617080761001,
//        1617098581001,
//        1617102181001,
//        1617108361001,
//        1617154141001,
//        1617165601001,
//        1617169201001,
//        1617185881001,
//        1617189481001,
//        1617194161001,
//        1617238081001,
//        1617253021001,
//        1617256621001,
//        1617274141001,
//        1617277741001,
//        1617281881001,
//        1617325921001,
//        1617338701001,
//        1617342301001,
//        1617360841001,
//        1617364441001,
//        1617367981001,
//        1617409321001,
//        1617425161001,
//        1617428761001,
//        1617447361001,
//        1617450961001,
//        1617453721001,
//        1617496081001,
//        1617510961001,
//        1617514561001,
//        1617532681001,
//        1617536281001,
//        1617538981001,
//        1617581941001,
//        1617595501001,
//        1617599101001,
//        1617617701001,
//        1617621301001,
//        1617627421001,
//        1617668221001,
//        1617682561001,
//        1617686161001,
//        1617705721001,
//        1617709321001,
//        1617713041001
//    )
//    // print sample data
//    val sb = StringBuilder()
//    sb.append("val data = arrayListOf(\n")
//    for(i in data.indices){
//        sb.append("EventEntity(${data[i]}, \"meal\", ${getRandomValue(90, 180)}),\n")
//    }
//    sb.append(")")
//    println(sb.toString())



    val data = arrayListOf(
            EventEntity(1616976121001, "meal", 94),
            EventEntity(1616990821001, "meal", 163),
            EventEntity(1616994421001, "meal", 173),
            EventEntity(1617013261001, "meal", 132),
            EventEntity(1617016861001, "meal", 92),
            EventEntity(1617020461001, "meal", 117),
            EventEntity(1617062821001, "meal", 90),
            EventEntity(1617077161001, "meal", 134),
            EventEntity(1617080761001, "meal", 90),
            EventEntity(1617098581001, "meal", 141),
            EventEntity(1617102181001, "meal", 117),
            EventEntity(1617108361001, "meal", 172),
            EventEntity(1617154141001, "meal", 160),
            EventEntity(1617165601001, "meal", 117),
            EventEntity(1617169201001, "meal", 159),
            EventEntity(1617185881001, "meal", 174),
            EventEntity(1617189481001, "meal", 120),
            EventEntity(1617194161001, "meal", 123),
            EventEntity(1617238081001, "meal", 142),
            EventEntity(1617253021001, "meal", 176),
            EventEntity(1617256621001, "meal", 179),
            EventEntity(1617274141001, "meal", 175),
            EventEntity(1617277741001, "meal", 103),
            EventEntity(1617281881001, "meal", 176),
            EventEntity(1617325921001, "meal", 106),
            EventEntity(1617338701001, "meal", 134),
            EventEntity(1617342301001, "meal", 136),
            EventEntity(1617360841001, "meal", 140),
            EventEntity(1617364441001, "meal", 104),
            EventEntity(1617367981001, "meal", 114),
            EventEntity(1617409321001, "meal", 153),
            EventEntity(1617425161001, "meal", 140),
            EventEntity(1617428761001, "meal", 135),
            EventEntity(1617447361001, "meal", 174),
            EventEntity(1617450961001, "meal", 142),
            EventEntity(1617453721001, "meal", 166),
            EventEntity(1617496081001, "meal", 173),
            EventEntity(1617510961001, "meal", 140),
            EventEntity(1617514561001, "meal", 114),
            EventEntity(1617532681001, "meal", 120),
            EventEntity(1617536281001, "meal", 92),
            EventEntity(1617538981001, "meal", 109),
            EventEntity(1617581941001, "meal", 117),
            EventEntity(1617595501001, "meal", 161),
            EventEntity(1617599101001, "meal", 98),
            EventEntity(1617617701001, "meal", 156),
            EventEntity(1617621301001, "meal", 168),
            EventEntity(1617627421001, "meal", 148),
            EventEntity(1617668221001, "meal", 142),
            EventEntity(1617682561001, "meal", 173),
            EventEntity(1617686161001, "meal", 93),
            EventEntity(1617705721001, "meal", 113),
            EventEntity(1617709321001, "meal", 174),
            EventEntity(1617713041001, "meal", 136)
    )

    val timestampStack = TimestampStack()
    timestampStack.stackAlgorithm(data)
}

fun getRandomValue(from: Int, to: Int): Int{
    val random = Random()
    return random.nextInt(to-from)+from
}

class TimestampStack {

    fun stackAlgorithm(data: ArrayList<EventEntity>){

        val cal = Calendar.getInstance().clone() as Calendar

        val morningEntities = ArrayList<EventEntity>()
        val lunchEntities = ArrayList<EventEntity>()
        val dinnerEntities = ArrayList<EventEntity>()

        var eventStack = Stack<EventEntity>()

        val firstDayOfWeek = Calendar.MONDAY

        // need to store current date by long and get specific date by cal.get(Calendar.DAY_OF_WEEK)
        // maybe not. we can get previous event data from the Entities array
        var cnt = 0 // current date
        var max = 0
        for(i in data.indices){
            cal.timeInMillis = data[i].timestamp
            val day = cal.get(Calendar.DAY_OF_WEEK) - firstDayOfWeek
            val dayOfWeek = if(day == -1) 6 else day

//            val hour = cal.get(Calendar.HOUR_OF_DAY)
//            println("dayOfWeek: $dayOfWeek")

            if(i == 0 && dayOfWeek != 0){
//                println("!")
                // start entity is not "firstDayOfWeek"
                // fill 0 until dayOfWeek
                for(j in 0 until dayOfWeek){
                    val tempCal = Calendar.getInstance().clone() as Calendar
                    tempCal.timeInMillis = data[i].timestamp
                    tempCal.set(Calendar.DAY_OF_WEEK, j + firstDayOfWeek)
                    tempCal.set(Calendar.HOUR_OF_DAY, 11)
                    morningEntities.add(EventEntity(tempCal.timeInMillis, "general", 0))
                    tempCal.set(Calendar.HOUR_OF_DAY, 13)
                    lunchEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
                    tempCal.set(Calendar.HOUR_OF_DAY, 19)
                    dinnerEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
                }
                cnt = dayOfWeek
            }

//            println(eventStack)

            if(dayOfWeek != cnt){
//                println(eventStack)
                // new day
                // check number of values in eventStack and fill if empty
                if(3 - eventStack.size == 1){
                    val tempCal = Calendar.getInstance().clone() as Calendar
                    tempCal.timeInMillis = eventStack.peek().timestamp
                    tempCal.set(Calendar.HOUR_OF_DAY, 19)
                    eventStack.push(EventEntity(tempCal.timeInMillis, "meal", 0)) // dinner
                } else if(3 - eventStack.size == 2){
                    val tempCal = Calendar.getInstance().clone() as Calendar
                    tempCal.timeInMillis = eventStack.peek().timestamp
                    tempCal.set(Calendar.HOUR_OF_DAY, 13)
                    eventStack.push(EventEntity(tempCal.timeInMillis, "meal", 0)) // lunch
                    tempCal.set(Calendar.HOUR_OF_DAY, 19)
                    eventStack.push(EventEntity(tempCal.timeInMillis, "meal", 0)) // dinner
                }
                // save results
                dinnerEntities.add(eventStack.pop())
                lunchEntities.add(eventStack.pop())
                morningEntities.add(eventStack.pop())
                // clear stack
                eventStack.clear()
                if(data[i].timestamp - lunchEntities[lunchEntities.size-1].timestamp > 24*3600000L){
                    val numOfDays = (data[i].timestamp - lunchEntities[lunchEntities.size-1].timestamp)/(24*3600000L)
//                    println(numOfDays)
                    var refTimestamp = lunchEntities[lunchEntities.size-1].timestamp
                    for(j in 0 until numOfDays-1){
                        val tempCal = Calendar.getInstance().clone() as Calendar
                        refTimestamp += (24*3600000L)
                        tempCal.timeInMillis = refTimestamp
                        tempCal.set(Calendar.HOUR_OF_DAY, 11)
                        morningEntities.add(EventEntity(tempCal.timeInMillis, "general", 0))
                        tempCal.set(Calendar.HOUR_OF_DAY, 13)
                        lunchEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
                        tempCal.set(Calendar.HOUR_OF_DAY, 19)
                        dinnerEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
                    }
                }

                /**
                 * this method does not work when month changes...
                if(dayOfWeek - cnt > 1){
                    // gap exists. fill 0 for gaps
                    for(j in 0 until dayOfWeek-cnt-1){
                        val tempCal = Calendar.getInstance().clone() as Calendar
                        tempCal.timeInMillis = data[i].timestamp
                        println("test: $j + $firstDayOfWeek + $dayOfWeek - 1")
                        tempCal.set(Calendar.DAY_OF_WEEK, j+firstDayOfWeek+dayOfWeek-1)
                        tempCal.set(Calendar.HOUR_OF_DAY, 11)
                        morningEntities.add(EventEntity(tempCal.timeInMillis, "general", 0))
                        tempCal.set(Calendar.HOUR_OF_DAY, 13)
                        lunchEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
                        tempCal.set(Calendar.HOUR_OF_DAY, 19)
                        dinnerEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
                    }
                }
                **/
                // check type
                val type = getType(data[i].timestamp)
                // if type is bigger than 0, run loop to fill 0 until the type
                for(j in 0 until type){
                    val tempCal = Calendar.getInstance().clone() as Calendar
                    tempCal.timeInMillis = data[i].timestamp
                    tempCal.set(
                            Calendar.HOUR_OF_DAY,
                            if(j == 0) 11 else 13
                    )
                    eventStack.push(EventEntity(tempCal.timeInMillis, "meal", 0))
                }
                // push current type event
                eventStack.push(data[i])

                cnt = dayOfWeek
            } else {
                // same day, new data
                // check type (morning, lunch, dinner)
                val type = getType(data[i].timestamp)
//                println(type)
                // compare with peeked value
                if(eventStack.isNotEmpty()){
                    // if eventStack is not empty
                    val curEvent = eventStack.peek()
                    val curType = getType(curEvent.timestamp)
                    if(type == curType){
                        // compare value
                        eventStack.pop()
                        eventStack.push(if(data[i].value > curEvent.value) data[i] else curEvent)
                    } else if(type > curType) {
                        // new type
                        eventStack.push(data[i])
                    } else {
                        // -1 error
                        // cannot compare. put back the old value
                        // ERROR alert
                        eventStack.push(curEvent)
                    }
                } else {
                    //  if eventStack is empty, probably the first item to add
                    eventStack.push(data[i])
                }
            }

//            if(hour < 12){ // morning
//                morningEntities.add(data[i])
//            } else if(hour > 12 && hour < 16){ // lunch
//                lunchEntities.add(data[i])
//            } else if(hour > 18 && hour < 22){ // dinner
//                dinnerEntities.add(data[i])
//            }
        }

        println("morning")
        for(i in morningEntities.indices){
            val calendar = Calendar.getInstance().clone() as Calendar
            calendar.timeInMillis = morningEntities[i].timestamp
            println("${morningEntities[i].value} / ${calendar.time}")
        }

        println("lunch")
        for(i in lunchEntities.indices){
            val calendar = Calendar.getInstance().clone() as Calendar
            calendar.timeInMillis = lunchEntities[i].timestamp
            println("${lunchEntities[i].value} / ${calendar.time}")
        }

        println("dinner")
        for(i in dinnerEntities.indices){
            val calendar = Calendar.getInstance().clone() as Calendar
            calendar.timeInMillis = dinnerEntities[i].timestamp
            println("${dinnerEntities[i].value} / ${calendar.time}")
        }



    }

    /**
     * type:
     * 0 -> morning
     * 1 -> lunch
     * 2 -> dinner
     */
    private fun getType(data: Long): Int{
        val cal = Calendar.getInstance().clone() as Calendar
        cal.timeInMillis = data
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        return when {
            hour < 12 -> 0
            12 < hour && hour < 16 -> 1
            18 < hour && hour < 22 -> 2
            else -> -1
        }
//        return if(hour < 12){ // morning
//            0
//        } else if(hour > 12 && hour < 16){ // lunch
//            1
//        } else if(hour > 18 && hour < 22){ // dinner
//            2
//        } else {
//            -1
//        }
    }
}