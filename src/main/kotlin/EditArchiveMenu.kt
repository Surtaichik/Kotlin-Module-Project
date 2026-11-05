class EditArchiveMenu(val archive : Archive) : Menu(archive.name) {

    init {
        items.add(MenuItem("New Note", { addNewNote()}))
        archive.notes.forEachIndexed {
            i, item -> items.add(MenuItem(item,{editNote(items.size - 1, i, item)})) }
    }

    private fun editNote(indexMenu: Int, i: Int, item: String )
    {
        println("Current note:'$item'")
        val newNote = InputerString("Enter a new Note")

        archive.editNote(i, newNote)

        items[indexMenu] = MenuItem(newNote,{editNote(indexMenu, i, newNote)})
    }

    private fun addNewNote()
    {
        val newNote = InputerString("Enter a Note")

        archive.addNote(newNote)
        val indexMenu = items.size
        items.add(MenuItem(newNote, { editNote(indexMenu,  archive.notes.lastIndex ,newNote)}))
    }
}