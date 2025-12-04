package y2025.day4

import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val timeMills = measureTimeMillis {
        var res = 0
        var list = emptyList<List<Int>>()
        File(".\\src\\y2025\\day4\\input.txt").bufferedReader().use { reader ->
            reader.readLines().map { it.map { if (it == '@') 1 else 0 }.toList() }.also {
                list = it
            }
        }
        while (true) {
            var temp = 0
            for (r in list.indices) {
                val line = list[r]
                for (n in line.indices) {
                    if (line[n] == 0) continue
                    var count = 0
                    for(rr in -1..1) {
                        for(nn in -1..1) {
                            count += list.getOrNull(r + rr)?.getOrNull(n + nn) ?: 0
                        }
                    }
                    if (count < 5) {
                        temp++
                        list = list.toMutableList().apply {
                            set(
                                r,
                                list[r].toMutableList().apply { set(n, 0) }
                            )
                        }
                    }
                }
            }
            if (temp == 0)
                break
            else
                res += temp
        }
        println("Result is $res")
    }
    println("Running time is $timeMills ms")
}