package General

fun main(){
//    val ref = 24*3600000L
//    val data1 = 1617519337525
//    val data2 = 1617605737525
//    println(ref)
//    println(data2-data1)
//
//
//    println(data2-data1>ref)
//
//    println((data2-data1)/ref)

//    val mString = "https://api.dev.eversafe.co.kr"
//    val protocol = mString.split("://")[0]
//    println(protocol=="https")

    val string: String? = "jjj"

    string?.let {
        println("not null")
    }?: println("null")

    val testclass = testClass("asdf")
    println(testclass.hashCode())
}

data class testClass(
    val test: String
){
    override fun hashCode(): Int {
        return super.hashCode()
    }
}