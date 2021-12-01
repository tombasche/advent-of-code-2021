package dayOne

import utils.readFile

typealias DayOneFunction = (items: List<Int>) -> Int

fun dayOne(filename: String, f: DayOneFunction = ::findIncreases): Int = f(readFile(filename).map { it.toInt() })


fun findIncreases(items: List<Int>): Int  {
    var counter = 0
    for (i in 0 until items.size - 1) {
        if (isIncreasing(items[i], items[i+1]))
            counter ++
    }
    return counter
}

fun findSlidingWindowIncreases(items: List<Int>): Int {
    var counter = 0
    for (i in 0 until items.size - 3) {
        if (slidingWindow(items, i) < slidingWindow(items, i+1))
            counter ++
    }
    return counter
}

fun isIncreasing(item: Int, nextItem: Int): Boolean = item < nextItem
fun slidingWindow(items: List<Int>, i: Int): Int = items[i] + items[i+1] + items[i+2]