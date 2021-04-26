package General.graph

object Lagrange {
    fun interpolate(values: DoubleArray): Polynomial {
        val Px = DoubleArray(values.size) // Lagrange polynomial (LP)
        val binomial = DoubleArray(2) // temporarily holds binomials for multiplication
        for (x in values.indices) {

            //calc Pi(x)
            var Pix = DoubleArray(values.size) // Pi terms of LP, which are summed to get LP
            val accumulator = DoubleArray(values.size) // initialize to one?
            Pix[0] = values[x] // initialize Pix to Yi

            // multiply binomials
            for (k in values.indices) {
                // skip if k==x
                if (k == x) continue

                //create binomial (i.e. x+3)
                binomial[1] = 1.toDouble() / (x - k) // x term
                binomial[0] = (-k).toDouble() / (x - k) // constant term

                //multiply accumulator by binomial
                Pix = biMult(Pix, binomial)
            }

            // Add Pi(x) to terms
            for (j in values.indices) {
                Px[j] = Px[j] + Pix[j]
            }
        }
        return Polynomial(Px)
    }

    fun biMult(polynomial: DoubleArray, binomial: DoubleArray): DoubleArray {
        val accumulator = DoubleArray(polynomial.size)
        for (i in polynomial.indices) {
            val a = polynomial[i] * binomial[0]
            var b: Double
            b = if (i - 1 < 0) 0.0 else polynomial[i - 1] * binomial[1]
            accumulator[i] = a + b
        }
        return accumulator
    }
}