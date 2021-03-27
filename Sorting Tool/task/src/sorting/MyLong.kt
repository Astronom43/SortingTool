package sorting

class MyLong(var inputFile:String = "",  var outputFile :String= "") : SortItem {
    var rez = mutableListOf<Int>()
    init {
        val input = input(inputFile)
        for (s in input) {
            val split = s.split("""\s+""".toRegex())
            for (str in split) {
                try {
                    val i = str.toInt()
                    rez.add(i)
                } catch (e: NumberFormatException) {
                    println(
                        """
                        "${str}" is not a long. It will be skipped.
                    """.trimIndent()
                    )
                }
            }
        }
    }

    override fun printSortNaturally() {
        printList(sort(rez), "numbers", " ", outputFile)
    }

    override fun printSortCount() {
        printCountList(countSort(rez),outputFile)
    }

    override fun toString(): String {
        val max = rez.maxOrNull()
        val maxCount = rez.count { i -> i == max }
        return """ 
            Total numbers: ${rez.size}.
            The greatest number: $max ($maxCount time(s), ${maxCount * 100 / rez.size}%).
            """.trimIndent()
    }


}