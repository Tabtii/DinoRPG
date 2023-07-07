package Klassen

open class Held() : Charakter() {

    fun heldenWahl(): Held {
        var char = Held()
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
                char.maxLP = char.lp
                char.maxAtk = char.atk
                char.maxVer = char.ver
                char.maxGeschF = char.geschF
                char.maxGeschN = char.geschN
            }

            "2" -> {
                char.name = "Ranger"
                char.lp = 100
                char.atk = 80
                char.ver = 40
                char.geschF = 70
                char.geschN = 70
                char.maxLP = char.lp
                char.maxAtk = char.atk
                char.maxVer = char.ver
                char.maxGeschF = char.geschF
                char.maxGeschN = char.geschN
            }

            "3" -> {
                char.name = "Mercenary"
                char.lp = 100
                char.atk = 100
                char.ver = 60
                char.geschF = 10
                char.geschN = 90
                char.maxLP = char.lp
                char.maxAtk = char.atk
                char.maxVer = char.ver
                char.maxGeschF = char.geschF
                char.maxGeschN = char.geschN
            }

            "4" -> {
                char.name = "Medic"
                char.lp = 150
                char.atk = 25
                char.ver = 150
                char.geschF = 50
                char.geschN = 25
                char.maxLP = char.lp
                char.maxAtk = char.atk
                char.maxVer = char.ver
                char.maxGeschF = char.geschF
                char.maxGeschN = char.geschN
            }

        }
        println()
        return char
    }

    fun heldErstellen(): Held {
        println("Wie willst du genannt werden?")
        var char = Held()
        char.name = readln()
        char.lp = (100..150).random()
        char.atk = (70..150).random()
        char.ver =(70..150).random()
        char.geschF = (70..150).random()
        char.geschN = (70..150).random()
        char.maxLP = char.lp
        char.maxAtk = char.atk
        char.maxVer = char.ver
        char.maxGeschF = char.geschF
        char.maxGeschN = char.geschN
        return char
    }

}