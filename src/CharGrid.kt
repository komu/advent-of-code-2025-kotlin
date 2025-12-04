class CharGrid(input: String) {

    val grid = input.lines().map { it.toCharArray() }
    val yRange = grid.indices
    val xRange = grid[0].indices
    val points = xRange.flatMap { x -> yRange.map { y -> Point(x, y) } }.toSet()

    operator fun contains(p: Point) = p.x in xRange && p.y in yRange

    operator fun get(p: Point) =
        grid[p.y][p.x]

    operator fun set(p: Point, c: Char) {
        grid[p.y][p.x] = c
    }

    fun getOrNull(p: Point) =
        grid.getOrNull(p.y)?.getOrNull(p.x)
}
