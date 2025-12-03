fun main() {

    fun maximumJoltage(batteries: List<Int>, count: Int) = buildString {
        var remaining = batteries
        repeat(count) { i ->
            val (index, value) = remaining.dropLast(count - i - 1).withIndex().maxBy { it.value }
            append(value)
            remaining = remaining.drop(index + 1)
        }
    }.toLong()

    fun solve(input: String, count: Int) =
        input.lines().sumOf { maximumJoltage(it.digits(), count) }

    fun part1(input: String) = solve(input, 2)
    fun part2(input: String) = solve(input, 12)

    val testInput = readInput("Day03_test")
    verifySolution(357, part1(testInput))
    verifySolution(3121910778619, part2(testInput))

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()

    verifySolution(17452, part1(input))
    verifySolution(173300819005913, part2(input))
}

