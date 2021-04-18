package BloodSugarTracker.lastWeekChartDataTest

import java.sql.Timestamp
import java.time.DayOfWeek

fun main(){

    val data = arrayListOf(
        EventEntity(1617580834000, "general", 98), // 2021-04-05T09:00:34
        EventEntity(1617591634000, "meal", 155), // 2021-04-05T12:00:34
        EventEntity(1617616834000, "meal", 174), // 2021-04-05T19:00:34
        EventEntity(1617620434000, "meal", 134), // 2021-04-05T20:00:34
        EventEntity(1617663634000, "general", 93), // 2021-04-06T08:00:34
        EventEntity(1617703234000, "meal", 170), // 2021-04-06T19:00:34
        EventEntity(1617706834000, "meal", 130), // 2021-04-06T20:00:34
        EventEntity(1617753634000, "general", 92), // 2021-04-07T09:00:34
        EventEntity(1617764434000, "meal", 176), // 2021-04-07T12:00:34
        EventEntity(1617768034000, "meal", 136), // 2021-04-07T13:00:34
        EventEntity(1617796834000, "meal", 121), // 2021-04-07T21:00:34
        EventEntity(1617836434000, "general", 83), // 2021-04-08T08:00:34
        EventEntity(1617850834000, "meal", 176), // 2021-04-08T12:00:34
        EventEntity(1617854434000, "meal", 136), // 2021-04-08T13:00:34
        EventEntity(1617876034000, "meal", 189), // 2021-04-08T19:00:34
        EventEntity(1617879634000, "meal", 149), // 2021-04-08T20:00:34
        EventEntity(1617922834000, "general", 88), // 2021-04-09T08:00:34
        EventEntity(1617940834000, "meal", 156), // 2021-04-09T13:00:34
        EventEntity(1617944434000, "meal", 116), // 2021-04-09T14:00:34
        EventEntity(1617966034000, "meal", 181), // 2021-04-09T20:00:34
        EventEntity(1618016434000, "general", 93), // 2021-04-10T10:00:34
        EventEntity(1618034434000, "meal", 135), // 2021-04-10T15:00:34
        EventEntity(1618048834000, "meal", 177), // 2021-04-10T19:00:34
        EventEntity(1618052434000, "meal", 137), // 2021-04-10T20:00:34
        EventEntity(1618099234000, "general", 85), // 2021-04-11T09:00:34
        EventEntity(1618117234000, "meal", 167), // 2021-04-11T14:00:34
        EventEntity(1618146034000, "meal", 145), // 2021-04-11T22:00:34
        EventEntity(1618192834000, "general", 89), // 2021-04-12T11:00:34
        EventEntity(1618200034000, "meal", 161), // 2021-04-12T13:00:34
        EventEntity(1618203634000, "meal", 121), // 2021-04-12T14:00:34
        EventEntity(1618225234000, "meal", 188), // 2021-04-12T20:00:34
        EventEntity(1618228834000, "meal", 148), // 2021-04-12T21:00:34
        EventEntity(1618275634000, "general", 83), // 2021-04-13T10:00:34
        EventEntity(1618286434000, "meal", 156), // 2021-04-13T13:00:34
        EventEntity(1618290034000, "meal", 116), // 2021-04-13T14:00:34
        EventEntity(1618304434000, "meal", 158), // 2021-04-13T18:00:34
        EventEntity(1618308034000, "meal", 118), // 2021-04-13T19:00:34
        EventEntity(1618354834000, "general", 84), // 2021-04-14T08:00:34
        EventEntity(1618380034000, "meal", 157), // 2021-04-14T15:00:34
        EventEntity(1618390834000, "meal", 174), // 2021-04-14T18:00:34
        EventEntity(1618394434000, "meal", 134), // 2021-04-14T19:00:34
        EventEntity(1618459234000, "meal", 154), // 2021-04-15T13:00:34
        EventEntity(1618462834000, "meal", 114), // 2021-04-15T14:00:34
        EventEntity(1618488034000, "meal", 141), // 2021-04-15T21:00:34
        EventEntity(1618531234000, "general", 87), // 2021-04-16T09:00:34
        EventEntity(1618542034000, "meal", 167), // 2021-04-16T12:00:34
        EventEntity(1618563634000, "meal", 185), // 2021-04-16T18:00:34
        EventEntity(1618567234000, "meal", 145) // 2021-04-16T19:00:34
    )

    val algorithm = Chart3Algorithm()
    val (lowest, highest) = mutableListOf(
        ArrayList<EventEntity>(), ArrayList<EventEntity>()
    )

    algorithm.getMonthlyChartData_ArrayList(data, lowest, highest)

    println("lowest")
    for(i in lowest.indices){
        println("${Timestamp(lowest[i].timestamp).toLocalDateTime().dayOfWeek} ${lowest[i]}")
    }

    println("highest")
    for(i in highest.indices){
        println("${Timestamp(highest[i].timestamp).toLocalDateTime().dayOfWeek} ${highest[i]}")
    }

}

class Chart3Algorithm{

    fun getMonthlyChartData_ArrayList(
        data: ArrayList<EventEntity>,
        lowest: ArrayList<EventEntity>,
        highest: ArrayList<EventEntity>
    ){
        val lowestMap: MutableMap<Int, EventEntity> = HashMap()
        val highestMap: MutableMap<Int, EventEntity> = HashMap()
        for(i in data.indices){
            println("${Timestamp(data[i].timestamp).toLocalDateTime().dayOfWeek} ${data[i]}")
            val newType = getDateType(data[i].timestamp)
            val lowerEntity = getLowerEntity(data[i], lowestMap[newType])
            lowestMap.put(newType, lowerEntity)
            val higherEntity = getHigherEntity(data[i], highestMap[newType])
            highestMap.put(newType, higherEntity)
        }

        lowest.addAll(ArrayList(lowestMap.values))
//        lowest.sortWith(Comparator { o1, o2 ->
//            (o1.timestamp - o2.timestamp).toInt()
//        })
        highest.addAll(ArrayList(highestMap.values))
    }

    private fun getLowerEntity(newEntity: EventEntity, oldEntity: EventEntity?): EventEntity{
        oldEntity?: return newEntity
        return if(newEntity.value > oldEntity.value) oldEntity else newEntity
    }

    private fun getHigherEntity(newEntity: EventEntity, oldEntity: EventEntity?): EventEntity{
        oldEntity?: return newEntity
        return if(newEntity.value >= oldEntity.value) newEntity else oldEntity
    }

    fun getMonthlyChartData_Map(
        data: ArrayList<EventEntity>,
        lowest: ArrayList<EventEntity>,
        highest: ArrayList<EventEntity>
    ){

    }

    /**
     * @return integer value of input data's day
     * 0 -> MON
     * 1 -> TUE
     * ...
     * 6 -> SUN
     * -1 -> ERR
     */
    private fun getDateType(data: Long): Int{
        val localDateTime = Timestamp(data).toLocalDateTime()
//        println(localDateTime.dayOfWeek)
        return when(localDateTime.dayOfWeek){
            DayOfWeek.MONDAY -> 0
            DayOfWeek.TUESDAY -> 1
            DayOfWeek.WEDNESDAY -> 2
            DayOfWeek.THURSDAY -> 3
            DayOfWeek.FRIDAY -> 4
            DayOfWeek.SATURDAY -> 5
            DayOfWeek.SUNDAY -> 6
            else -> -1
        }
    }
}