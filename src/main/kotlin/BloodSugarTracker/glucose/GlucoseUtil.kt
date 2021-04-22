package BloodSugarTracker.glucose

import BloodSugarTracker.lastWeekChartDataTest.EventEntity
import BloodSugarTracker.lastWeekChartDataTest.EventEntityGenerator
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val ldt = LocalDateTime.now().minusMonths(1)
    val timestampLong = Timestamp.valueOf(ldt).time

    val eventEntities = ArrayList<EventEntity>()
    val answerEntities = ArrayList<EventEntity>()
    EventEntityGenerator().generateEntitiesFrom(timestampLong, eventEntities, answerEntities)
    println("====================================")

    GlucoseUtil().getGlucoseSpikeIndex(
        eventEntities
    )
}

class GlucoseUtil {

    data class DiffEntity(
        val diff: Int,
        val timestamp: Long
    )

    fun getGlucoseSpikeIndex(
        eventEntities: ArrayList<EventEntity>
    ){
//        val lunchDiff = ArrayList<Int>()
//        val dinnerDiff = ArrayList<Int>()

        val diffValues = ArrayList<Int>()
        getGlucoseDiffValues(eventEntities, diffValues)
    }

    fun organizeValues(
        eventEntities: ArrayList<EventEntity>,
        lunchDiff: ArrayList<Int>,
        dinnerDiff: ArrayList<Int>
    ){
        for(currentEntity in eventEntities){
            val type = getEventType(currentEntity.timestamp)
            when(type){
                1 -> {

                }
                2 -> {

                }
            }
        }
    }

    fun getGlucoseDiffValues(
        eventEntities: ArrayList<EventEntity>,
        diffValues: ArrayList<Int>
    ){
        val eventStack = Stack<EventEntity>()
        for(event in eventEntities){
            if(eventStack.isEmpty()){
                eventStack.push(event)
                continue
            }

            val peekedEntity = eventStack.peek()
            if(isSameDay(peekedEntity.timestamp, event.timestamp)
                && getEventType(peekedEntity.timestamp) == getEventType(event.timestamp)
            ){
                // same day & same type
                eventStack.push(event)
            } else {
                // new day or new type
                if(eventStack.size > 1){ // has more than 2 entities
                    val poppedEntities = ArrayList<EventEntity>()
                    // get glucose spike for current instance
                    while(eventStack.isNotEmpty()){
                        poppedEntities.add(eventStack.pop())
                    }
                } else { // only 1 entity. not enough information.
                    eventStack.clear()
                    eventStack.push(event)
                }
            }
        }
    }

    /**
     * type:
     * 0 -> morning
     * 1 -> lunch
     * 2 -> dinner
     */
    private fun getEventType(timestamp: Long): Int{
        val cal = Calendar.getInstance().clone() as Calendar
        cal.timeInMillis = timestamp
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        return when {
            hour < 12 -> 0
            12 < hour && hour < 16 -> 1
            18 < hour && hour < 22 -> 2
            else -> -1
        }
    }

    private fun isSameDay(old: Long, new: Long): Boolean{
        val cal = Calendar.getInstance().clone() as Calendar
        cal.timeInMillis = old
        val oldDay = cal.get(Calendar.DAY_OF_MONTH)
        cal.timeInMillis = new
        val newDay = cal.get(Calendar.DAY_OF_MONTH)
        return oldDay == newDay
    }


}