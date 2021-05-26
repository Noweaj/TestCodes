package General.nhnAssignment

import General.nhnAssignment.executor.HttpExecutorService
import General.nhnAssignment.http.HttpHelper
import General.nhnAssignment.http.HttpRequest
import kotlinx.coroutines.*
import java.lang.Runnable

var gResponse: String = "READY"

fun main(){

    val listener = Runnable {
        var i = 0
        while(gResponse == "READY"){
            println("$i : $gResponse")
            i++
            Thread.sleep(100)
        }
        println("gResponse received!")
    }
    val service = HttpExecutorService().getExecutorService()
    service.submit(listener)

    val httpHelper = HttpHelper()
    httpHelper.executeHttpRequest(
            req = HttpRequest(
                    method = "GET",
//                    url = "https://en.wikipedia.org/api/rest_v1/page/summary/Gmail",
//                    url = "https://www.naver.com",
                    url = "http://127.0.0.1:3001/simpleget",
                    header = null,
                    body = "",
                    connectTimeout = 1000
            ),
            callback = object: HttpHelper.HttpCallback{
                override fun onSuccess(response: String) {

                    gResponse = response
                }

                override fun onFailure(errorMsg: String) {
                    gResponse = errorMsg
                }
            }
    )

    println("HttpHelper executed")
//    println("RESULT: $result")
    println("callback: $gResponse")



//    runBlocking {
//        listen()
//    }
}

suspend fun listen(){
    val job = GlobalScope.launch(Dispatchers.Default){
        var i = 0
        while(gResponse == "READY"){
            println("$i : $gResponse")
            i++
            delay(10)
        }
        println(gResponse)
    }
    job.join()
    return
}