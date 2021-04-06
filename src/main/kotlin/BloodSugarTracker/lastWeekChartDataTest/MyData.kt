package BloodSugarTracker.lastWeekChartDataTest

import java.util.*

data class MyData(
        val time: Int,
        val value: Int
) {
    override fun hashCode(): Int {
        return Objects.hash(time)
    }

    override fun equals(other: Any?): Boolean {
        return (other as MyData).time == this.time
    }
}