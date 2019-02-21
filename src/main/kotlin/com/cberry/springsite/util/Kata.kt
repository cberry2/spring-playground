package com.cberry.springsite.util

private const val one: String = "I"
private const val five: String = "V"
private const val ten: String = "X"
private const val fifty: String = "L"

private val nums = mapOf(
        1 to one,
        5 to five,
        10 to ten,
        50 to fifty
    ).toSortedMap(Comparator { o1, o2 -> o1.compareTo(o2) * -1})

fun Int.toRomanNumeral(): String {
    var num = this

    val sb = StringBuilder()
    nums.map { entry ->
        while (num >= entry.key) {
            sb.append(entry.value)
            num -= entry.key
        }
    }

    return sb.toString()
}

internal enum class Numeral private constructor(var weight: Int) {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000)
};

fun roman(n: Int): String {
    var n = n

    if (n <= 0) {
        throw IllegalArgumentException()
    }

    val buf = StringBuilder()

    val values = Numeral.values()
    for (i in values.indices.reversed()) {
        while (n >= values[i].weight) {
            buf.append(values[i])
            n -= values[i].weight
        }
    }
    return buf.toString()
}


