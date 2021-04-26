package General.graph

import java.awt.Color

import java.awt.Graphics

import java.awt.Dimension

import java.util.ArrayList
import javax.swing.JPanel


class Graph: JPanel() {

    var PEN_WIDTH = 10
    var PEN_COLOR = Color.black

    private val points = ArrayList<Point>()

    private var xmin = 0.0
    private var xmax: kotlin.Double = 0.0
    private var ymin: kotlin.Double = 0.0
    private var ymax: kotlin.Double = 0.0
    private var xrange: kotlin.Double = 0.0
    private var yrange: kotlin.Double = 0.0
    private var xscale: kotlin.Double = 0.0
    private var yscale: kotlin.Double = 0.0
    private var _width = 0
    private var _height: Int = 0
    private val oval_x = 0
    private var oval_y: Int = 0

    fun Graph(x_min: Double, x_max: Double, y_min: Double, y_max: Double, w: Int, h: Int) {
        xmin = x_min
        xmax = x_max
        ymin = y_min
        ymax = y_max
        _width = w
        _height = h
        xrange = x_max - x_min
        yrange = y_max - y_min
        xscale = _width / xrange
        yscale = _height / yrange
        setPreferredSize(Dimension(w, h))
    }

    fun point(x: Double, y: Double) {
        // adds new point to point array
        val point = Point(xtrans(x), ytrans(y), PEN_COLOR, PEN_WIDTH)
        points.add(point)
        repaint()
    }

    override fun paintComponent(g: Graphics) {

        // draw background
        super.paintComponent(g)
        g.color = Color.white
        g.fillRect(0, 0, _width, _height)

        // draw axes
        g.color = Color.black
        g.drawLine(xtrans(xmin), ytrans(0.0), xtrans(xmax), ytrans(0.0))
        g.drawLine(xtrans(0.0), ytrans(ymin), xtrans(0.0), ytrans(ymax))

        // draw all points
        for (i in points.indices) {
            g.color = points[i].color
            val x = points[i].getx()
            val y = points[i].gety()
            val pointSize: Int = points[i].size
            g.fillOval(x, y, pointSize, pointSize)
        }
    }

    private fun xtrans(x: Double): Int {
        return (xscale(Math.abs(xmin)) + xscale(x)).toInt()
    }

    private fun ytrans(y: Double): Int {
        return (yscale(ymax) - yscale(y)).toInt()
    }

    private fun yscale(y: Double): Double {
        return y * yscale
    }

    private fun xscale(x: Double): Double {
        return x * xscale
    }

    class Point(
        private val x: Int,
        private val y: Int,
        val color: Color,
        val size: Int
    ) {

        fun getx(): Int {
            return x
        }

        fun gety(): Int {
            return y
        }

    }
}