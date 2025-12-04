package y2025.day4

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    fun Char.isPaperRoll() = if (this == '@') 1 else 0

    val timeMills = measureTimeMillis {
        var res = 0
        File(".\\src\\y2025\\day4\\input.txt").bufferedReader().use { reader ->
            val lines = reader.readLines()

            for (r in lines.indices) {
                val line = lines[r]
                for (n in line.indices) {
                    when (line[n]) {
                        '.' -> continue
                        '@' -> {
                            var count = 0
                            for(rr in -1..1) {
                                for(nn in -1..1) {
                                    count += lines.getOrNull(r + rr)?.getOrNull(n + nn)?.isPaperRoll() ?: 0
                                }
                            }
                            if (count < 5) res++
                        }
                    }
                }
            }
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}