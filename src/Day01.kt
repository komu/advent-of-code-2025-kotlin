import java.util.Collections.nCopies
import kotlin.math.absoluteValue
import kotlin.math.sign

fun main() {
    fun List<String>.rots() =
        map { it.replace('L', '-').replace('R', '+').toInt() }

    fun part1(input: List<String>) =
        input.rots()
            .runningFold(50) { dial, rot -> (dial + rot) % 100 }
            .count { it == 0 }

    fun part2(input: List<String>) =
        input.rots()
            .flatMap { nCopies(it.absoluteValue, it.sign) }
            .runningFold(50) { dial, rot -> (dial + rot) % 100 }
            .count { it == 0 }

    val testInput = readInput("Day01_test")
    verifySolution(3, part1(testInput))
    verifySolution(6, part2(testInput))

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()

    verifySolution(1086, part1(input))
    verifySolution(6268, part2(input))
}
