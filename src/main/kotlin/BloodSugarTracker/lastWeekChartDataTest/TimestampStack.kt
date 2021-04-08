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



//    val data = arrayListOf(
//            EventEntity(1616976121001, "meal", 94),
//            EventEntity(1616990821001, "meal", 163),
//            EventEntity(1616994421001, "meal", 173),
//            EventEntity(1617013261001, "meal", 132),
//            EventEntity(1617016861001, "meal", 92),
//            EventEntity(1617020461001, "meal", 117),
//            EventEntity(1617062821001, "meal", 90),
//            EventEntity(1617077161001, "meal", 134),
//            EventEntity(1617080761001, "meal", 90),
//            EventEntity(1617098581001, "meal", 141),
//            EventEntity(1617102181001, "meal", 117),
//            EventEntity(1617108361001, "meal", 172),
//            EventEntity(1617154141001, "meal", 160),
//            EventEntity(1617165601001, "meal", 117),
//            EventEntity(1617169201001, "meal", 159),
//            EventEntity(1617185881001, "meal", 174),
//            EventEntity(1617189481001, "meal", 120),
//            EventEntity(1617194161001, "meal", 123),
//            EventEntity(1617238081001, "meal", 142),
//            EventEntity(1617253021001, "meal", 176),
//            EventEntity(1617256621001, "meal", 179),
//            EventEntity(1617274141001, "meal", 175),
//            EventEntity(1617277741001, "meal", 103),
//            EventEntity(1617281881001, "meal", 176),
//            EventEntity(1617325921001, "meal", 106),
//            EventEntity(1617338701001, "meal", 134),
//            EventEntity(1617342301001, "meal", 136),
//            EventEntity(1617360841001, "meal", 140),
//            EventEntity(1617364441001, "meal", 104),
//            EventEntity(1617367981001, "meal", 114),
//            EventEntity(1617409321001, "meal", 153),
//            EventEntity(1617425161001, "meal", 140),
//            EventEntity(1617428761001, "meal", 135),
//            EventEntity(1617447361001, "meal", 174),
//            EventEntity(1617450961001, "meal", 142),
//            EventEntity(1617453721001, "meal", 166),
//            EventEntity(1617496081001, "meal", 173),
//            EventEntity(1617510961001, "meal", 140),
//            EventEntity(1617514561001, "meal", 114),
//            EventEntity(1617532681001, "meal", 120),
//            EventEntity(1617536281001, "meal", 92),
//            EventEntity(1617538981001, "meal", 109),
//            EventEntity(1617581941001, "meal", 117),
//            EventEntity(1617595501001, "meal", 161),
//            EventEntity(1617599101001, "meal", 98),
//            EventEntity(1617617701001, "meal", 156),
//            EventEntity(1617621301001, "meal", 168),
//            EventEntity(1617627421001, "meal", 148),
//            EventEntity(1617668221001, "meal", 142),
//            EventEntity(1617682561001, "meal", 173),
//            EventEntity(1617686161001, "meal", 93),
//            EventEntity(1617705721001, "meal", 113),
//            EventEntity(1617709321001, "meal", 174),
//            EventEntity(1617713041001, "meal", 136)
//    )
    val general = "general"
    val meal = "meal"
    val exercise = "exercise"

    val data = arrayListOf(
        EventEntity(1616980105966, "general", 93),
        EventEntity(1617016105966, "meal", 145),
        EventEntity(1617026905966, "exercise", 125),
        EventEntity(1617066505966, "general", 84),
        EventEntity(1617070105966, "general", 97),
        EventEntity(1617084505966, "meal", 137),
        EventEntity(1617098905966, "meal", 153),
        EventEntity(1617152905966, "general", 88),
        EventEntity(1617156505966, "general", 91),
        EventEntity(1617167305966, "meal", 164),
        EventEntity(1617170905966, "meal", 114),
        EventEntity(1617188905966, "meal", 134),
        EventEntity(1617199705966, "exercise", 135),
        EventEntity(1617253705966, "meal", 165),
        EventEntity(1617257305966, "meal", 127),
        EventEntity(1617275305966, "meal", 120),
        EventEntity(1617329305966, "general", 93),
        EventEntity(1617340105966, "meal", 167),
        EventEntity(1617415705966, "general", 84),
        EventEntity(1617426505966, "meal", 167),
        EventEntity(1617430105966, "meal", 139),
        EventEntity(1617530905966, "meal", 163),
        EventEntity(1617545305966, "exercise", 130),
        EventEntity(1617617305966, "meal", 189),
        EventEntity(1617620905966, "meal", 114),
        EventEntity(1617689305966, "meal", 118),
        EventEntity(1617703705966, "meal", 158),
        EventEntity(1617707305966, "meal", 117),
        EventEntity(1617718105966, "exercise", 124),
        EventEntity(1617757705966, "general", 82),
        EventEntity(1617761305966, "general", 99),
        EventEntity(1617790105966, "meal", 172),
        EventEntity(1617793705966, "meal", 123)
    )

    val timestampStack = TimestampStack()
    val (morningEntities, lunchEntities, dinnerEntities) = mutableListOf(
            ArrayList<EventEntity>(), ArrayList<EventEntity>(), ArrayList<EventEntity>()
    )
    timestampStack.stackAlgorithm(
            data,
            morningEntities,
            lunchEntities,
            dinnerEntities
    )
}

fun getRandomValue(from: Int, to: Int): Int{
    val random = Random()
    return random.nextInt(to-from)+from
}

class TimestampStack {

    fun stackAlgorithm(
            data: ArrayList<EventEntity>,
            morningEntities: ArrayList<EventEntity>,
            lunchEntities: ArrayList<EventEntity>,
            dinnerEntities: ArrayList<EventEntity>
    ){

        val cal = Calendar.getInstance().clone() as Calendar

//        val morningEntities = ArrayList<EventEntity>()
//        val lunchEntities = ArrayList<EventEntity>()
//        val dinnerEntities = ArrayList<EventEntity>()

        var eventStack = Stack<EventEntity>()

        val firstDayOfWeek = Calendar.MONDAY

        // need to store current date by long and get specific date by cal.get(Calendar.DAY_OF_WEEK)
        // maybe not. we can get previous event data from the Entities array
        var cnt = 0 // current date
        var max = 0

        val NOW = cal.timeInMillis
        cal.timeInMillis = cal.timeInMillis-(24*7*3600000L)

        cal.set(Calendar.HOUR_OF_DAY, 1)
        cal.set(Calendar.MINUTE, 1)
        cal.set(Calendar.MILLISECOND, 1)

        cal.firstDayOfWeek = firstDayOfWeek
        cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)
        val LASTWEEK_FIRSTDAY = cal.timeInMillis
        val LASTWEEK_DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH)

        var previousEventEntity = LASTWEEK_FIRSTDAY

        for(i in data.indices){

            cal.timeInMillis = data[i].timestamp
            val currentDayOfMonth = cal.get(Calendar.DAY_OF_MONTH)
            val currentDay = cal.get(Calendar.DAY_OF_WEEK)

            // check if starting date is not 'firstDayOfWeek' so we can fill 0 until the starting date
//            println("currentDayOfMonth $currentDayOfMonth")
//            println("LASTWEEK_DAY_OF_MONTH: $LASTWEEK_DAY_OF_MONTH")
            if(i == 0 && currentDayOfMonth != LASTWEEK_DAY_OF_MONTH){
                val numOfDays = (cal.timeInMillis - LASTWEEK_FIRSTDAY) / (24*3600000L)
                for(j in 0 until numOfDays){
                    cal.timeInMillis = data[i].timestamp
                    cal.set(Calendar.DAY_OF_WEEK, j.toInt() + firstDayOfWeek)
                    cal.set(Calendar.HOUR_OF_DAY, 11)
                    morningEntities.add(EventEntity(cal.timeInMillis, "general", 0))
                    cal.set(Calendar.HOUR_OF_DAY, 13)
                    lunchEntities.add(EventEntity(cal.timeInMillis, "meal", 0))
                    cal.set(Calendar.HOUR_OF_DAY, 19)
                    dinnerEntities.add(EventEntity(cal.timeInMillis, "meal", 0))
                }
                cal.set(Calendar.HOUR_OF_DAY, 12)
                previousEventEntity = cal.timeInMillis + 24*3600000L
            }

            // check isSameDay with prev EventEntity
            // NEED TO COMPARE WITH LONG VALUE
            cal.timeInMillis = previousEventEntity
            val prevEntityDayOfMonth = cal.get(Calendar.DAY_OF_MONTH)
            if(prevEntityDayOfMonth != currentDayOfMonth){ // so input data must be sorted
                // new day
                // check number of values in eventStack and fill if empty
                if(3 - eventStack.size == 1){
                    // only 1 missing
                    cal.timeInMillis = eventStack.peek().timestamp
                    cal.set(Calendar.HOUR_OF_DAY, 19)
                    eventStack.push(EventEntity(cal.timeInMillis, "meal", 0)) // dinner
                } else if(3 - eventStack.size == 2){
                    // 2 missing
                    cal.timeInMillis = eventStack.peek().timestamp
                    cal.set(Calendar.HOUR_OF_DAY, 13)
                    eventStack.push(EventEntity(cal.timeInMillis, "meal", 0)) // lunch
                    cal.set(Calendar.HOUR_OF_DAY, 19)
                    eventStack.push(EventEntity(cal.timeInMillis, "meal", 0)) // dinner
                }
                // save results
                dinnerEntities.add(eventStack.pop())
                lunchEntities.add(eventStack.pop())
                morningEntities.add(eventStack.pop())

                // clear stack
                eventStack.clear()

                // check if there is gap between data date and old date
                // if more than a day, fill

                // BUG: using lunchEntities is a bad idea. find anoyher way to get 1 exactly day

                // check type
                val type = getType(data[i].timestamp)

                val targetTimestamp = dinnerEntities[dinnerEntities.size-1].timestamp

                if(data[i].timestamp - targetTimestamp > (24+8)*3600000L){ // 24hour was not enough (ex: 19:00 vs 20:00 becomes more than 24 hours)
                    println("INSIDE")
                    val numOfDays = ((data[i].timestamp - targetTimestamp)-(8*3600000L))/(24*3600000L)
                    var refTimestamp = targetTimestamp
                    for(j in 0 until numOfDays){
                        refTimestamp += (24*3600000L)
                        cal.timeInMillis = refTimestamp
                        cal.set(Calendar.HOUR_OF_DAY, 11)
                        morningEntities.add(EventEntity(cal.timeInMillis, "general", 0))
                        cal.set(Calendar.HOUR_OF_DAY, 13)
                        lunchEntities.add(EventEntity(cal.timeInMillis, "meal", 0))
                        cal.set(Calendar.HOUR_OF_DAY, 19)
                        dinnerEntities.add(EventEntity(cal.timeInMillis, "meal", 0))
                    }
                }

                // if type is bigger than 0, run loop to fill 0 until the type
                for(j in 0 until type){
                    cal.timeInMillis = data[i].timestamp
                    cal.set(Calendar.HOUR_OF_DAY, if(j == 0) 11 else 13)
                    eventStack.push(EventEntity(cal.timeInMillis, "meal", 0))
                }
                eventStack.push(data[i])

                previousEventEntity = data[i].timestamp
            } else {
                // same day
                // get current data type (morning, lunch, dinner)
                val currentType = getType(data[i].timestamp)
                // compare with peek data if not empty
                if(eventStack.isNotEmpty()){
                    val stackEvent = eventStack.peek()
                    val stackEventType = getType(stackEvent.timestamp)
                    if(currentType == stackEventType){
                        // same type. compare value and put the larger one
                        eventStack.pop()
                        eventStack.push(if(data[i].value > stackEvent.value) data[i] else stackEvent)
                    } else if(currentType > stackEventType){
                        // new type.
                        if(currentType - stackEventType > 1){
                            // currentType -> dinner while stack has only morning event
                            cal.timeInMillis = data[i].timestamp
                            cal.set(Calendar.HOUR_OF_DAY, 13)
                            eventStack.push(EventEntity(cal.timeInMillis, "meal", 0))
                        }
                        eventStack.push(data[i])
                    } else {
                        // -1 error on getType()
                        // ERROR Alert
                    }
                } else { // stack is empty
                    // if stack is empty, check if type is 0
                    val type = getType(data[i].timestamp)
                    if(type == 0){
                        // this is the first item to add
                        eventStack.push(data[i])
                    } else {
                        for(j in 0 until type - 0){
                            // if 1, add morning only
                            if(j == 0){
                                cal.timeInMillis = data[i].timestamp
                                cal.set(Calendar.HOUR_OF_DAY, 11)
                                eventStack.push(EventEntity(cal.timeInMillis, "general", 0))
                            } else {
                                cal.timeInMillis = data[i].timestamp
                                cal.set(Calendar.HOUR_OF_DAY, 13)
                                eventStack.push(EventEntity(cal.timeInMillis, "meal", 0))
                            }
                        }
                        eventStack.push(data[i])
                    }
                }
            }











//
//            cal.timeInMillis = data[i].timestamp
//            val day = cal.get(Calendar.DAY_OF_WEEK) - firstDayOfWeek
//            val dayOfWeek = if(day == -1) 6 else day
//
////            val hour = cal.get(Calendar.HOUR_OF_DAY)
////            println("dayOfWeek: $dayOfWeek")
//
//            if(i == 0 && dayOfWeek != 0){
////                println("!")
//                // start entity is not "firstDayOfWeek"
//                // fill 0 until dayOfWeek
//                for(j in 0 until dayOfWeek){
//                    val tempCal = Calendar.getInstance().clone() as Calendar
//                    tempCal.timeInMillis = data[i].timestamp
//                    tempCal.set(Calendar.DAY_OF_WEEK, j + firstDayOfWeek)
//                    tempCal.set(Calendar.HOUR_OF_DAY, 11)
//                    morningEntities.add(EventEntity(tempCal.timeInMillis, "general", 0))
//                    tempCal.set(Calendar.HOUR_OF_DAY, 13)
//                    lunchEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
//                    tempCal.set(Calendar.HOUR_OF_DAY, 19)
//                    dinnerEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
//                }
//                cnt = dayOfWeek
//            }
////            println(eventStack)
//
//            if(dayOfWeek != cnt){
////                println(eventStack)
//                // new day
//                // check number of values in eventStack and fill if empty
//                if(3 - eventStack.size == 1){
//                    val tempCal = Calendar.getInstance().clone() as Calendar
//                    tempCal.timeInMillis = eventStack.peek().timestamp
//                    tempCal.set(Calendar.HOUR_OF_DAY, 19)
//                    eventStack.push(EventEntity(tempCal.timeInMillis, "meal", 0)) // dinner
//                } else if(3 - eventStack.size == 2){
//                    val tempCal = Calendar.getInstance().clone() as Calendar
//                    tempCal.timeInMillis = eventStack.peek().timestamp
//                    tempCal.set(Calendar.HOUR_OF_DAY, 13)
//                    eventStack.push(EventEntity(tempCal.timeInMillis, "meal", 0)) // lunch
//                    tempCal.set(Calendar.HOUR_OF_DAY, 19)
//                    eventStack.push(EventEntity(tempCal.timeInMillis, "meal", 0)) // dinner
//                }
//                // save results
//                dinnerEntities.add(eventStack.pop())
//                lunchEntities.add(eventStack.pop())
//                morningEntities.add(eventStack.pop())
//                // clear stack
//                eventStack.clear()
//                if(data[i].timestamp - lunchEntities[lunchEntities.size-1].timestamp > 24*3600000L){
//                    val numOfDays = (data[i].timestamp - lunchEntities[lunchEntities.size-1].timestamp)/(24*3600000L)
////                    println(numOfDays)
//                    var refTimestamp = lunchEntities[lunchEntities.size-1].timestamp
//                    for(j in 0 until numOfDays-1){
//                        val tempCal = Calendar.getInstance().clone() as Calendar
//                        refTimestamp += (24*3600000L)
//                        tempCal.timeInMillis = refTimestamp
//                        tempCal.set(Calendar.HOUR_OF_DAY, 11)
//                        morningEntities.add(EventEntity(tempCal.timeInMillis, "general", 0))
//                        tempCal.set(Calendar.HOUR_OF_DAY, 13)
//                        lunchEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
//                        tempCal.set(Calendar.HOUR_OF_DAY, 19)
//                        dinnerEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
//                    }
//                }
//
//                /**
//                 * this method does not work when month changes...
//                if(dayOfWeek - cnt > 1){
//                    // gap exists. fill 0 for gaps
//                    for(j in 0 until dayOfWeek-cnt-1){
//                        val tempCal = Calendar.getInstance().clone() as Calendar
//                        tempCal.timeInMillis = data[i].timestamp
//                        println("test: $j + $firstDayOfWeek + $dayOfWeek - 1")
//                        tempCal.set(Calendar.DAY_OF_WEEK, j+firstDayOfWeek+dayOfWeek-1)
//                        tempCal.set(Calendar.HOUR_OF_DAY, 11)
//                        morningEntities.add(EventEntity(tempCal.timeInMillis, "general", 0))
//                        tempCal.set(Calendar.HOUR_OF_DAY, 13)
//                        lunchEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
//                        tempCal.set(Calendar.HOUR_OF_DAY, 19)
//                        dinnerEntities.add(EventEntity(tempCal.timeInMillis, "meal", 0))
//                    }
//                }
//                **/
//                // check type
//                val type = getType(data[i].timestamp)
//                // if type is bigger than 0, run loop to fill 0 until the type
//                for(j in 0 until type){
//                    val tempCal = Calendar.getInstance().clone() as Calendar
//                    tempCal.timeInMillis = data[i].timestamp
//                    tempCal.set(
//                            Calendar.HOUR_OF_DAY,
//                            if(j == 0) 11 else 13
//                    )
//                    eventStack.push(EventEntity(tempCal.timeInMillis, "meal", 0))
//                }
//                // push current type event
//                eventStack.push(data[i])
//
//                cnt = dayOfWeek
//            } else {
//                // same day, new data
//                // check type (morning, lunch, dinner)
//                val type = getType(data[i].timestamp)
////                println(type)
//                // compare with peeked value
//                if(eventStack.isNotEmpty()){
//                    /**
//                     * bug: cannot detect if morning and lunch data is empty and only exists.
//                     */
//                    // if eventStack is not empty
//                    val curEvent = eventStack.peek()
//                    val curType = getType(curEvent.timestamp)
//                    if(type == curType){
//                        // compare value
//                        eventStack.pop()
//                        eventStack.push(if(data[i].value > curEvent.value) data[i] else curEvent)
//                    } else if(type > curType) {
//                        // new type
//                        // check if diff is more than 1
//                        if(type - curType > 1){
//                            val tempCal = Calendar.getInstance().clone() as Calendar
//                            tempCal.timeInMillis = data[i].timestamp
//                            tempCal.set(Calendar.HOUR_OF_DAY, 13)
//                            eventStack.push(EventEntity(tempCal.timeInMillis, "meal", 0))
//                        }
//                        eventStack.push(data[i])
//                    } else {
//                        // -1 error
//                        // cannot compare. put back the old value
//                        // ERROR alert
//                        eventStack.push(curEvent)
//                    }
//                } else {
//                    //  if eventStack is empty, probably the first item to add
//                    eventStack.push(data[i])
//                }
//            }

//            if(hour < 12){ // morning
//                morningEntities.add(data[i])
//            } else if(hour > 12 && hour < 16){ // lunch
//                lunchEntities.add(data[i])r
//            } else if(hour > 18 && hour < 22){ // dinner
//                dinnerEntities.add(data[i])
//            }
        }

        // put remaining stack entities into arrayLists

        // fill stack with 3 entities with zeros if needed
        for(i in 0 until 3 - eventStack.size){
            cal.timeInMillis = eventStack.peek().timestamp
            eventStack.push(when(i){
                0 -> { // lunch
                    cal.set(Calendar.HOUR_OF_DAY, 13)
                    EventEntity(cal.timeInMillis, "meal", 0)
                }
                else -> { // dinner
                    cal.set(Calendar.HOUR_OF_DAY, 19)
                    EventEntity(cal.timeInMillis, "meal", 0)
                }
            })
        }

        dinnerEntities.add(eventStack.pop())
        lunchEntities.add(eventStack.pop())
        morningEntities.add(eventStack.pop())

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