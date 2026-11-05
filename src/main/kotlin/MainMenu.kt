
class MainMenu() : Menu("Archives") {

    private val archives = mutableListOf<Archive>()

    init {
            items.add(MenuItem("New Archive", { addNewArchive()}))
        }

    private fun addNewArchive()
    {
        println("Create Archive")
        val newArchive = createArchive()
        archives.add(newArchive)
        super.addItem(newArchive.name,{ editArchive(newArchive)} )
    }

    private fun editArchive(archive: Archive)
    {
        val editMenu = EditArchiveMenu(archive)
        editMenu.show()
    }

    private fun createArchive() : Archive
    {
        val name = InputerString("Enter a name")

        return  Archive(name)
    }

}