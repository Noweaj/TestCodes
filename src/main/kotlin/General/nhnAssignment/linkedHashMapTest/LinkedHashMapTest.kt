package General.nhnAssignment.linkedHashMapTest

fun main(){
    val map = LruMap<String, Int>(3)

    map.put("1", 1)
    map.put("2", 2)
    map.put("3", 3)

    println(map)

    map.put("4", 4)

    println(map)

    map.put("5", 5)

    println(map)

    map.get("4")
    println(map)
    map.get("3")
    println(map)
    map.get("4")
    println(map)
    map.get("1")
    println(map)

    val iter = map.entries.iterator()
    while(iter.hasNext()){
        println(iter.next())
    }
}

class LruMap<T, V> (
    private val initialSize: Int
): LinkedHashMap<T, V>(initialSize, 0.75f, true) {

    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<T, V>?): Boolean {
        super.removeEldestEntry(eldest)
        return super.size > initialSize
    }
}