package y2025.day6

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val timeMills = measureTimeMillis {
        var res = 0L
        val nums = mutableListOf<List<Int>>()
        val operators = mutableListOf<String>()
        File(".\\src\\y2025\\day6\\input.txt").bufferedReader().use { reader ->
            reader.forEachLine { line ->
                try {
                    nums.add(line.split("\\s+".toRegex()).map { it.toInt() })
                } catch (_: NumberFormatException) {
                    operators.addAll(line.split("\\s+".toRegex()))
                }
            }
        }
        for (i in operators.indices) {
            var r = nums[0][i].toLong()
            when(operators[i]) {
                "*" -> {
                    for(n in 1..nums.lastIndex) {
                        r *= nums[n][i]
                    }
                }
                "+" -> {
                    for(n in 1..nums.lastIndex) {
                        r += nums[n][i]
                    }
                }
            }
            res += r
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}