package sorting

import java.io.File

fun <T> printList(rez: MutableList<T>, itemName: String, separator: String = "\n", outputFile: String) {
    val rez = """
            Total $itemName: ${rez.size}.
            Sorted data:$separator${rez.joinToString(separator)}
        """.trimIndent()
    if (outputFile.isBlank()) {
        print(rez)
    } else {
        val file = File(outputFile)
        file.writeText(rez)
    }

}

fun <T : Comparable<T>> printCountList(rez: MutableList<MyPair<T>>, outputFile: String) {
    var totalNumber = 0
    rez.forEach { p -> totalNumber += p.count }
    val builder = StringBuilder()
    builder.append("Total numbers: $totalNumber.").append("\n")
    for (p in rez) {
        builder.append("${p.value}: ${p.count} time(s), ${Math.round(p.count * 100.00 / totalNumber)}%").append("\n")
    }
    val rez = builder.toString()
    if (outputFile.isBlank()) {
        print(rez)
    } else {
        val file = File(outputFile)
        file.writeText(rez)
    }
}
