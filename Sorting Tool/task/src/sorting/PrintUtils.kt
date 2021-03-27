package sorting

fun <T> printList(rez: MutableList<T>, itemName: String, separator: String = "\n") {
    print(
        """
            Total $itemName: ${rez.size}.
            Sorted data:$separator${rez.joinToString(separator)}
        """.trimIndent()
    )
}

fun <T : Comparable<T>> printCountList(rez: MutableList<MyPair<T>>) {
    var totalNumber = 0
    rez.forEach { p -> totalNumber += p.count }
    println("Total numbers: $totalNumber.")
    for (p in rez) {
        println("${p.value}: ${p.count} time(s), ${Math.round(p.count * 100.00 / totalNumber)}%")
    }
}
