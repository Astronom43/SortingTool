package sorting

class Line:SortItem {
    private val rez = mutableListOf<String>()

    init {
        rez.addAll(input())
    }
    override fun printSortNaturally() {
        printList(sort(rez), "lines")
    }

    override fun printSortCount() {
        printCountList(countSort(rez))
    }

    override fun toString(): String {
        var max = ""
        rez.forEach { s -> if (s.length > max.length) max = s }
        val maxCount = rez.count { s -> s == max }
        return """
            Total lines: ${rez.size}.
            The longest line:
            ${max}
            ($maxCount time(s), ${maxCount * 100 / rez.size}%).
        """.trimIndent()
    }
}