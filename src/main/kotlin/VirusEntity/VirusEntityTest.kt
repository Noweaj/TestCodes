package VirusEntity

fun main(){

    val manager = VirusEntityManager.getInstance()

    manager.add(
        VirusEntity(
            name = "Virus1",
            collection_name = "virus",
            created_at = "",
            method = "",
            id = "",
            app_icon = 1
        )
    )
    manager.print()
    manager.add(
        VirusEntity(
            name = "Virus2",
            collection_name = "white",
            created_at = "",
            method = "",
            id = "",
            app_icon = 1
        )
    )
    manager.add(
        VirusEntity(
            name = "Virus3",
            collection_name = "white",
            created_at = "",
            method = "",
            id = "",
            app_icon = 1
        )
    )
    manager.add(
        VirusEntity(
            name = "Virus4",
            collection_name = "virus",
            created_at = "",
            method = "",
            id = "",
            app_icon = 1
        )
    )
    manager.print()

    println(manager.getWhiteList())
}