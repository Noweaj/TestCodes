package General.nhnAssignment.executorTest

fun main(){
    sequentialThreadJoinTest()
}

private fun sequentialThreadJoinTest(){
    println("sequentialThreadJoinTest start")
    Thread(SequentialJoinThread()).start()
    println("sequentialThreadJoinTest end")
}

class SequentialJoinThread: Runnable {
    override fun run() {
        println("SequentialJoinThread start")

        // run another thread
        val parallelTask = IncreaseTask_Thread(1, 10)
        val threadParallelTask = Thread(parallelTask)
        threadParallelTask.start()

        val parallelTask2 = IncreaseTask_Thread(2, 15)
        val threadParallelTask2 = Thread(parallelTask2)
        threadParallelTask2.start()

        increaseUpToCnt(0, 20)

        // wait until parallel task is done if not finished yet
        threadParallelTask.join()
        threadParallelTask2.join()

        println("SequentialJoinThread end")
    }
}

class IncreaseTask_Thread(
    private val id: Int,
    private val cnt: Int
): Runnable {
    override fun run() {
        increaseUpToCnt(id, cnt)
    }
}

private fun increaseUpToCnt(id: Int, cnt: Int){
    for(i in 0 until cnt)
        println("[$id] cnt: $i")
}