package y2025.day3

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val timeMills = measureTimeMillis {
        var res = 0
        File(".\\src\\y2025\\day3\\input.txt").bufferedReader().use { reader ->
            reader.forEachLine { line ->
                var max = line.take(2)
                for (n in 2..line.lastIndex) {
                    max = maxOf(
                        max.toInt(),
                        maxOf(
                            (max[0].toString() + line[n].toString()).toInt(),
                            (max[1].toString() + line[n].toString()).toInt()
                        )
                    ).toString()
                }
                res += max.toInt()
            }
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}