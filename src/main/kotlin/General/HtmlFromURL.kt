package General

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

fun main(){
    val googleUrl = URL("https://google.com")
    var inputLine = googleUrl.openStream().bufferedReader().use(BufferedReader::readText)
    println(inputLine)
}