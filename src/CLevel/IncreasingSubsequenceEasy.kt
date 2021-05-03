package CLevel

fun main() {
    val n= readLine()!!.toInt()
    val arr= readLine()!!.split(" ").map { it.toInt() }
    val str=CharArray(n)
    var l=0
    var r=arr.size-1
    var count=0
    var x=-1
    for (i in arr.indices){
        when{
            arr[l]>x&&arr[r]>x->str[i]=if (arr[l]<arr[r]){x=arr[l];l++;'L'} else {x=arr[r];r--;'R'}
            arr[l]>x->{x=arr[l];l++;str[i]='L'}
            arr[r]>x->{x=arr[r];r--;str[i]='R'}
            else-> break
        }
        count++
    }
    println(count)
    println(str.slice(0 until count).joinToString(""))
}