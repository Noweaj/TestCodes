package BloodSugarTracker.lastWeekChartDataTest

object ResultChecker {
    data class MyResult(
            val pass: Boolean,
            val msg: String
    )

    fun checkAnswer(list: ArrayList<MyData>, answer: ArrayList<Int>): MyResult {
        if(list.size != answer.size){
            return MyResult(false, "Size Error: ${list.size} vs ${answer.size}")
        }
        for(i in list.indices){
            if(list[i].value != answer[i]){
                return MyResult(false, "Error: $i ${list[i].value} vs ${answer[i]}")
            }
        }
        return MyResult(true, "All checked")
    }
}