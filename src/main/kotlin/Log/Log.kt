package Log

object Log{

    private var visibility = false

    fun setVisibility(flag: Boolean){
        visibility = flag
    }

    fun d(tag: String, msg: String){
        if(visibility){
            println("$tag: $msg")
        }
    }
}