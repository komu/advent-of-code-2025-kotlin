fun main() {

    fun eval(op: String, values: List<Long>) = when (op) {
        "+" -> values.sum()
        "*" -> values.product()
        else -> error("Unexpected op: $op")
    }

    fun part1(input: String): Long {
        val lines = input.lines().map { it.trim().split(Regex("""\s+""")) }
        val data = lines.first().indices.map { i ->
            lines.last()[i] to lines.dropLast(1).map { it[i].toLong() }
        }

        return data.sumOf { (op, values) -> eval(op, values) }
    }

    fun part2(input: String): Long {
        val lines = input.lines()
        val transposed = List(lines.maxOf { it.length }) { i ->
            lines.map { it.getOrNull(i) ?: ' ' }.joinToString("").trim()
        }.joinToString("\n")
        val parts = transposed.split("\n\n").map { it.lines() }

        val pattern = Regex("""\s*(\d+)\s*(.)""")
        return parts.sumOf { part ->
            val (num, op) = pattern.matchEntire(part.first())!!.destructured
            eval(op, listOf(num.toLong()) + part.drop(1).map { it.toLong() })
        }
    }

    val testInput = readInput("Day06_test")
    verifySolution(4277556, part1(testInput))
    verifySolution(3263827, part2(testInput))

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()

    verifySolution(3785892992137, part1(input))
    verifySolution(7669802156452, part2(input))
}

