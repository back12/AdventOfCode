package y2025.day2

import java.io.File
import kotlin.math.log10
import kotlin.system.measureTimeMillis

fun main() {
    solution2()
}

private fun solution1() {
    val timeMills = measureTimeMillis {
        var res = 0L
        File(".\\src\\y2025\\day2\\input.txt").bufferedReader().use { reader ->
            val range = reader.readLine().split(",")
            val pattern = "(\\d+)\\1".toRegex()
            range.map { it.split("-") }.forEach {
                val start = it[0].toLong()
                val end = it[1].toLong()
                for (i in start..end) {
                    if(i.toString().length % 2 == 1) continue
                    if(i.toString().matches(pattern)) {
                        res += i
                    }
                }
            }
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}

private fun solution2() {
    val timeMills = measureTimeMillis {
        var res = 0L
        File(".\\src\\y2025\\day2\\input.txt").bufferedReader().use { reader ->
            val range = reader.readLine().split(",")
            range.map { it.split("-") }.forEach {
                val start = it[0].toLong()
                val end = it[1].toLong()
                for (i in start..end) {
                    val length = i.toString().length
                    if(length % 2 == 1) continue
                    val n = length / 2
                    if(i.toString().substring(0, n) == i.toString().substring(n)) {
                        res += i
                    }
                }
            }
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}