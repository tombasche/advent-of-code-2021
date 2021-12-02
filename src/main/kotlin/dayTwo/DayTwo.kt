package dayTwo

import utils.readFile

typealias Instructions = List<Pair<String, Int>>

fun dayTwo(filename: String, f: (instructions: Instructions) -> Int = ::finalPosition) : Int =
    f(readFile(filename).map { pairFromLine(it) })

fun finalPosition(instructions: Instructions): Int {
    var horizontal = 0
    var depth = 0
    for (instruction in instructions) {
        if (instruction.first == "forward") horizontal += instruction.second
        if (instruction.first == "down") depth += instruction.second
        if (instruction.first == "up") depth -= instruction.second
    }
    return horizontal * depth
}

fun finalPositionWithAim(instructions: Instructions): Int {
    var horizontal = 0
    var depth = 0
    var aim = 0
    for (instruction in instructions) {
        if (instruction.first == "forward") {
            horizontal += instruction.second
            depth += aim * instruction.second
        }
        if (instruction.first == "down") aim += instruction.second
        if (instruction.first == "up") aim -= instruction.second
    }
    return horizontal * depth
}

fun pairFromLine(line: String): Pair<String, Int> =
    Pair(line.substringBefore(' ').trim(), line.substringAfter(' ').trim().toInt())
