package y2025.day1

import java.io.File
import kotlin.math.abs
import kotlin.system.measureTimeMillis

fun main() {
    val timeMills = measureTimeMillis {
        var res = 0
        File(".\\src\\y2025\\day1\\input.txt").bufferedReader().use { reader ->
            var current = 50
            reader.forEachLine { line ->
                var num = line.substring(1).toInt()
                var inc = 0
                when (line.first()) {
                    'L' -> {
                        num *= -1
                    }
                }
                current = (current + num).let {
                    inc = abs(it / 100)
                    if (current * it < 0) inc++
                    it % 100
                }
                if (current == 0 && inc == 0) inc = 1
                res += inc
            }
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}