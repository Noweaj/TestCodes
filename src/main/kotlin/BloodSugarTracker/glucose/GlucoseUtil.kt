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

        println("eventEntities size: ${eventEntities.size}")

        val spikeEntities = ArrayList<EventEntity>()
        val suspiciousEntities = ArrayList<EventEntity>()
        val normalEntities = ArrayList<EventEntity>()
        getGlucoseDiffValues(eventEntities, spikeEntities, suspiciousEntities, normalEntities, false)

//        println(spikeEntities)
        println("spike")
        for(i in spikeEntities.indices){
            println("${Timestamp(spikeEntities[i].timestamp).toLocalDateTime()} ${spikeEntities[i].value}")
        }
        println("spike size: ${spikeEntities.size}")
//        println(suspiciousEntities)
        println("suspicious")
        for(i in suspiciousEntities.indices){
            println("${Timestamp(suspiciousEntities[i].timestamp).toLocalDateTime()} ${suspiciousEntities[i].value}")
        }
        println("suspicous size: ${suspiciousEntities.size}")

        println("normal")
        for(i in normalEntities.indices){
            println("${Timestamp(normalEntities[i].timestamp).toLocalDateTime()} ${normalEntities[i].value}")
        }
        println("normal size: ${normalEntities.size}")
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

    private val diabetesSpikeThreshold = 200
    private val nonDiabetesSpikeThreshold = 180
    private val glucoseSpikeThreshold = 150

    fun getGlucoseDiffValues(
        eventEntities: ArrayList<EventEntity>,
        spikeEntities: ArrayList<EventEntity>,
        suspiciousEntities: ArrayList<EventEntity>,
        normalEntities: ArrayList<EventEntity>,
        isDiabetic: Boolean
    ){
        val eventStack = Stack<EventEntity>()
        var cnt = 0
        for(event in eventEntities){
            if(event.event == "general")
                continue
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
//                // new day or new type
//                if(eventStack.size > 1){ // has more than 2 entities
//                    cnt++
//                    val poppedEntities = ArrayList<EventEntity>()
//                    // get glucose spike for current instance
//                    var minEntity = peekedEntity
//                    var maxEntity = peekedEntity
//                    while(eventStack.isNotEmpty()){
//                        val poppedEntity = eventStack.pop()
//                        if(poppedEntity.value > maxEntity.value){
//                            maxEntity = poppedEntity
//                        }
//                        if(poppedEntity.value < minEntity.value){
//                            minEntity = poppedEntity
//                        }
//                        poppedEntities.add(poppedEntity)
//                    }
//
//                    if(maxEntity.value > glucoseSpikeThreshold){
//                        // suspicious glucose spike
//                        if(isDiabetic){
//                            if(maxEntity.value)
//
//                            if(maxEntity.value > 190){
//                                suspiciousEntities.add(maxEntity)
//                            }
//                        } else {
//
//                        }
//                        if(maxEntity.value > 175){
//                            // glucose spike!
//                            spikeEntities.add(maxEntity)
//                        }
//                    }
//
//
//
//
//
//                    // curve fitting
//                    // get equation of data points
//                    // get derivative
//                } else { // only 1 entity. not enough information.
//                    val poppedEntity = eventStack.pop()
//                    if(poppedEntity.value > 150) {
//                        if(isDiabetic){
//
//                        } else {
//                            if(poppedEntity.value > 175){
//                                spikeEntities.add(poppedEntity)
//                            }
//                        }
//                    }
//                }

    cnt++
                var maxEntity = eventStack.peek()
                while(eventStack.isNotEmpty()){
                    val poppedEntity = eventStack.pop()
                    if(poppedEntity.value > maxEntity.value){
                        maxEntity = poppedEntity
                    }
                }

                if(isDiabetic){
                    if(maxEntity.value > diabetesSpikeThreshold*.9 && maxEntity.value < diabetesSpikeThreshold){
                        // warning
                        suspiciousEntities.add(maxEntity)
                    } else if(maxEntity.value >= diabetesSpikeThreshold){
                        // glucose spike
                        spikeEntities.add(maxEntity)
                    } else {
                        normalEntities.add(maxEntity)
                    }
                } else {
                    if(maxEntity.value > nonDiabetesSpikeThreshold*.9 && maxEntity.value < nonDiabetesSpikeThreshold){
                        suspiciousEntities.add(maxEntity)
                    } else if(maxEntity.value >= nonDiabetesSpikeThreshold){
                        spikeEntities.add(maxEntity)
                    } else {
                        normalEntities.add(maxEntity)
                    }
                }

                eventStack.clear()
                eventStack.push(event)
            }
        }
        println(cnt)
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