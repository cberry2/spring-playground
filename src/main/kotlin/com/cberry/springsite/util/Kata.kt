package com.cberry.springsite.util

private const val one: String = "I"
private const val four: String = "IV"
private const val five: String = "V"
private const val nine: String = "IX"
private const val ten: String = "X"
private const val forty: String = "XL"
private const val fifty: String = "L"

private val nums =
    mapOf(
        1 to one,
        4 to four,
        5 to five,
        9 to nine,
        10 to ten,
        40 to forty,
        50 to fifty
    ).toSortedMap(Comparator { o1, o2 -> o1.compareTo(o2) * -1 })

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


