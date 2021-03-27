package sorting

fun main(args: Array<String>) {

    parseArg(args)
    val (inputName, outputName) = parseFileNames(args)

    when {
        args.contains("long") -> {
            val l = MyLong(inputName,outputName)
            action(args, l)
        }
        args.contains("line") -> {
            val l = Line(inputName,outputName)
            action(args, l)
        }
        args.contains("word") -> {
            val l = Word(inputName,outputName)
            action(args, l)
        }
        inputName.isNotBlank() ->{
            val l = MyLong(inputName,outputName)
            action(args, l)
        }
        else -> {

            print("No data type defined!")
        }
    }

}

fun parseFileNames(args: Array<String>): List<String> {
    var rez= mutableListOf("","")
    if (args.contains("-inputFile")){
        rez[0]= args[args.indexOf("-inputFile")+1]
    }
    if (args.contains("-outputFile")){
        rez[1] = args[args.indexOf("-outputFile")+1]
    }
    return rez
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
