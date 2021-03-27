package sorting

class Word: SortItem{
    var rez = mutableListOf<String>()

    init {
        val input = input()
        for (s in input) {
            rez.addAll(s.split("""\s+""".toRegex()))
        }
    }
    override fun printSortNaturally() {
        printList(sort(rez), "words", " ")
    }

    override fun printSortCount() {
        printCountList(countSort(rez))
    }

    override fun toString(): String {
        val max = rez.maxOf { s -> s.length }
        val maxArr = rez.filter { s -> s.length == max }
        return """
            Total words: ${rez.size}.
            The longest word: ${maxArr.joinToString(" ")} (${maxArr.size} time(s), ${maxArr.size*100/rez.size}%).
        """.trimIndent()
    }


}
