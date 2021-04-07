package BloodSugarTracker.lastWeekChartDataTest

import java.util.*

fun main(){
    generateEventEntities()
}

fun generateEventEntities(){
    for(i in 0 until 7){

    }
}

private fun isSkip(): Boolean {
    return getRandom(0, 3) > 1 // 33%
}

private fun getRandom(min: Int, max: Int): Int {
    return Random().nextInt(max-min)+min
}