fun main() {

    fun isValid(digits: String, maxParts: Int) =
        (2..maxParts).none { ps -> digits.length % ps == 0 && digits.chunked(digits.length / ps).distinct().size == 1 }

    fun solve(input: String, maxParts: Int) =
        input.split(",").flatMap { parseRange(it) }.filterNot { isValid(it.toString(), maxParts) }.sum()

    fun part1(input: String) = solve(input, maxParts = 2)
    fun part2(input: String) = solve(input, maxParts = 7)

    val testInput = readInput("Day02_test")
    verifySolution(1227775554, part1(testInput))

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()

    verifySolution(52316131093, part1(input))
    verifySolution(69564213293, part2(input))
}
