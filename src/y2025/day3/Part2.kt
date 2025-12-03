package y2025.day3

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val timeMills = measureTimeMillis {
        var res = 0L
        File(".\\src\\y2025\\day3\\input.txt").bufferedReader().use { reader ->
            reader.forEachLine { line ->
                var max = line.take(12)
                for (n in 12..line.lastIndex) {
                    val temp = max
                    for(i in max.indices) {
                        max = maxOf(
                            max.toLong(),
                            (temp.removeRange(i, i + 1) + line[n].toString()).toLong()
                        ).toString()
                    }
                }
                res += max.toLong()
            }
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}