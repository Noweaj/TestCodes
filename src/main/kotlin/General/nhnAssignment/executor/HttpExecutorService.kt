package General.nhnAssignment.executor

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class HttpExecutorService {
    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)

    fun getExecutorService(): ExecutorService{
        return executorService
    }

    fun <T> submit(callable: Callable<T>){

    }
}