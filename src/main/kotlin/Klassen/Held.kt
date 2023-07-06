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

    fun heldErstellen(): Charakter {
        println("Wie willst du genannt werden?")
        this.name = readlnOrNull() ?: ""

        println("Was ist deine Stärke?")
        println("--1-- Angreifen")
        println("--2-- Verteidigen")
        println("--3-- Unterstützen")
        println("Wähle mit Sorgfalt, es bestimmt deine Werte.")

        var eingabe: Int
        do {
            eingabe = readlnOrNull()?.toIntOrNull() ?: 0

            when (eingabe) {
                1 -> {
                    this.lp = (70..101).random()
                    this.atk = (100..110).random()
                    this.ver = (20..51).random()
                    this.geschF = (100..110).random()
                    this.geschN = (100..110).random()
                    this.maxLP = lp
                    this.maxAtk = atk
                    this.maxVer = ver
                    this.maxGeschF = geschF
                    this.maxGeschN = geschN
                }

                2 -> {
                    this.lp = (170..200).random()
                    this.atk = (25..75).random()
                    this.ver = (75..110).random()
                    this.geschF = (10..50).random()
                    this.geschN = (10..50).random()
                    this.maxLP = lp
                    this.maxLP = lp
                    this.maxAtk = atk
                    this.maxVer = ver
                    this.maxGeschF = geschF
                    this.maxGeschN = geschN
                }

                3 -> {
                    this.lp = (100..120).random()
                    this.atk = (60..80).random()
                    this.ver = (60..80).random()
                    this.geschF = (60..80).random()
                    this.geschN = (60..80).random()
                    this.maxLP = lp
                    this.maxLP = lp
                    this.maxAtk = atk
                    this.maxVer = ver
                    this.maxGeschF = geschF
                    this.maxGeschN = geschN
                }

                else -> {
                    println("Falsche Eingabe. Bitte versuche es erneut.")
                    println()
                }
            }
            println()
            Thread.sleep(1000)
        } while (eingabe !in 1..3)

        return this
    }

}