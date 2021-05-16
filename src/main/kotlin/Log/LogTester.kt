package Log

fun main(){
    Log.d("main", "printing test msg 1")

    val lt2 = LogTester2()

    lt2.runTest2()

    Log.setVisibility(true)

    Log.d("main", "printing test msg 2")

    lt2.runTest2()

    Log.d("main", "println test msg 3")

    Log.setVisibility(false)

    lt2.runTest2()

    Log.d("main", "println test msg 4")
}