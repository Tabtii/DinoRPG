package Klassen

// Code von ChatGPT
class Item(name: String, val wert: Int, val effekt: Int, val beschreibung: String) {
    var name = name
        private set

    constructor() : this("", 0, 0, "")

    companion object {
        fun zufallItem(): Item {
            val i = (0..100).random()
            return when (i) {
                in 0..20 -> Item("Medkit", 100, 50, "Heilt Nutzer um 50 LP.")
                in 21..70 -> Item("Stein", 10, 20, "Ein einfacher Stein vom Wegesrand. Verursacht Schaden.")
                in 71..90 -> Item(
                    "Stück Fleisch",
                    50,
                    20,
                    "Lenkt einen Gegner ab. Senkt Verteidigung, heilt das Ziel."
                )

                else -> Item("Granate", 200, 200, "Macht bumm.")
            }
        }
    }
}

