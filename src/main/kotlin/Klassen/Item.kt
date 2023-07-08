package Klassen

//class Item() {
//      constructor(name: String, wert: Int, effekt: Int, beschreibung: String) : this()
//    var name = ""
//    var effekt = 0
//    var beschreibung = ""
//    fun zufallItem(): Item {
//    var i = (0..100).random()
//        var item = Item()
//        when(i){
//            in 0..20 -> item = Item("Medkit", 100,50,"Heilt Nutzer um 50 LP.")
//            in 21..70 -> item = Item("Stein",10,20,"Ein einfacher Stein vom Wegesrand. Verursacht schaden.")
//            in 71..90 -> item = Item("Stück Fleisch",50,20,"Lenkt ein Gegner ab. Senkt Verteidigung , heilt aber das Ziel.")
//            in 91..100 -> item = Item("Granate",200,100,"Macht bumm")
//        }
//        return item
//    }
//
//}


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
                    "Lenkt einen Gegner ab. Senkt Verteidigung deutlich, heilt aber das Ziel minimal."
                )

                else -> Item("Granate", 200, 100, "Macht bumm")
            }
        }
    }
}

