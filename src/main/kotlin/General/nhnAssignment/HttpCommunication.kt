package General.nhnAssignment

import General.nhnAssignment.http.HttpHelper
import General.nhnAssignment.http.HttpRequest
import kotlinx.coroutines.*

var gResponse: String = "READY"

fun main(){

    val httpHelper = HttpHelper()
    httpHelper.executeHttpRequest(
            req = HttpRequest(
                    method = "GET",
                    url = "https://en.wikipedia.org/api/rest_v1/page/summary/Gmail",
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


runBlocking {
    listen()
}


}

suspend fun listen(){
    val job = GlobalScope.launch(Dispatchers.Default){
        var i = 0
        while(gResponse == "READY"){
            println("$i : $gResponse")
            i++
            delay(100)
        }
        println(gResponse)
    }
    job.join()
    return
}