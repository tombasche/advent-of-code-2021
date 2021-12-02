package dayTwo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DayTwoTests : FunSpec({

    test("Part One - Read the file and output the result") {
        val fileName = "/Users/thomasbasche/IdeaProjects/AoC21/src/main/kotlin/dayTwo/puzzle.txt"
        val result = dayTwo(fileName)
        result shouldBe 2039912
    }

    test("Part Two - Read the file and output the result with aim calculation") {
        val fileName = "/Users/thomasbasche/IdeaProjects/AoC21/src/main/kotlin/dayTwo/puzzle.txt"
        val result = dayTwo(fileName, ::finalPositionWithAim)
        result shouldBe 1942068080
    }

    test("it gets final horizontal position and depth") {
        val instructions = listOf(
            Pair("forward", 5),
            Pair("down", 5),
            Pair("forward", 8),
            Pair("up", 3),
            Pair("down", 8),
            Pair("forward", 2),
        )
        val expected = 150
        val result = finalPosition(instructions)
        result shouldBe expected
    }

    test("it gets position with aim calculation") {
        val instructions = listOf(
            Pair("forward", 5),
            Pair("down", 5),
            Pair("forward", 8),
            Pair("up", 3),
            Pair("down", 8),
            Pair("forward", 2),
        )
        val expected = 900
        val result = finalPositionWithAim(instructions)
        result shouldBe expected
    }
})