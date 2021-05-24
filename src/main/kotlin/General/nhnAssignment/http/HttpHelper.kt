package General.nhnAssignment.http

import java.io.BufferedReader
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class HttpHelper {

    interface HttpCallback{
        fun onSuccess(response: String)
        fun onFailure(errorMsg: String)
    }

    fun executeHttpRequest(req: HttpRequest, callback: HttpCallback){
        println("executeHttpRequest")
        val runnable = Runnable {
            try{
                val conn = URL(req.url).openConnection() as HttpURLConnection

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
                    callback.onSuccess(inputStream.bufferedReader().use(BufferedReader::readText))
                } else {
                    println(code)
                    val errorStream = conn.errorStream
                    callback.onFailure(errorStream.bufferedReader().use(BufferedReader::readText))
                }

            } catch (e: Exception){
                callback.onFailure(e.localizedMessage)
            }
        }
        runnable.run()
        println("executeHttpRequest done")
    }

    private fun doConnect(){
    }
}