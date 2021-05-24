package General.nhnAssignment.http

data class HttpRequest(
        val method: String,
        val url: String,
        val header: HashMap<String, String>?,
        val body: String,
        val connectTimeout: Int
)