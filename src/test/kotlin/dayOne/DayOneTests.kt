package dayOne

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DayOneTests : FunSpec({

    val items = listOf(199, 200, 208, 210, 100, 207, 240, 269, 260, 263)

    test("Part One - Read the file and output the result") {
        val fileName = "/Users/thomasbasche/IdeaProjects/AoC21/src/main/kotlin/dayOne/puzzle.txt"
        val result = dayOne(fileName)
        println(result)
    }

    test("Part Two - Read the file and output the result") {
        val fileName = "/Users/thomasbasche/IdeaProjects/AoC21/src/main/kotlin/dayOne/puzzle.txt"
        val result = dayOne(fileName, ::findSlidingWindowIncreases)
        println("Part two " + result)
    }

    test("it identifies there are increases in the list of values") {
        findIncreases(items) shouldBe 7
    }

    test("it identifies increases using a sliding window") {
        findSlidingWindowIncreases(items) shouldBe 5
    }
})
