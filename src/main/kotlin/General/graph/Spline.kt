package General.graph

class Spline(
    private val values: DoubleArray
) {

    fun evaluate(x: Double): Double {
        val x0 = x.toInt()
        val x1 = x0 + 1
        val y0 = values[x0]
        val y1 = values[x1]
        val s0: Double
        val s1: Double
        if (x0 == 0) {
            s0 = midSlope(-y1, y0, y1)
            s1 = if (x1 == values.size - 1) midSlope(y0, y1, -y0) else midSlope(y0, y1, values[x1 + 1])
        } else {
            s0 = midSlope(values[x0 - 1], y0, y1)
            s1 = if (x1 == values.size - 1) midSlope(y0, y1, -y0) else midSlope(y0, y1, values[x1 + 1])
        }
        return cubic(y0, y1, s0, s1, x - x0)
    }

    private fun cubic(
        y0: Double,
        y1: Double,
        s0: Double,
        s1: Double,
        x: Double
    ): Double {
        val c = 3 * (y1 - y0) - 2 * s0 - s1
        val d = 2 * (y0 - y1) + s0 + s1
        val terms = doubleArrayOf(y0, s0, c, d)
        val spline = Polynomial(terms)
        return spline.evaluate(x)
    }

    private fun midSlope(y1: Double, y2: Double, y3: Double): Double {
        val A = (y3 + y1 - 2 * y2) / 2
        val B = y2 - y1 - A
        return 2 * A + B
    }
}