package BloodSugarTracker.lastWeekChartDataTest

fun main(){
//    val sampleData = arrayListOf(
//            MyData(0, 2),
//            MyData(0, 3),
//            MyData(0, 1),
//            MyData(1, 6),
//            MyData(1, 5),
//            MyData(1, 7),
//            MyData(2, 2),
//            MyData(2, 1),
//            MyData(3, 5),
//            MyData(3, 4),
//            MyData(3, 6),
//            MyData(4, 3),
//            MyData(6, 7),
//            MyData(6, 8),
//            MyData(7, 3),
//            MyData(8, 6),
//            MyData(8, 5),
//            MyData(8, 9),
//            MyData(11, 9),
//            MyData(11, 5),
//            MyData(11, 4),
//            MyData(11, 7),
//            MyData(12, 2),
//            MyData(12, 5)
//    )
//    val answerList = arrayListOf(3, 7, 2, 6, 3, 0, 8, 3, 9, 0, 0, 9, 5)

    val sampleData = arrayListOf(
        MyData(1, 3),
        MyData(1, 4),
        MyData(1, 6),
        MyData(1, 7),
        MyData(3, 9),
        MyData(3, 3),
        MyData(3, 7),
        MyData(3, 0)
    )
    val answerList = arrayListOf(0, 7, 0, 9, 0, 0)

    val processedData = EventEntitySet().setAlgorithm(sampleData, answerList.size)
    println("MyData: $processedData")

    val result = ResultChecker.checkAnswer(processedData, answerList)
    println(result)
}

class EventEntitySet {
    fun setAlgorithm(data: ArrayList<MyData>, resultSize: Int): ArrayList<MyData>{
        val hashSet = mutableSetOf<MyData>()
        var cnt = 0
        for(i in data.indices){
            if(data[i].time+1 - cnt > 1){
                for(j in cnt until data[i].time){
                    hashSet.add(MyData(j, 0))
                }
            }
//            println(data[i].toString())
            if(!hashSet.contains(data[i])){
                hashSet.add(data[i])
                cnt = data[i].time
            } else {
                hashSet.removeIf {
                    it.time == data[i].time && it.value < data[i].value
                }
                hashSet.add(data[i])
                cnt = data[i].time
            }
//            println(hashSet.toString())
        }

        if(hashSet.size < resultSize){
            for(i in hashSet.size-1 until resultSize){
                hashSet.add(MyData(i, 0))
            }
        }

        return ArrayList(hashSet)
    }
}