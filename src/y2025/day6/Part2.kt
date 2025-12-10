package y2025.day6

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val timeMills = measureTimeMillis {
        var res = 0L
        val lines = mutableListOf<String>()
        val operators = mutableListOf<String>()
        File(".\\src\\y2025\\day6\\input.txt").bufferedReader().use { reader ->
            reader.readLines().let {
                lines.addAll(it.subList(0, it.lastIndex))
                operators.addAll(it[it.lastIndex].split("\\s+".toRegex()))
            }
        }
        var n = 0
        operators.forEach { operator ->
            var r = 0L
            while (true) {
                var num = ""
                for (j in lines.indices) {
                    num += lines[j].getOrNull(n)?.takeIf { !it.isWhitespace() } ?: ""
                }
                n++
                if (num == "") break
                when (operator) {
                    "*" -> {
                        if (r == 0L)
                            r += num.toInt()
                        else
                            r *= num.toInt()
                    }

                    "+" -> {
                        r += num.toInt()
                    }
                }

            }
            res += r
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}