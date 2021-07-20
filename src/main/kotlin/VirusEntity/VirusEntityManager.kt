package VirusEntity


const val FIELD_NAME = "name"
const val FIELD_COLLECTION_NAME = "collection_name"
const val FIELD_CREATED_AT = "created_at"
const val FIELD_METHOD = "method"
const val FIELD_ID = "id"

class VirusEntityManager {

    companion object{
        @Volatile private var instance: VirusEntityManager? = null
        fun getInstance(): VirusEntityManager{
            return instance?: synchronized(this){
                instance ?: VirusEntityManager().also {
                    instance = it
                }
            }
        }
    }

    private val detectedList = mutableListOf<VirusEntity>()

    fun add(entity: VirusEntity): Boolean{
        val idx = getIndex(entity.name)
        if(entity.method != "delete") {
            return if (idx == -1) {
                // add new
                detectedList.add(entity)
                true
            } else {
                // update exist
                detectedList.removeAt(idx)
                detectedList.add(idx, entity)
                false
            }
        }
        return false
    }

    fun remove(packageName: String): Boolean {
        val idx = getIndex(packageName)
        if(idx != -1){
            detectedList.removeAt(idx)
            return true
        }
        return false
    }

    fun remove(entity: VirusEntity): Boolean{
        val idx = getIndex(entity.name)
        if(idx != -1) {
            detectedList.removeAt(idx)
            return true
        }
        return false
    }

    fun size(): Int{
        return detectedList.size
    }

    fun clear(){
        detectedList.clear()
    }

    fun getVirusList(): List<VirusEntity> {
        val newList = mutableListOf<VirusEntity>()
        for(i in detectedList.indices){
            if(detectedList[i].collection_name == "virus" &&
                detectedList[i].collection_name != "delete")
                newList.add(detectedList[i])
        }
        return newList
    }

    fun getWhiteList(): List<VirusEntity> {
        val newList = mutableListOf<VirusEntity>()
        detectedList.forEach{
            if(it.collection_name == "white" && it.collection_name != "delete")
                newList.add(it)
        }
        return newList
    }

    fun getAll(): List<VirusEntity> {
        return detectedList
    }

//    fun getEntityAsJson(packageName: String): JSONObject? {
//        val idx = getIndex(packageName)
//        if(idx != -1) {
//            return JSONObject()
//                .put(FIELD_NAME, detectedList[idx].name)
//                .put(FIELD_COLLECTION_NAME, detectedList[idx].collection_name)
//                .put(FIELD_CREATED_AT, detectedList[idx].created_at)
//                .put(FIELD_METHOD, detectedList[idx].method)
//                .put(FIELD_ID, detectedList[idx].id)
//        }
//        return null
//    }

    fun getEntity(packageName: String): VirusEntity? {
        val idx = getIndex(packageName)
        if(idx != -1){
            return detectedList[idx]
        }
        return null
    }

//    fun uninstall(packageName: String, context: Context){
//        context.startActivity(Intent(Intent.ACTION_DELETE).apply {
//            data = "package:$packageName".toUri()
//        })
//    }

    fun getIndex(name: String): Int {
        for(i in detectedList.indices){
            if(name == detectedList[i].name)
                return i
        }
        return -1
    }

    fun print(){
        println("println")
        println(detectedList.toString())
    }
}