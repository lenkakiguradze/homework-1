import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val point1 = Point(5.0,10.0)
    val point2 = Point(-5.0,-10.0)
    println(point1)
    println(point2)
    println(point1 == point2)
    println(point1.distance(point2))
    point1.moveAgainstCenter()
    println(point1)
    println(point1 == point2)

    val fraction1 = Fraction(3.0,4.0)
    val fraction2 = Fraction(5.0,2.0)
    println(fraction1)
    println(fraction2)
    fraction1.add(fraction2)
    println(fraction1)
    fraction1.multiply(fraction2)
    println(fraction1)
}

class Point(private var x: Double, private var y: Double) {
    override fun toString(): String {
        return "($x; $y)"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            return x == other.x && y == other.y
        } else {
            return false
        }
    }

    fun moveAgainstCenter() {
        x *= -1
        y *= -1
    }

    fun distance(other: Point): Double {
        val distanceX = x - other.x
        val distanceY = y - other.y
        return sqrt(distanceX.pow(2) + distanceY.pow(2))
    }
}

class Fraction(private var nominator: Double, private var denominator: Double) {
    override fun toString(): String {
        return "$nominator; $denominator"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Fraction) {
            return nominator * other.denominator == denominator * other.nominator
        }
        return false
    }

    fun add(other: Fraction) {
       	nominator = nominator * other.denominator + denominator * other.nominator
        denominator *= other.denominator
    }

    fun multiply(other: Fraction) {
        nominator *= other.nominator
        denominator *= other.denominator
    }
}