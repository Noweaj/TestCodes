package General.nhnAssignment.executorTest

import java.util.concurrent.Callable
import java.util.concurrent.Executors

data class TaskWithIdCnt(
    val id: Int,
    val cnt: Int
)

fun main(){

//    testExecutorService()

//    testThread()

//    println("start")
//    listOf(TaskWithIdCnt(0, 5), TaskWithIdCnt(1, 10)).parallelStream().forEach {
//        for(i in 0 until it.cnt){
//            println("[${it.id}] cnt: $i")
//        }
//    }
//    println("end")

}



class CallableTask: Callable<Int>{
    override fun call(): Int {
        TODO("Not yet implemented")
    }
}

private fun testExecutorService(){
    val executorService = Executors.newFixedThreadPool(2)
    val myTask1 = IncreaseTask_Executor(0, 5)
    val myTask2 = IncreaseTask_Executor(1, 10)
    executorService.submit(myTask1)
    executorService.submit(myTask2)
}

class IncreaseTask_Executor(
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