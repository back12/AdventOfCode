package y2025.day5

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val timeMills = measureTimeMillis {
        var res = 0
        var dataReached = false
        val range = mutableListOf<Pair<Long, Long>>()
        File(".\\src\\y2025\\day5\\input.txt").bufferedReader().use { reader ->
            reader.forEachLine { line ->
                if (line.isEmpty()) {
                    dataReached = true
                    return@forEachLine
                }
                if (!dataReached) {
                    range.add(line.substringBefore('-').toLong() to line.substringAfter('-').toLong())
                    return@forEachLine
                }
                val num = line.toLong()
                for((start, end) in range) {
                    if(num in start..end) {
                        res++
                        break
                    }
                }
            }
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}