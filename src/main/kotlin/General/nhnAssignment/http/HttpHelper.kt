package General.nhnAssignment.http

import java.io.BufferedReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.*
import javax.net.ssl.HttpsURLConnection

class HttpHelper {

    interface HttpCallback{
        fun onSuccess(response: String)
        fun onFailure(errorMsg: String)
    }

    fun executeHttpRequest(req: HttpRequest, callback: HttpCallback): String{
        println("executeHttpRequest")

        val callable = Callable<String> {
            println("Callable: ${System.currentTimeMillis()}")
            try{
//                val conn = getUrlConnection(req.url)
                val conn = URL(req.url).openConnection() as HttpURLConnection
                (conn as HttpsURLConnection).setHostnameVerifier{ _, _ ->
                    true
                }

                conn.connectTimeout = req.connectTimeout
                conn.readTimeout = 1000
                conn.useCaches = false
                conn.doOutput = false

                conn.requestMethod = req.method
                req.header?.forEach {
                    conn.setRequestProperty(it.key, it.value)
                }

                conn.connect()

                val code = conn.responseCode
                println(code)
                if(code == HttpURLConnection.HTTP_OK){
                    val inputStream = conn.inputStream
                    val result = inputStream.bufferedReader().use(BufferedReader::readText)
                    callback.onSuccess(result)
                    result
                } else {
                    val errorStream = conn.errorStream
                    val result = errorStream.bufferedReader().use(BufferedReader::readText)
                    callback.onFailure(result)
                    result
                }

            } catch (e: Exception){
                e.printStackTrace()
                println("Exception: ${System.currentTimeMillis()}")
                callback.onFailure(e.localizedMessage)
                e.localizedMessage
            }
        }

//        val service = HttpExecutorService().getExecutorService()
//        val future = service.submit(callable)
//
//        val result = future.get()
//
//        service.shutdown()
//        return result



        var runnableResult = ""

        val runnable = Runnable {
            println("Runnable")
            try{
//                val conn = getUrlConnection(req.url)
                val conn = URL(req.url).openConnection() as HttpURLConnection// as HttpsURLConnection

//                conn.setHostnameVerifier { hostname, session ->
//                    true
//                }

                conn.connectTimeout = req.connectTimeout
                conn.readTimeout = 1000
                conn.useCaches = false
                conn.doOutput = false

                conn.requestMethod = req.method
                req.header?.forEach {
                    conn.setRequestProperty(it.key, it.value)
                }

                conn.connect()

                val code = conn.responseCode
                if(code == HttpURLConnection.HTTP_OK){
                    println("200")
                    val inputStream = conn.inputStream
                    runnableResult = inputStream.bufferedReader().use(BufferedReader::readText)
                    callback.onSuccess(runnableResult)
                } else {
                    println(code)
                    val errorStream = conn.errorStream
                    runnableResult = errorStream.bufferedReader().use(BufferedReader::readText)
                    callback.onFailure(runnableResult)
                }

            } catch (e: Exception){
                callback.onFailure(e.localizedMessage)
            }
        }
        runnable.run()
        println("executeHttpRequest done")
        return runnableResult
    }


    private fun doConnect(){
    }
}