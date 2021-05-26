package General.nhnAssignment.memCache

interface Cache {
    fun get(key: String): String?
    fun put(key: String, value: String): Boolean
    fun clear()
}