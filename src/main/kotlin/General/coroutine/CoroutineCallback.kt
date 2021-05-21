package General.coroutine

import kotlinx.coroutines.*

private val gScope = GlobalScope

fun main(){
    val mList = runCoroutineFun()
    println(mList)
}

private fun runCoroutineFun(): List<String>{
    var mList = listOf<String>()
    runBlocking {
        mList = runCoroutine()
    }
    return mList
}

suspend fun runCoroutine(): List<String>{
    var myList = mutableListOf<String>()

    val callback = object: TestCallback{
        override fun onReceive(msg: String) {
            println("onReceive!!!")
            println(msg)
            myList.add(msg)
        }
    }

    gScope.launch(Dispatchers.IO) {
        (0..100).forEach{
            callback.onReceive("message: $it")
            delay(100)
        }
    }

    return myList
}

interface TestCallback{
    fun onReceive(msg: String)
}