fun main() {

    fun parse(s: String): Pair<List<ClosedRange<Long>>, List<Long>> {
        val (s1, s2) = s.split("\n\n")

        return Pair(
            s1.lines().map { parseRange(it) },
            s2.lines().map { it.toLong() }
        )
    }

    fun Iterable<ClosedRange<Long>>.merge(): List<ClosedRange<Long>> {
        val result = mutableListOf<ClosedRange<Long>>()

        for (range in this.sortedBy { it.start }) {
            val preceding = result.lastOrNull()

            if (preceding != null && preceding.endInclusive >= range.start)
                result[result.lastIndex] = preceding.start..maxOf(preceding.endInclusive, range.endInclusive)
            else
                result += range
        }

        return result
    }

    fun part1(input: String): Int {
        val (fresh, available) = parse(input)
        return available.count { a -> fresh.any { a in it } }
    }

    fun part2(input: String): Long =
        parse(input).first.merge().sumOf { it.size }

    val testInput = readInput("Day05_test")
    verifySolution(3, part1(testInput))
    verifySolution(14, part2(testInput))

    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()

    verifySolution(511, part1(input))
    verifySolution(350939902751909, part2(input))
}

