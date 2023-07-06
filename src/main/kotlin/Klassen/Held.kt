package Klassen

class Held() : Charakter() {
    override var maxLP = 0
    constructor(name:String,lp: Int,atk:Int,ver: Int, geschF :Int, geschN : Int): this()

    fun heldenWahl(): Charakter {
        var char = Charakter()
        println("Wer soll ihnen Helfen?")
        println("--1-- Hunter // Sehr Geschickt im Umgang mit Fernkampfwaffen.")
        println("--2-- Ranger // Gut im Nah- und Fernkampf.")
        println("--3-- Mercenary // Furchtlos und stark im Nahkampf.")
        println("--4-- Medic // Ratet mal was er macht.")
        println("Wer soll dich begleiten?(1-4)")
        var eingabe = readln()
        when (eingabe) {
            "1" -> {
                char.name = "Hunter"
                char.lp = 100
                char.atk = 80
                char.ver = 50
                char.geschF = 100
                char.geschN = 20
                char.maxLP =char.lp
            }
            "2" -> {
                char.name = "Ranger"
                char.lp = 100
                char.atk = 80
                char.ver = 40
                char.geschF = 70
                char.geschN = 70
                char.maxLP =char.lp
            }
            "3" -> {
                char.name = "Mercenary"
                char.lp = 100
                char.atk = 100
                char.ver = 60
                char.geschF = 10
                char.geschN = 90
                char.maxLP =char.lp
            }
            "4" -> {
                char.name = "Medic"
                char.lp = 150
                char.atk = 25
                char.ver = 150
                char.geschF = 50
                char.geschN = 25
                char.maxLP =char.lp
            }
        }

        return char
    }



}