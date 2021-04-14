package LocalDateTimeTest

import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.WeekFields
import java.util.*

fun main(){
    val localDateTime = LocalDateTime.now()
    val localDate = LocalDate.now()
    val localTime = LocalTime.now()

    val localDateTimeLastWeek = localDateTime.minusWeeks(1)
    println(localDateTimeLastWeek)

    val localdateTimeTwoWeeksAgo = localDateTime.minusWeeks(2)
    println(localdateTimeTwoWeeksAgo)

    val localDateTimeSaved = LocalDateTime.parse(localdateTimeTwoWeeksAgo.toString()).plusYears(1)
    println(localDateTimeSaved)

    val localDateTimeMonday = localDateTime.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1)
    println(localDateTimeMonday) // sunday if Locale.getDefault()

    val timestampMonday = Timestamp.valueOf(localDateTime)
    println(timestampMonday.time)

    println(timestampMonday.toLocalDateTime())

    val cal = Calendar.getInstance()
    println(cal.timeInMillis)

    val timestampNow = Timestamp.valueOf(localDateTime)
    val timestampNew = Timestamp(timestampNow.time)
    println(timestampNew.time)
    println(timestampNew.toLocalDateTime())
}