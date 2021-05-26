package General.nhnAssignment.memCache

abstract class BaseCache(
    private val initSize: Int,
    private val loadFactor: Float
) {
    private val cache = LruCacheMap<String, String>(initSize, loadFactor)

    open fun get(key: String): String? {
        return cache[key]
    }

    open fun put(key: String, value: String): Boolean {
        cache.put(key, value)
        return true
    }

    open fun clear() {
        cache.clear()
    }

    override fun toString() = cache.toString()
}