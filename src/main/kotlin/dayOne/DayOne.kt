package dayOne

import utils.readFile

typealias DayOneFunction = (items: List<Int>) -> Int

fun dayOne(filename: String, f: DayOneFunction = ::findIncreases): Int = f(readFile(filename).map { it.toInt() })

fun findIncreases(items: List<Int>): Int = (0 until items.size - 1).foldIndexed(initial = 0) { i, acc, _ ->
    acc + if (isIncreasing(items[i], items[i + 1])) 1 else 0
}

fun findSlidingWindowIncreases(items: List<Int>): Int = (0 until items.size - 3).foldIndexed(initial = 0) { i, acc, _ ->
    acc + if (slidingWindow(items, i) < slidingWindow(items, i + 1)) 1 else 0
}

private fun isIncreasing(item: Int, nextItem: Int): Boolean = item < nextItem
private fun slidingWindow(items: List<Int>, i: Int): Int = items[i] + items[i + 1] + items[i + 2]
