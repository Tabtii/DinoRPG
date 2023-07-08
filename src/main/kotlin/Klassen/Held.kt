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
                char.lp = (100..150).random()
                char.atk = (70..100).random()
                char.ver = (50..70).random()
                char.geschF = (70..110).random()
                char.geschN = (10..50).random()
                char.maxLP = char.lp
                char.maxAtk = char.atk
                char.maxVer = char.ver
                char.maxGeschF = char.geschF
                char.maxGeschN = char.geschN
                char.showStats()
                Thread.sleep(1000)
            }

            "2" -> {
                char.name = "Ranger"
                char.lp = (120..170).random()
                char.atk = (70..80).random()
                char.ver = (70..75).random()
                char.geschF = (70..90).random()
                char.geschN = (70..90).random()
                char.maxLP = char.lp
                char.maxAtk = char.atk
                char.maxVer = char.ver
                char.maxGeschF = char.geschF
                char.maxGeschN = char.geschN
                char.showStats()
                Thread.sleep(1000)

            }

            "3" -> {
                char.name = "Mercenary"
                char.lp = (140..180).random()
                char.atk = (80..100).random()
                char.ver = (80..90).random()
                char.geschF = (0..20).random()
                char.geschN = (70..110).random()
                char.maxLP = char.lp
                char.maxAtk = char.atk
                char.maxVer = char.ver
                char.maxGeschF = char.geschF
                char.maxGeschN = char.geschN
                char.showStats()
                Thread.sleep(1000)
            }

            "4" -> {
                char.name = "Medic"
                char.lp = (170..220).random()
                char.atk = (10..60).random()
                char.ver = (70..90).random()
                char.geschF = (40..90).random()
                char.geschN = (40..90).random()
                char.maxLP = char.lp
                char.maxAtk = char.atk
                char.maxVer = char.ver
                char.maxGeschF = char.geschF
                char.maxGeschN = char.geschN
                char.showStats()
                Thread.sleep(1000)
            }

            else -> {
                println("Falsche Eingabe")
                heldenWahl()
            }

        }
        println()
        return char
    }

    fun heldErstellen(): Held {
        println("Wie heißt du?")
        var char = Held()
        char.name = readln()
        char.lp = (100..150).random()
        char.atk = (70..100).random()
        char.ver = (70..100).random()
        char.geschF = (70..110).random()
        char.geschN = (70..110).random()
        char.maxLP = char.lp
        char.maxAtk = char.atk
        char.maxVer = char.ver
        char.maxGeschF = char.geschF
        char.maxGeschN = char.geschN
        char.showStats()
        Thread.sleep(1000)
        return char
    }

}