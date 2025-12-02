package y2025.day2

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val timeMills = measureTimeMillis {
        var res = 0L
        File(".\\src\\y2025\\day2\\input.txt").bufferedReader().use { reader ->
            val range = reader.readLine().split(",")
            val pattern = "(\\d+)\\1+".toRegex()
            range.map { it.split("-") }.forEach {
                val start = it[0].toLong()
                val end = it[1].toLong()
                for (i in start..end) {
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