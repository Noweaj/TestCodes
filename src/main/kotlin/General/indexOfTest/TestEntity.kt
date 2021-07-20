package General.indexOfTest

data class TestEntity(
    val name: String,
    val method: String,
    val value: Int
){
    override fun equals(other: Any?): Boolean {
        return (other as TestEntity).name == name
    }
}