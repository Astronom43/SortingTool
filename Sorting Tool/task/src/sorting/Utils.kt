package sorting

import java.io.File
import java.util.*

fun input(inputFile: String): MutableList<String> {
    val listStr = mutableListOf<String>()
    when{
        inputFile.isBlank() ->{
            val scanner = Scanner(System.`in`)

            while (true) {
                if (!scanner.hasNext()) break
                val str = scanner.nextLine()
                listStr.add(str)
            }
            scanner.close()
        }
        else ->{
            val file = File(inputFile)
            listStr.addAll(file.readLines())
        }
    }




    return listStr
}

fun <T : Comparable<T>> sort(list: MutableList<T>): MutableList<T> {
    if (list.size < 2) {
        return list
    }
    val median = list.size / 2
    val listA = list.subList(0, median)
    val listB = list.subList(median, list.size)

    val listA1 = sort(listA)
    val listB1 = sort(listB)
    val rez = merge(listA1, listB1)

    return rez
}

fun <T : Comparable<T>> merge(listA: MutableList<T>, listB: MutableList<T>): MutableList<T> {
    val rez = mutableListOf<T>()
    var posA = 0
    var posB = 0
    while (posA < listA.size && posB < listB.size) {
        if (listA[posA] < listB[posB]) {
            rez.add(listA[posA])
            posA++
        } else {
            rez.add(listB[posB])
            posB++
        }
    }
    while (posA < listA.size) {
        rez.add(listA[posA])
        posA++
    }
    while (posB < listB.size) {
        rez.add(listB[posB])
        posB++
    }
    return rez
}

fun <T : Comparable<T>> countSort(rez: MutableList<T>): MutableList<MyPair<T>> {
    val tempPairList = mutableListOf<MyPair<T>>()
    val tempMap = mutableMapOf<T, Int>()
    rez.forEach { i -> tempMap[i] = tempMap.getOrDefault(i, 0) + 1 }
    tempMap.forEach { t, u -> tempPairList.add(MyPair(t, u)) }
    tempPairList.sort()
    return tempPairList

}
