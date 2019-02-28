package com.cberry.springsite.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.streams.asStream

class RomanNumeralTest {

    @ParameterizedTest(name = "{index} - Expect [{0}] should return [{1}]")
    @MethodSource("testData")
    fun `Test roman numeral from integer values`(num: Int, expected: String) =
        assertEquals(expected, num.toRomanNumeral())

    companion object {


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
            arrayOf(20, "XX"),
            arrayOf(21, "XXI"),
            arrayOf(22, "XXII"),
            arrayOf(23, "XXIII"),
            arrayOf(24, "XXIV"),
            arrayOf(25, "XXV"),
            arrayOf(26, "XXVI"),
            arrayOf(27, "XXVII"),
            arrayOf(28, "XXVIII"),
            arrayOf(29, "XXIX"),
            arrayOf(30, "XXX"),
            arrayOf(31, "XXXI"),
            arrayOf(32, "XXXII"),
            arrayOf(33, "XXXIII"),
            arrayOf(34, "XXXIV"),
            arrayOf(35, "XXXV"),
            arrayOf(36, "XXXVI"),
            arrayOf(37, "XXXVII"),
            arrayOf(38, "XXXVIII"),
            arrayOf(39, "XXXIX"),
            arrayOf(40, "XL"),
            arrayOf(41, "XLI"),
            arrayOf(42, "XLII"),
            arrayOf(43, "XLIII"),
            arrayOf(44, "XLIV"),
            arrayOf(45, "XLV"),
            arrayOf(46, "XLVI"),
            arrayOf(47, "XLVII"),
            arrayOf(48, "XLVIII"),
            arrayOf(49, "XLIX"),
            arrayOf(50, "L")
        ).asStream()
    }
}


