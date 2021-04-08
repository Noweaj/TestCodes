package General

fun main(){
    val ref = 24*3600000L
    val data1 = 1617519337525
    val data2 = 1617605737525
    println(ref)
    println(data2-data1)


    println(data2-data1>ref)

    println((data2-data1)/ref)
}