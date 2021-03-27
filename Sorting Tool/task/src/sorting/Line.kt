package sorting

class Line(var inputFile:String = "",  var outputFile :String= ""):SortItem {
    private val rez = mutableListOf<String>()

    init {
        rez.addAll(input(inputFile))
    }
    override fun printSortNaturally() {
        printList(sort(rez), "lines", outputFile = outputFile)
    }

    override fun printSortCount() {
        printCountList(countSort(rez),outputFile)
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