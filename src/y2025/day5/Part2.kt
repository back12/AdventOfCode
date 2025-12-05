package y2025.day5

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val timeMills = measureTimeMillis {
        var res = 0L
        val range = mutableMapOf<Long, Long>()
        File(".\\src\\y2025\\day5\\input.txt").bufferedReader().use { reader ->
            var line = reader.readLine()
            while (line.isNotEmpty()) {
                var start = line.substringBefore('-').toLong()
                var end = line.substringAfter('-').toLong()
                var contained = false

                val keys = range.keys.toList()
                for (key in keys) {
                    if (key in (start + 1)..end) {
                        end = maxOf(end, range[key]!!)
                        range.remove(key)
                        continue
                    }
                    if (start in key..range[key]!! && end > range[key]!!) {
                        start = key
                    }
                    if (start >= key && end <= range[key]!!) {
                        contained = true
                        break
                    }
                }
                if (!contained) {
                    range[start] = end
                }

                line = reader.readLine()
            }
        }
        range.forEach { (key, value) ->
            res += value - key + 1
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}