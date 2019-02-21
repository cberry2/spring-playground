package com.cberry.springsite.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.streams.asStream

@RunWith(Parameterized::class)
class RomanNumeralTest(val func: (Int) -> String) {

    @ParameterizedTest(name = "{index} - Expect [{0}] should return [{1}]")
    @MethodSource("testData")
    fun `Test roman numeral from integer values`(num: Int, expected: String) =
            assertEquals(expected, func(num))

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<(Int) -> String>> {
            return listOf(
                    arrayOf({num -> roman(num)}),
                    arrayOf({num -> num.toRomanNumeral()})
            )
        }

        @JvmStatic
        private fun testData() = sequenceOf(
                arrayOf(1, "I"),
                arrayOf(2, "II"),
                arrayOf(3, "III"),
                arrayOf(4, "IV"),
                arrayOf(5, "V"),
                arrayOf(6, "VI"),
                arrayOf(7, "VII"),
                arrayOf(8, "VIII"),
                arrayOf(9, "IX"),
                arrayOf(10, "X"),
                arrayOf(11, "XI"),
                arrayOf(12, "XII"),
                arrayOf(13, "XIII"),
                arrayOf(14, "XIV"),
                arrayOf(15, "XV"),
                arrayOf(16, "XVI"),
                arrayOf(17, "XVII"),
                arrayOf(18, "XVIII"),
                arrayOf(19, "XIX"),
                arrayOf(20, "XX")
        ).asStream()
    }
}


