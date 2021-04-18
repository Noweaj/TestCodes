package General

fun main(){
    val item1 = arrayListOf(1, 2, 3)
    val item2 = arrayListOf(4, 5, 6)
    val item3 = arrayListOf(8, 9, 10)

    val item4 = addAll(item1, item2, item3)
    println(item4)
}

private fun addAll(vararg items: ArrayList<Int>): ArrayList<Int>{
    val ret = ArrayList<Int>()
    for(i in items.indices){
        ret.addAll(items[i])
    }
    return ret
}