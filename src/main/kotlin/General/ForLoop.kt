package General

fun main(){
//    for(i in 0 until 5){
//
//        if(i == 1)
//            continue
//        println(i)
//    }

    val maxSize = 52
    for(i in 0 until maxSize step 3){
        println("current i: $i")
        if(i == maxSize-1){
            println("i: $i this is max")
        }
        if(i+1 > maxSize-1){
            println("i+1: ${i+1} out of bound!")
        }else {
            println("i+1: ${i + 1}")
        }
        if(i+2 > maxSize-1) {
            println("i+2: ${i+2} out of bound!")
        } else {
            println("i+2: ${i + 2}")
        }
    }
}