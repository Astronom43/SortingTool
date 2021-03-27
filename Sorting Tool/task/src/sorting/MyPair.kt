package sorting

class MyPair<T:Comparable<T>>(val value: T, var count: Int = 1) : Comparable<MyPair<T>> {
    override fun compareTo(other: MyPair<T>): Int {
        return when {
            this.count.compareTo(other.count) != 0 -> this.count.compareTo(other.count)
            else -> this.value.compareTo(other.value)
        }
    }


}