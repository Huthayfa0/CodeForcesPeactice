package BLevel


fun main() {
    // read input
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val map= readLine()!!.split(" ").mapIndexed { index, str -> (index+1).toString()[0] to str.toInt() }.toMap()
    // define local function f
    fun f(c: Char) = map[c]!!
    // greedily find first and last indices
    val i = s.indexOfFirst { c -> f(c) > c-'0' }
        .takeIf { it >= 0 } ?: s.length
    val j = s.withIndex().indexOfFirst { (j, c) -> j > i && f(c) < c-'0' }
        .takeIf { it >= 0 } ?: s.length
    // compose and write the answer
    val ans =
        s.substring(0, i) +
                s.substring(i, j).map { c -> f(c) }.joinToString("") +
                s.substring(j)
    println(ans)
}
