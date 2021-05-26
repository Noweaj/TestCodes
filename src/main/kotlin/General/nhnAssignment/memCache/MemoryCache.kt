package General.nhnAssignment.memCache

class MemoryCache(
    initSize: Int,
    loadFactor: Float
): BaseCache(initSize, loadFactor)
{
    override fun get(key: String): String? {
        return super.get(key)
    }

    override fun put(key: String, value: String): Boolean {
        return super.put(key, value)
    }

    override fun clear(){

    }

    override fun toString() = super.toString()

}