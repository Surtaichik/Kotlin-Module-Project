
import java.util.Scanner

open class Menu (val name: String){

    protected val items = mutableListOf<MenuItem>()

    data class MenuItem(val label: String, val action: () -> Unit)

    fun addItem(label: String, action: () -> Unit) {
        items.add(MenuItem(label, action))
    }

    fun show() {
        while (true) {
            println("=== $name ===")

            items.forEachIndexed { i, item -> println("${i + 1}. ${item.label}") }

            val exitIndex = items.size + 1
            println("${exitIndex}. Exit")


            val choice = Inputer() ?: continue

            when {
                choice == exitIndex -> return
                choice in 1..items.size -> items[choice - 1].action()
                else -> {
                    println("No this menu item.")
                }
            }
        }
    }

    fun Inputer() : Int?{
        val input = Scanner(System.`in`).nextLine()
        val choice = input.toIntOrNull()
        if (choice == null)
        {
            println("menu item is 1 to ${items.size + 1}.")
        }
        return choice
    }

    protected fun InputerString(message : String) : String{

        println(message)
        val input = Scanner(System.`in`).nextLine().trim()

        if (input.equals(""))
        {
            println("Value should not be Empty")
            return InputerString(message)
        }
        return input
    }

}