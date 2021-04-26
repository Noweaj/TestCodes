package General.graph

class Polynomial(
    private val terms: DoubleArray
) {
    fun toArray(): DoubleArray? {
        return terms
    }

    fun evaluate(x: Double): Double {
        var result: Double = terms.get(terms.size - 1)
        for (i in terms.size - 2 downTo 0) {
            result = result * x + terms.get(i)
        }
        return result
    }
}