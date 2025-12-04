fun main() {

    fun CharGrid.hasRoll(p: Point) = getOrNull(p) == '@'
    fun CharGrid.isRemovable(p: Point) = hasRoll(p) && p.neighbors.count { hasRoll(it) } < 4

    fun part1(input: String): Int {
        val grid = CharGrid(input)
        return grid.points.count { grid.isRemovable(it) }
    }

    fun part2(input: String): Int {
        val grid = CharGrid(input)

        var removals = 0

        do {
            var modified = false
            for (p in grid.points) {
                if (grid.isRemovable(p)) {
                    grid[p] = '.'
                    modified = true
                    removals++
                }
            }
        } while (modified)

        return removals
    }

    val testInput = readInput("Day04_test")
    verifySolution(13, part1(testInput))
    verifySolution(43, part2(testInput))

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()

    verifySolution(1540, part1(input))
    verifySolution(8972, part2(input))
}

