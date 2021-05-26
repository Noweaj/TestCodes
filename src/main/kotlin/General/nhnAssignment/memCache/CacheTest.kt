package General.nhnAssignment.memCache

fun main(){
    val memCache = MemoryCache(16, 0.75f)
    memCache.put("1", "!")

    println(memCache)

}