package sorting

fun main(args: Array<String>) {
    parseArg(args)
    when {
        args.contains("long") -> {
            val l = MyLong()
            action(args, l)
        }
        args.contains("line") -> {
            val l = Line()
            action(args, l)
        }
        args.contains("word") -> {
            val l = Word()
            action(args, l)
        }
        else -> {
            print("No data type defined!")
        }
    }

}

fun parseArg(args: Array<String>) {
    val reg = "-[a-zA-Z]+".toRegex()
    val trueArgs = "-sortingType -dataType -inputFile -outputFile".split(" ")
    args.filter { s -> reg.matches(s) }
        .filter { s -> !trueArgs.contains(s) }
        .forEach { s -> println("""
            "$s" is not a valid parameter. It will be skipped.
        """.trimIndent()) }
}

private fun action(args: Array<String>, l: SortItem) {
    if (args.contains("-sortingType")) {
        if (args.contains("byCount")) {
            l.printSortCount()
        } else if (args.contains("natural")) {
            l.printSortNaturally()
        } else{
            print("No sorting type defined!")
        }
    } else {
        l.printSortNaturally()
    }
}
