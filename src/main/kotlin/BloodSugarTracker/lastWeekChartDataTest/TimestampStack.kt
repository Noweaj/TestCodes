package BloodSugarTracker.lastWeekChartDataTest

import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val data = arrayListOf(
        1616976121001,
        1616990821001,
        1616994421001,
        1617013261001,
        1617016861001,
        1617020461001,
        1617062821001,
        1617077161001,
        1617080761001,
        1617098581001,
        1617102181001,
        1617108361001,
        1617154141001,
        1617165601001,
        1617169201001,
        1617185881001,
        1617189481001,
        1617194161001,
        1617238081001,
        1617253021001,
        1617256621001,
        1617274141001,
        1617277741001,
        1617281881001,
        1617325921001,
        1617338701001,
        1617342301001,
        1617360841001,
        1617364441001,
        1617367981001,
        1617409321001,
        1617425161001,
        1617428761001,
        1617447361001,
        1617450961001,
        1617453721001,
        1617496081001,
        1617510961001,
        1617514561001,
        1617532681001,
        1617536281001,
        1617538981001,
        1617581941001,
        1617595501001,
        1617599101001,
        1617617701001,
        1617621301001,
        1617627421001,
        1617668221001,
        1617682561001,
        1617686161001,
        1617705721001,
        1617709321001,
        1617713041001
    )
    val timestampStack = TimestampStack()
    timestampStack.stackAlgorithm(data)
}

class TimestampStack {

    fun stackAlgorithm(data: ArrayList<Long>){

        val cal = Calendar.getInstance().clone() as Calendar

        val morningEntities = ArrayList<Long>()
        val lunchEntities = ArrayList<Long>()
        val dinnerEntities = ArrayList<Long>()

        var eventStack = Stack<Long>()

        val firstDayOfWeek = Calendar.MONDAY

        var cnt = 0
        var max = 0
        for(i in data.indices){
            cal.timeInMillis = data[i]
            val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - firstDayOfWeek
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            println(dayOfWeek)

            if(cnt == 0 && dayOfWeek != 0){
                // start entity is not from "firstDayOfWeek"
                // fill 0 until dayOfWeek
            }

            if(dayOfWeek != cnt){
                // new day
                // save results
                dinnerEntities.add(eventStack.pop())
                lunchEntities.add(eventStack.pop())
                morningEntities.add(eventStack.pop())
                if(dayOfWeek - cnt > 1){
                    // gap exists. fill 0 for gaps

                    eventStack.clear()
                    // does morning data exist? does lunch data exist?

                } else {
                    // does morning data exist? does lunch data exist? you gotta have at least one
                }
            } else {
                // same day, new data
                // check type (morning, lunch, dinner)
                val type = getType(data[i])

                // check peek value to see if it's morning or lunch
            }

//            if(hour < 12){ // morning
//                morningEntities.add(data[i])
//            } else if(hour > 12 && hour < 16){ // lunch
//                lunchEntities.add(data[i])
//            } else if(hour > 18 && hour < 22){ // dinner
//                dinnerEntities.add(data[i])
//            }
        }

//        println("morning")
//        for(i in morningEntities.indices){
//            val calendar = Calendar.getInstance().clone() as Calendar
//            calendar.timeInMillis = morningEntities[i]
//            println(calendar.time)
//        }
//
//        println("lunch")
//        for(i in lunchEntities.indices){
//            val calendar = Calendar.getInstance().clone() as Calendar
//            calendar.timeInMillis = lunchEntities[i]
//            println(calendar.time)
//        }
//
//        println("dinner")
//        for(i in dinnerEntities.indices){
//            val calendar = Calendar.getInstance().clone() as Calendar
//            calendar.timeInMillis = dinnerEntities[i]
//            println(calendar.time)
//        }



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