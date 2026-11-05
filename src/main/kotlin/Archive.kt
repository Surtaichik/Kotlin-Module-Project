
class Archive(val name: String) {
    private val _notes = mutableListOf<String>()

    val notes: List<String> get() = _notes

    fun addNote(text: String) = _notes.add(text)

    fun editNote(index: Int, newText: String) {
        if (index in _notes.indices) {
            _notes[index] = newText
        }
    }

}