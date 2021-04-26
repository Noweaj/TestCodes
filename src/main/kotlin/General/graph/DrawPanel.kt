package General

import General.graph.Graph
import General.graph.Lagrange
import General.graph.Polynomial
import General.graph.Spline
import java.awt.Color

import javax.swing.JFrame

import java.util.Arrays


val SLEEP = 1L

fun main(){

//    val values = doubleArrayOf(
//        +100.0,
//        +98.0,
//        +94.0,
//        +84.0,
//        +63.0,
//        +48.0,
//        +31.0,
//        +16.0,
//        +0.0
//    ) // y values

    val values = doubleArrayOf(
        180.0,
        140.0,
        120.0,
        110.0
    )


    val v = Arrays.copyOf(values, values.size)
    Arrays.sort(v)

    val deltaX = 0.1 // precision


    val frame = JFrame("Fit Curves to Points")
    val graph: Graph = Graph()
    graph.Graph(
        -1.0,
        v.size.toDouble(),
        v[0] - 1,
        v[v.size - 1] + 1,
        1000,
        500
    )// parameters are x_min, x_max, y_min, y_max, ??, ?? - for drawing axes or size of frame?

    frame.contentPane.add(graph)
    frame.pack()
    frame.isVisible = true
    sleep(500)

    // Plot points.

    // Plot points.
    graph.PEN_WIDTH = 10 //some kind of jframe size var for draw oval...

    graph.PEN_COLOR = Color.black //some kind of jframe color var

    for (x in values.indices) {
        graph.point(x.toDouble(), values[x])
    } // essentially a draw oval call to plot each point


    // Plot Lagrange interpolation polynomial.

    // Plot Lagrange interpolation polynomial.
    graph.PEN_WIDTH = 3
    graph.PEN_COLOR = Color.red
    val lagrange: Polynomial = Lagrange.interpolate(values)
    println(Arrays.toString(lagrange.toArray()))
    var x = 0.0
    while (x < values.size - 1) {
        graph.point(x, lagrange.evaluate(x))
        sleep(SLEEP)
        x += deltaX
    }

    // Plot cubic spline.

    // Plot cubic spline.
//    graph.PEN_WIDTH = 3
//    graph.PEN_COLOR = Color.blue
//    val spline = Spline(values)
//    x = 0.0
//    while (x < values.size - 1) {
//        graph.point(x, spline.evaluate(x))
//        sleep(SLEEP)
//        x += deltaX
//    }
}

private fun sleep(milliseconds: Long){

    val thread = Thread()
    try {
        Thread.sleep(milliseconds)
    } catch (e: Exception) {
    }
}