package BloodSugarTracker.fillZeroBetweenTimestamp

import java.util.*

fun main(){
    val cal = Calendar.getInstance().clone() as Calendar

    cal.set(Calendar.DAY_OF_MONTH, 30)
    println(cal.time)

    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+1)
    println(cal.time)

    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+1)
    println(cal.time)
}