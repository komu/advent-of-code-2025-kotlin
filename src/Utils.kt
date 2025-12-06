import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.system.exitProcess

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

fun <T> verifySolution(expected: T, actual: T) {
    if (expected != actual) {
        System.err.println("Expected: $expected, Actual: $actual")
        Thread.dumpStack()
        exitProcess(0)
    }
}

fun String.digits() = map { it.digitToInt() }

fun parseRange(s: String) =
    s.split("-").map { it.toLong() }.let { (min, max) -> min..max }

val ClosedRange<Long>.size: Long
    get() = endInclusive - start + 1

fun Iterable<Long>.product() = fold(1L) { acc, i -> acc * i }
