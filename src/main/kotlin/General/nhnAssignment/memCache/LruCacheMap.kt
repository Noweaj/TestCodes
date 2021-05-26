package General.nhnAssignment.memCache

class LruCacheMap<K, V>(
    initSize: Int,
    loadFactor: Float
): LinkedHashMap<K, V>(initSize, loadFactor, true) {
}