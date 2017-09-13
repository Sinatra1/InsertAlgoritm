import java.io.File

fun main(args: Array<String>) {
    var lines = File("input.txt").readLines()

    var n = lines[0].toInt() - 1

    var A = lines[1].split(" ").toTypedArray()

    var indexes: ArrayList<Int> = ArrayList<Int>()

    var i = 0

    indexes.add(1)

    for (j in 1 .. n) {
        i = j

        while (i > 0 && A[i-1].toLong() > A[i].toLong()) {
            A = swap(A, i-1, i)
            i = i - 1
        }

        indexes.add(i+1)
    }

    File("output.txt").createNewFile()
    File("output.txt").writeText(indexes.joinToString(" ") + "\n" + A.joinToString(" "))
}

fun swap(A: Array<String>, indexA: Int, indexB: Int): Array<String> {
    var tmp = A[indexA]
    A[indexA] = A[indexB]
    A[indexB] = tmp

    return A
}