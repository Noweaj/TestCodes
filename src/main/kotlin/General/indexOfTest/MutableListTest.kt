package General.indexOfTest

fun main(){
    val mList = mutableListOf<TestEntity>(
        TestEntity(name = "name1", method = "GET", value = 1),
        TestEntity(name = "name2", method = "PUT", value = 2),
        TestEntity(name = "name3", method = "GET", value = 3)
    )

    val idx = mList.indexOf(
        TestEntity("name2", "GET", 4)
    )
    println(idx)
}